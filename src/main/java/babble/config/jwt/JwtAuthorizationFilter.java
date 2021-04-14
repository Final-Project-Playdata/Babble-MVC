package babble.config.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import babble.config.auth.PrincipalDetails;
import babble.dao.UserRepository;
import babble.entity.User;

// 인가
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	@Autowired
	private UserRepository userRepository;

	private static String getUserIp(HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
	}

	public static String getUserAgent(HttpServletRequest request) {
	    String ua = "";
	    if (request != null) {
	        ua = request.getHeader("User-Agent");
	    }
	    return ua;
	}
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
		super(authenticationManager);
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("authorizationfilter?");
		String header = request.getHeader(JwtProperties.HEADER_STRING);
		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		System.out.println("header : " + header);
		String token = request.getHeader(JwtProperties.HEADER_STRING).replace(JwtProperties.TOKEN_PREFIX, "");

		// 토큰 검증 (이게 인증이기 때문에 AuthenticationManager도 필요 없음)
		// 내가 SecurityContext에 집적접근해서 세션을 만들때 자동으로 UserDetailsService에 있는
		// loadByUsername이 호출됨.
		DecodedJWT jwtToken = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token);
		String username = jwtToken.getClaim("username").asString();
		String jwtUserIp = jwtToken.getClaim("ip").asString();
		String jwtUserAgent = jwtToken.getClaim("User-Agent").asString();
		
		String requestIp = getUserIp(request);
		String requestUserAgent = getUserAgent(request);
		
		if (username != null && jwtUserIp.equals(requestIp) && jwtUserAgent.equals(requestUserAgent)) {
			User user = getUser(username);

			// 인증은 토큰 검증시 끝. 인증을 하기 위해서가 아닌 스프링 시큐리티가 수행해주는 권한 처리를 위해
			// 아래와 같이 토큰을 만들어서 Authentication 객체를 강제로 만들고 그걸 세션에 저장!
			PrincipalDetails principalDetails = new PrincipalDetails(user);
			Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null,
					principalDetails.getAuthorities());

			// 강제로 시큐리티의 세션에 접근하여 값 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		chain.doFilter(request, response);
	}
	
	@Transactional
	public User getUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

}
