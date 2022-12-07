package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class PageTest {

  @Test
  void testSetWords() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.setWords(4);
    assertEquals(4, page.getWords());
  }

  @Test
  void testSetWords_NoNegativeWords() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.setWords(-23);
    assertEquals(1, page.getWords());
  }

  @Test
  void testSetTermCount() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.setTermCount(4);
    assertEquals(4, page.getTermCount());
  }

  @Test
  void testSetTermCount_NoNegativeTermCounts() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.setTermCount(-204);
    assertEquals(0, page.getTermCount());
  }

  @Test
  void testIncrementTermCount_One() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.incrementTermCount();
    assertEquals(1, page.getTermCount());
  }

  @Test
  void testIncrementTermCount_MoreThanOne() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.incrementTermCount();
    page.incrementTermCount();
    page.incrementTermCount();
    page.incrementTermCount();
    assertEquals(4, page.getTermCount());
  }

  @Test
  void TestReplaceScore() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.replaceScore(22);
    assertEquals(22, page.getScore());
  }

  @Test
  void TestincrementNewScore() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.incrementScore(25);
    assertEquals(25, page.getScore());
  }

  @Test
  void TestincrementNewScore_WithAllScoreMethods() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.replaceScore(22);
    page.incrementScore(23);
    assertEquals(45, page.getScore());
  }

  @Test
  void TestincrementNewScore_WithAllScoreMethods2() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.replaceScore(10);
    page.incrementScore(-5);
    assertEquals(10, page.getScore());
  }

  @Test
  void TestincrementNewScore_WithAllScoreMethods3() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    page.replaceScore(10);
    page.replaceScore(-5);
    page.initialiseScore(-5);
    page.incrementScore(-5);
    assertEquals(10, page.getScore());
  }

  @Test
  public void testEquals_AndHashCode() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page1.com", "title1");
    assertTrue(page.equals(page2) && page2.equals(page));
    assertTrue(page.hashCode() == page2.hashCode());
  }

  @Test
  public void testEquals_AndHashCode_WhenGivingScores() {
    Page page = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page1.com", "title1");
    page.replaceScore(224);
    page2.replaceScore(3);
    assertTrue(page.equals(page2) && page2.equals(page));
    assertTrue(page.hashCode() == page2.hashCode());
  }
}
