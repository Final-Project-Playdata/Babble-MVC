package babble.util;

public class AudioUtil {

	public boolean checkPath(String path, String username) {
		String[] seperatedName = path.split(".");
		if (!path.contains("..") || (seperatedName[0] + "." + seperatedName[2]).equals(username + ".wav")) {
			return true;
		}
		return false;
	}

}
