package searchengine;

import java.text.DecimalFormat;

 /**
   * Class that calculates the execution time in nanoseconds.
   */
public class Hourglass {

  // FIELDS
  private long starttime;
  private long endTime;
  private DecimalFormat df;

  // CONSTRUCTOR
  public Hourglass() {
    this.starttime = System.nanoTime();
    this.df = new DecimalFormat("0.0000");
  }

  /**
   * Getter method which returns the starting time.
   * @return starttime
   */
  public long getStarttime() {
    return starttime;
  }

  /**
   * Getter method which returns the end time.
   * @return endTime
   */
  public long getEndTime() {
    return endTime;
  }

  /**
   * Void method that stops the time.
   */
  public void stop() {
    this.endTime = System.nanoTime();
  }

  /**
   * A method that returns the execTime converted into a string, by subtracting the endTime with the starttime and dividing the result with 1000000000.0.
   * @return return df.format((endTime - starttime) / 1000000000.0)
   */
  public String execTime() {
    return df.format((endTime - starttime) / 1000000000.0);
  }
}
