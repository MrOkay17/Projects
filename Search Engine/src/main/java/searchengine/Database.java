package searchengine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

 /**
   * Class that reads the specified data file and build the inverted index to be used in the Search class.
   */
public class Database {

  // FIELDS
  private Map<String, Map<String, Page>> index;
  private static Map<String, Integer> wordCount;
  private static int numPages;

  /**
   * Constructor that takes our filename as arguement and creates the inverted index.
   * The Database uses BufferedReader that reads the textfile line by line that puts it directly to our hashmap
   * in order to avoid a heapSpace error.
   * @param filename
   */
  public Database(String filename) throws IOException {
    
    index = new HashMap<>();
    wordCount = new HashMap<>();
    numPages = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      String url = "";
      String title = "";
      int counter = 0;

      while ((line = br.readLine()) != null) {
        counter++;

        if (line.startsWith("*PAGE")) {
          
          if (counter >= 2 && !url.equals("") && !title.startsWith("*PAGE")) {
            wordCount.put(url, counter - 1);
            numPages++;
          }
          counter = 0;
          url = line;
          title = br.readLine();
        } 
        
        else if (
          counter >= 1 &&
          index.containsKey(line) &&
          !url.equals("") &&
          !title.startsWith("*PAGE")
        ) {
          if (index.get(line).get(url) != null) {
            index.get(line).get(url).incrementTermCount();
          } else {
            index.get(line).put(url, new Page(url, title));
          }
        } 
        
        else if (
          counter >= 1 &&
          !index.containsKey(line) &&
          !url.equals("") &&
          !title.startsWith("*PAGE")
        ) {
          index.put(line, new HashMap<>());
          index.get(line).put(url, new Page(url, title));
        }
      }
      wordCount.put(url, counter);
      numPages++;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Getter method that returns a map which is the inverted index. The key is
   * the word and the value is a Map containing the URL and the value page.
   * @return index
   */
  public Map<String, Map<String, Page>> getInverseIndex() {
    return index;
  }

  /**
   * Getter method that returns a map with String, Integer which represents the total number of times the word is in the page.
   * @return wordcount
   */
  public static Map<String, Integer> getWordCount() {
    return wordCount;
  }

  /**
   * Getter method that returns an integer, which is the number of pages the database contains.
   * @return numPages
   */
  public static int getNumPages() {
    return numPages;
  }
}
