package searchengine;
import java.io.IOException;

 /**
   * Class that makes the program run.
   */
public class Main {

  public static void main(final String... args) throws IOException {
    new Server(8080, filePath());
  }

   /**
   * Method that returns the filepath for the file to be used.
   * @return input
   */
  public static String filePath () {
    return "data/enwiki-large.txt";
  }
}
