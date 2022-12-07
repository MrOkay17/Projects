package searchengine;

 /**
   * Class that handles different scoring calculations for a specific Page object.
   */
public class Scoring {

  // FIELDS
  private double numberPages; // N is the number of documents in the data set.

  public Scoring() {}

  /**
   * A method that calculates the termfrequency (tf), by taking the number of times term t appears in the document d and dividing it with the the total number of terms in the document d and returns a double.
   * @param termCount
   * @param url
   * @return (termCount / Database.getWordCount().get(url))
   */
  public double tf(double termCount, String url) {
    return (termCount / Database.getWordCount().get(url));
  }

  /**
   * A method that calculates the Inverse document Frequency (idf), by taking the logorithm of N - the number of documents in the data set subtracted with n - the number of documents that contain the term t among the data set and returns a double.
   * @param n
   * @return tf(termCount, url) * idf(n)
   */
  public double idf(double n) {
    this.numberPages = Database.getNumPages();
    return Math.log10(numberPages / (n));
  }

  /**
   * A method that takes the product of tf() and idf() and returns the term frequency–inverse document frequency as the format double.
   * @param termCount
   * @param url
   * @param n
   * @return tf(termCount, url) * idf(n)
   */
  public double tfIDF(double termCount, String url, double n) {
    return tf(termCount, url) * idf(n);
  }
}
