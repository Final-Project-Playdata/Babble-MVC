package babble.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import babble.config.auth.PrincipalDetails;
import babble.dto.PostDto;

@RestController
public class AudioController {

	@PostMapping("audio")
	public void saveAudio() {

	}

	@GetMapping
	public String index() {
		return "upload";
	}

	@PostMapping("upload")
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		byte[] data = file.getBytes();

		return "성공";
	}

	@PostMapping("upload1")
	public String fileUpload1(@RequestParam("file") MultipartFile file, @RequestParam("test") String t)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PostDto postDto = mapper.readValue(t, PostDto.class);
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		System.out.println(postDto.getUser().getUsername());
		System.out.println(postDto.getUser().getAvatar());
		File testFile = new File(file.getOriginalFilename());
		testFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(testFile);
		fos.write(file.getBytes());
		fos.close();
		float duration = getDuration(testFile);
		System.out.println(duration);

		return "성공";
	}

	private static float getDuration(File file) throws Exception {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audioInputStream.getFormat();
		long audioFileLength = file.length();
		int frameSize = format.getFrameSize();
		float frameRate = format.getFrameRate();
		float durationInSeconds = (audioFileLength / (frameSize * frameRate));
		return (durationInSeconds);
	}

	@PostMapping("upload2")
	public String fileUpload2(@RequestParam("file") MultipartFile file, @RequestParam("test") PostDto t)
			throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		PostDto postDto = mapper.readValue(t, PostDto.class);
		System.out.println(t.getUser().getUsername());
		File testFile = new File(file.getOriginalFilename());
		file.transferTo(testFile);
		float duration = getDuration(testFile);
		System.out.println(duration);

		return "성공";
	}

	@PostMapping("upload3")
	public String fileUpload3(@RequestParam("file") MultipartFile file, @RequestParam("test") String t,
			@AuthenticationPrincipal PrincipalDetails p) throws Exception {
		String uploadFolder = "C:/audiotest";
		
		//파일명 검증(해킹이나 오류 막기위해)
		String originalFilename = file.getOriginalFilename();
		if(originalFilename.contains("..")) {
			throw new Exception("올바르지 않은 파일명입니다.");
		}

		// 폴더 생성
		File uploadPath = new File(uploadFolder + "/" + p.getUsername(), getFolder());
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// 파일 이름 재설정
		String uploadFilename = p.getUsername() + "." + LocalDateTime.now();
		
		// 파일 이름 정리
		uploadFilename = uploadFilename.replace(":", "-");
		
		// 파일 경로 정리
		String fileFullPath = uploadPath + "/" + uploadFilename;
		fileFullPath = fileFullPath.replace(".wav", "");
		fileFullPath = fileFullPath + ".wav";

		// 저장
		Path saveTO = Paths.get(fileFullPath);
		Files.copy(file.getInputStream(), saveTO);

		return "성공";
	}

	private String getFolder() {
		return LocalDate.now().toString().replace("-", File.separator);
	}

//	public void saveFiole(MultipartFile file, String directoryPath) throws IOException {
//		// parent directory를 찾는다.
//		Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();
//
//		// directory 해당 경로까지 디렉토리를 모두 만든다.
//		Files.createDirectories(directory);
//	    
//		// 파일명을 바르게 수정한다.
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//		// 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
//		Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
//		// 파일을 저장할 경로를 Path 객체로 받는다.
//		Path targetPath = directory.resolve(fileName).normalize();
//
//		// 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
//		Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
//		file.transferTo(targetPath);
//	}
}
