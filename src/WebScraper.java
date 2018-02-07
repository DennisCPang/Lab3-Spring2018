
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class WebScraper {
    public static void main(String[] unused) {
        System.out.println(oneWordCount("http://erdani.com/tdpl/hamlet.txt","hamlet"));
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
     public static int wordCount(String text) {
        text = urlToString(text);
        String[] wordArray = text.split(" ");
       ArrayList<String> wordLister = new ArrayList<>();
       for(int i = 0; i<wordArray.length; i++) {
            if( !wordArray[i].equals(" ")){
                wordLister.add(wordArray[i]);
            }
       }
       return wordLister.size();
    }
    public static int oneWordCount(String text, String word){
        text = urlToString(text);
        String[] wordArray = text.split(" ");
        ArrayList<String> wordLister = new ArrayList<>();
        for(int i = 0; i<wordArray.length; i++) {
            if( wordArray[i].toUpperCase().equals(word.toUpperCase())){
                wordLister.add(wordArray[i]);
            }
        }
        return wordLister.size();
    }
}
