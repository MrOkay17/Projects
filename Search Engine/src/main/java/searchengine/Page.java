package searchengine;

 /**
   * Class that represents a web page from the data file.
   */
public class Page {

  // FIELDS
  private String url;
  private String title;
  private double termCount;
  private double score;
  private int words;

  // CONSTRUCTOR
  public Page(String url, String title) {
    this.url = url;
    this.title = title;
    this.termCount = 0;
    this.words = 1;
    this.score = 0;
  }

  /**
   * A getter method that returns the url of the page in a String format.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * A getter method that returns the title of the page in a String format.
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * A getter method that returns the termCount of the page in double format.
   * @return termCount
   */
  public double getTermCount() {
    return termCount;
  }

  /**
   * A getter method that returns the total number of words of the page in int format.
   * @return words
   */
  public int getWords() {
    return words;
  }

  /**
   * A getter method that returns the score of a page in a double format.
   * @return score
   */
  public double getScore() {
    return score;
  }

  /**
   * A set words method sets the words by by an int.
   * If the argument is a negative number, the method sets the words by zero.
   * @param number
   */
  public void setWords(int number) {
    if (number < 0) {
      this.words += 0;
    } else {
      this.words = number;
    }
  }

  /**
   * A set term count method sets the term count by an int
   * If the argument is a negative number, the method sets the term count by zero.
   * @param number
   */
  public void setTermCount(int number) {
    if (number < 0) {
      this.termCount += 0;
    } else {
      this.termCount = number;
    }
  }

  /**
   * An method that increment the term count by 1.
   */
  public void incrementTermCount() {
    this.termCount++;
  }

  /**
   * A Replace score method that replaces the score with a new score in a double format.
   * If the argument is a negative double, the method sets the score by zero.
   * @param score1
   */
  public void replaceScore(double score1) {
    if (score1 < 0) {
      this.score += 0;
    } else {
      this.score = score1;
    }
  }

  /**
   * An initial score method that sets the score in a double format.
   * If the argument is a negative double, the method sets the score by zero.
   * @param score1
   */
  public void initialiseScore(double score1) {
    if (score1 < 0) {
      this.score += 0;
    } else {
      this.score = score1;
    }
  }

  /**
   * An Increment score method that sets the score in a double format.
   * If the argument is a negative double, the method sets the score by zero.
   * @param score1
   */
  public void incrementScore(double score1) {
    if (score1 < 0) {
      this.score += 0;
    } else {
      this.score += score1;
    }
  }

  /**
   * Method that overvrides the hashcode so our pages becomes equal and can be compared by title and url. Not by the scoring.
   * @return result
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  /**
   * Method that overrides the equals so our pages becomes equal and can be compared by title and url. Not by the scoring.
   * @param obj
   * @return true
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Page other = (Page) obj;
    if (url == null) {
      if (other.url != null) return false;
    } else if (!url.equals(other.url)) return false;
    if (title == null) {
      if (other.title != null) return false;
    } else if (!title.equals(other.title)) return false;
    return true;
  }
}
