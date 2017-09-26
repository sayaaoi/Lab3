import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Lab3 project.
 * @author amberwu
 *
 */
public class Trace_Points {
    /**
     * print out a txt file.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int numberOfWords = 0;
        String textFile = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String alphabetStay = textFile.replaceAll("[^A-Za-z]+", " ");
        String[] word = alphabetStay.split(" ");
        System.out.println(word[0]);
            for (int element = 0; 0 < word.length; element++) {
                if (!word[element].equals(" ")) {
                    numberOfWords++;
                }
            }
            //System.out.println(numberOfWords);
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
