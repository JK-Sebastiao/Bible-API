package group.jkiakumbo.bibleAPI.util;

public class BibleAPIStringUtil {
	
	public static String capitalize(String text) {
		String capitalizedText = "";
		String [] texts = text.split(" ");
		for (String txt : texts)
			capitalizedText += String.format("%s %s", txt.substring(0,1).toUpperCase(), txt.substring(1).toLowerCase());
		return capitalizedText;
	}

}
