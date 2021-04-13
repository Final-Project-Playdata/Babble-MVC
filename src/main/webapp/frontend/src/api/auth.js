// 로그인, 회원 가입, 회원 탈퇴
import { instance } from './index';

// 회원가입 API
function signUp(data) {
	return instance.post('/signup', data);
}

// 약관동의 API
function memberAgreeUser(data) {
	return instance.post('MemberAgree', data);
}

// 로그인 API
function signIn(data) {
	return instance.post('/login', data);
}

// 전체회원정보 get API
function allClient(data) {
	return instance.get('/getMemberList', data);
}

//로그아웃
function logout(userData) {
	return instance.post('/logout', userData);
}

export { signUp, signIn, memberAgreeUser, allClient, logout };
