package babble.util;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.springframework.web.multipart.MultipartFile;

public class AudioUtil {

	public float getDuration(MultipartFile file) throws Exception {
		File testFile = new File(file.getOriginalFilename());
		testFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(testFile);
		fos.write(file.getBytes());
		fos.close();

		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(testFile);
		AudioFormat format = audioInputStream.getFormat();
		long audioFileLength = testFile.length();
		int frameSize = format.getFrameSize();
		float frameRate = format.getFrameRate();
		float durationInSeconds = audioFileLength / (frameSize * frameRate);
		return durationInSeconds;
	}

	public String getFolder() {
		return LocalDate.now().toString().replace("-", File.separator);
	}

	public String saveAudioFile(MultipartFile file, String username) throws Exception {

		String uploadFolder = "C:/audiotest";

		// 파일명 검증(해킹이나 오류 막기위해)
		String originalFilename = file.getOriginalFilename();
		if (originalFilename.contains("..")) {
			throw new Exception("올바르지 않은 파일명입니다.");
		}

		// 폴더 생성
		File uploadPath = new File(uploadFolder + "/" + username, getFolder());
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// 파일 이름 재설정
		String uploadFilename = username + "." + LocalDateTime.now();
		uploadFilename = uploadFilename.replace(":", "-");

		// 파일 경로 정리
		String fileFullPath = uploadPath + "/" + uploadFilename;
		fileFullPath = fileFullPath.replace(".wav", "");
		fileFullPath = fileFullPath + ".wav";

		// 저장
		Path saveTO = Paths.get(fileFullPath);
		Files.copy(file.getInputStream(), saveTO);

		return fileFullPath;
	}

}
