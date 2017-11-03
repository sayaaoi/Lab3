import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

/**
 * Lab3 project.
 * @author amberwu
 *
 */
public class TracePoints {
    /**
     * Website URL.
     */
    private static final String WEBSITE_URL = "http://erdani.com/tdpl/hamlet.txt";

    /**
     *
     */
    private static final String WORD = "prince";

    /**
     * print out a txt file.
     * @param args website url
     */
    public static void main(final String[] args) {
        String textFile = urlToString(WEBSITE_URL);
        String[] word = textFile.trim().split("\\s+");
        System.out.println("There are " + word.length + " words in this file.");

        String editFile = textFile.replace("'", "");
        String cleanFile = editFile.replaceAll("[^A-Za-z]+", " ");
        //String cleanFile = editFile.replaceAll("\\p{P}", "");
        String[] rawWord = cleanFile.trim().split("\\s+");
        Set<String> uniqueword = new HashSet<String>();
        for (int i = 0; i < rawWord.length; i++) {
            uniqueword.add(rawWord[i]);
        }
        int length = uniqueword.size();
        System.out.println("There are " + length + " unique words in this file.");


        int count = 0;
        for (int i = 0; i < rawWord.length; i++) {
            if (rawWord[i].toLowerCase().equals(WORD)) {
                count += 1;
            }
        }
        System.out.println(WORD + " shows up " + count + " times");
    }


    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
