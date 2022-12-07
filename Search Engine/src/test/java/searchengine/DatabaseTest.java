package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class DatabaseTest {

  @Test
  void wordCountTest() {
    try {
      Database classUnderTest = new Database("data/test-file.txt");
      Map<String, Integer> wordCount = new HashMap<>();

      wordCount.put("*PAGE:http://page1.com", 3);
      wordCount.put("*PAGE:http://page2.com", 2);
      wordCount.put("*PAGE:http://page3.com", 3);

      assertEquals(wordCount, classUnderTest.getWordCount());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void wordCountTest_page2() {
    try {
      Database classUnderTest = new Database("data/test-file.txt");
      Map<String, Integer> wordCount = new HashMap<>();

      wordCount.put("*PAGE:http://page1.com", 3);
      wordCount.put("*PAGE:http://page2.com", 2);
      wordCount.put("*PAGE:http://page3.com", 3);

      assertEquals(
        wordCount.get("*PAGE:http://page2.com"),
        classUnderTest.getWordCount().get("*PAGE:http://page2.com")
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void pageNumTest() {
    int pageNumTest = 3;
    assertEquals(pageNumTest, Database.getNumPages());
  }

  @Test
  void inverseIndexTest() {
    try {
      Database classUnderTest = new Database("data/test-file.txt");
      Map<String, Map<String, Page>> testIndexMap = new HashMap<>();

      Page page1 = new Page("*PAGE:http://page1.com", "title1");
      Page page2 = new Page("*PAGE:http://page2.com", "title2");
      Page page3 = new Page("*PAGE:http://page3.com", "title3");

      testIndexMap.put("word1", new HashMap<>());
      testIndexMap.get("word1").put(page1.getUrl(), page1);
      testIndexMap.get("word1").put(page2.getUrl(), page2);
      testIndexMap.get("word1").put(page3.getUrl(), page3);

      testIndexMap.put("word2", new HashMap<>());
      testIndexMap.get("word2").put(page1.getUrl(), page1);
      testIndexMap.get("word2").put(page3.getUrl(), page3);

      testIndexMap.put("word3", new HashMap<>());
      testIndexMap.get("word3").put(page2.getUrl(), page2);
      testIndexMap.get("word3").put(page3.getUrl(), page3);

      assertEquals(testIndexMap, classUnderTest.getInverseIndex());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void inverseIndexTest_word1() {
    try {
      Database classUnderTest = new Database("data/test-file.txt");
      Map<String, Map<String, Page>> testIndexMap = new HashMap<>();

      Page page1 = new Page("*PAGE:http://page1.com", "title1");
      Page page2 = new Page("*PAGE:http://page2.com", "title2");
      Page page3 = new Page("*PAGE:http://page3.com", "title3");

      testIndexMap.put("word1", new HashMap<>());
      testIndexMap.get("word1").put(page1.getUrl(), page1);
      testIndexMap.get("word1").put(page2.getUrl(), page2);
      testIndexMap.get("word1").put(page3.getUrl(), page3);

      testIndexMap.put("word2", new HashMap<>());
      testIndexMap.get("word2").put(page1.getUrl(), page1);
      testIndexMap.get("word2").put(page3.getUrl(), page3);

      testIndexMap.put("word3", new HashMap<>());
      testIndexMap.get("word3").put(page2.getUrl(), page2);
      testIndexMap.get("word3").put(page3.getUrl(), page3);

      assertEquals(
        testIndexMap.get("word1"),
        classUnderTest.getInverseIndex().get("word1")
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void inverseIndexTest_errorFile() {
    try {
      Database classUnderTestError = new Database("data/test-file-errors.txt");
      Map<String, Map<String, Page>> testIndexMap = new HashMap<>();

      Page page1 = new Page("*PAGE:http://page1.com", "title1");
      Page page2 = new Page("*PAGE:http://page2.com", "title2");

      testIndexMap.put("word1", new HashMap<>());
      testIndexMap.get("word1").put(page1.getUrl(), page1);
      testIndexMap.get("word1").put(page2.getUrl(), page2);

      testIndexMap.put("word2", new HashMap<>());
      testIndexMap.get("word2").put(page1.getUrl(), page1);

      testIndexMap.put("word3", new HashMap<>());
      testIndexMap.get("word3").put(page2.getUrl(), page2);

      assertEquals(testIndexMap, classUnderTestError.getInverseIndex());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void inverseIndexTest_errorFile_word1() {
    try {
      Database classUnderTestError = new Database("data/test-file-errors.txt");
      Map<String, Map<String, Page>> testIndexMap = new HashMap<>();

      Page page1 = new Page("*PAGE:http://page1.com", "title1");
      Page page2 = new Page("*PAGE:http://page2.com", "title2");

      testIndexMap.put("word1", new HashMap<>());
      testIndexMap.get("word1").put(page1.getUrl(), page1);
      testIndexMap.get("word1").put(page2.getUrl(), page2);

      testIndexMap.put("word2", new HashMap<>());
      testIndexMap.get("word2").put(page1.getUrl(), page1);

      testIndexMap.put("word3", new HashMap<>());
      testIndexMap.get("word3").put(page2.getUrl(), page2);

      assertEquals(
        testIndexMap.get("word1"),
        classUnderTestError.getInverseIndex().get("word1")
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void wordCountTest_errorFile() {
    try {
      Database classUnderTestError = new Database("data/test-file-errors.txt");
      Map<String, Integer> wordCount = new HashMap<>();

      wordCount.put("*PAGE:http://page1.com", 2);
      wordCount.put("*PAGE:http://page2.com", 2);

      assertEquals(wordCount, classUnderTestError.getWordCount());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void wordCountTest_errorFile_page2() {
    try {
      Database classUnderTestError = new Database("data/test-file-errors.txt");
      Map<String, Integer> wordCount = new HashMap<>();

      wordCount.put("*PAGE:http://page1.com", 2);
      wordCount.put("*PAGE:http://page2.com", 2);

      assertEquals(
        wordCount.get("*PAGE:http://page2.com"),
        classUnderTestError.getWordCount().get("*PAGE:http://page2.com")
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void pageNumTest_errorFile() {
    try {
      Database classUnderTestError = new Database("data/test-file-errors.txt");
      int pageNumTest = 2;

      assertEquals(pageNumTest, classUnderTestError.getNumPages());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
