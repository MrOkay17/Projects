package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class QueryHandlerTest {

  @Test
  void multipleWordsTest_2words() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    pageListTest.addAll(Arrays.asList(page3, page1));

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void multipleWordsTest_3words() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    indexMapTest.put("word3", new ArrayList<>());
    indexMapTest.get("word3").add(page2);
    indexMapTest.get("word3").add(page3);

    pageListTest.add(page3);

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void singleWordTest() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    pageListTest.addAll(Arrays.asList(page3, page2, page1));

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void handleQueryTest_3word() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    indexMapTest.put("word3", new ArrayList<>());
    indexMapTest.get("word3").add(page2);
    indexMapTest.get("word3").add(page3);

    pageListTest.add(page3);

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void handleQueryTest_2word() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    pageListTest.addAll(Arrays.asList(page3, page1));

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void handleQueryTest_1word() {
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    QueryHandler classUnderTest = new QueryHandler();

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    pageListTest.addAll(Arrays.asList(page3, page2, page1));

    assertEquals(pageListTest, classUnderTest.handleQuery(indexMapTest));
  }

  @Test
  void handleQueryTest_0word() {
    QueryHandler classUnderTest = new QueryHandler();
    Map<String, List<Page>> indexMapTest = new HashMap<>();

    assertTrue(classUnderTest.handleQuery(indexMapTest).isEmpty());
  }

  @Test
  void handleQueryTest_2word_scoreAddition_1() {
    QueryHandler classUnderTest = new QueryHandler();
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    page1.setTermCount(2);
    page1.setWords(3);

    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    page2.setTermCount(1);
    page2.setWords(2);

    Page page3 = new Page("*PAGE:http://page3.com", "title3");
    page3.setTermCount(1);
    page3.setWords(3);

    Page page4 = new Page("*PAGE:http://page1.com", "title1");
    page4.setTermCount(1);
    page4.setWords(3);

    Page page5 = new Page("*PAGE:http://page3.com", "title3");
    page5.setTermCount(1);
    page5.setWords(3);

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    page3.replaceScore(0.058697086351893746);
    pageListTest.addAll(Arrays.asList(page3, page1));

    assertEquals(
      pageListTest.get(0).getScore(),
      classUnderTest.handleQuery(indexMapTest).get(0).getScore()
    );
  }

  @Test
  void handleQueryTest_2word_scoreAddition_2() {
    QueryHandler classUnderTest = new QueryHandler();
    try {
      Database db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }

    Map<String, List<Page>> indexMapTest = new HashMap<>();
    List<Page> pageListTest = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    page1.setTermCount(2);
    page1.setWords(3);

    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    page2.setTermCount(1);
    page2.setWords(2);

    Page page3 = new Page("*PAGE:http://page3.com", "title3");
    page3.setTermCount(1);
    page3.setWords(3);

    Page page4 = new Page("*PAGE:http://page1.com", "title1");
    page4.setTermCount(1);
    page4.setWords(3);

    Page page5 = new Page("*PAGE:http://page3.com", "title3");
    page5.setTermCount(1);
    page5.setWords(3);

    indexMapTest.put("word1", new ArrayList<>());
    indexMapTest.get("word1").add(page1);
    indexMapTest.get("word1").add(page2);
    indexMapTest.get("word1").add(page3);

    indexMapTest.put("word2", new ArrayList<>());
    indexMapTest.get("word2").add(page1);
    indexMapTest.get("word2").add(page3);

    page3.replaceScore(0.058697086351893746);
    pageListTest.addAll(Arrays.asList(page3, page1));

    assertEquals(
      pageListTest.get(0).getScore(),
      classUnderTest.handleQuery(indexMapTest).get(0).getScore()
    );
  }
}
