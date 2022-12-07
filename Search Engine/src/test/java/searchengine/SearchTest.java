package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class SearchTest {

  private Database db;

  @BeforeAll
  void setUp() {
    try {
      db = new Database("data/test-file.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void TestCleanSearchTerm_listSize() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> test = classUnderTest.cleanSearchterm(
      new String[] { "America%20country", "Greenland%20", "denmark%20finland" }
    );

    assertEquals(3, test.size());
  }

  @Test
  void TestCleanSearchTerm_listContent() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> test = classUnderTest.cleanSearchterm(
      new String[] { "America%20country", "Greenland%20", "denmark%20finland" }
    );

    List<String> testList = new ArrayList<>();
    testList.add("America");
    testList.add("country");

    assertEquals(testList, test.get(0));
  }

  @Test
  void TestPopulateResult_1list() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList("word1", "word2"));

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    List<Page> testList1 = new ArrayList<>();
    testList1.addAll(Arrays.asList(page3, page1));

    assertEquals(testList1, classUnderTest.populateResult(serchTermTest));
  }

  @Test
  void TestPopulateResult_2list() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList("word1", "word2"));
    serchTermTest.add(Arrays.asList("word2", "word3"));

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    List<Page> testList1 = new ArrayList<>();
    testList1.addAll(Arrays.asList(page3, page1, page3));

    assertEquals(testList1, classUnderTest.populateResult(serchTermTest));
  }

  @Test
  void TestPopulateResult_2list_size() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList("word1", "word2"));
    serchTermTest.add(Arrays.asList("word2", "word3"));

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    List<Page> testList1 = new ArrayList<>();
    testList1.addAll(Arrays.asList(page3, page1, page3));

    assertEquals(
      testList1.size(),
      classUnderTest.populateResult(serchTermTest).size()
    );
  }

  @Test
  void TestPopulateResult_noMatch_size() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList("word100", "word1"));
    serchTermTest.add(Arrays.asList("word200", "word3"));

    List<Page> testList1 = new ArrayList<>();

    assertEquals(
      testList1.size(),
      classUnderTest.populateResult(serchTermTest).size()
    );
  }

  @Test
  void TestPopulateResult_noMatch_1match_size() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList("word100", "word1"));
    serchTermTest.add(Arrays.asList("word2", "word3"));

    Page page3 = new Page("*PAGE:http://page3.com", "title3");

    List<Page> testList1 = new ArrayList<>();
    testList1.addAll(Arrays.asList(page3));

    assertEquals(
      testList1.size(),
      classUnderTest.populateResult(serchTermTest).size()
    );
  }

  @Test
  void TestPopulateResult_emptyList_size() {
    Search classUnderTest = new Search(db.getInverseIndex());
    List<List<String>> serchTermTest = new ArrayList<>();

    serchTermTest.add(Arrays.asList(""));

    List<Page> testList1 = new ArrayList<>();

    assertEquals(
      testList1.size(),
      classUnderTest.populateResult(serchTermTest).size()
    );
  }

  @Test
  void TestFinalResult() {
    Search classUnderTest = new Search(db.getInverseIndex());

    List<Page> resultTest = new ArrayList<>();

    List<Page> pageList = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    page1.setTermCount(2);
    page1.setWords(3);
    page1.replaceScore(5);

    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    page2.setTermCount(1);
    page2.setWords(2);
    page2.replaceScore(2);

    Page page3 = new Page("*PAGE:http://page3.com", "title3");
    page3.setTermCount(1);
    page3.setWords(3);
    page3.replaceScore(6);

    Page page4 = new Page("*PAGE:http://page1.com", "title1");
    page4.setTermCount(1);
    page4.setWords(3);
    page4.replaceScore(10);

    Page page5 = new Page("*PAGE:http://page3.com", "title3");
    page5.setTermCount(1);
    page5.setWords(3);
    page5.replaceScore(2);

    resultTest.addAll(Arrays.asList(page4, page2, page3));
    pageList.addAll(Arrays.asList(page1, page2, page3, page4, page5));

    assertEquals(
      resultTest.size(),
      classUnderTest.populateFinalResult(pageList).size()
    );
  }

  @Test
  void TestFinalResult_scoreValue() {
    Search classUnderTest = new Search(db.getInverseIndex());

    List<Page> resultTest = new ArrayList<>();

    List<Page> pageList = new ArrayList<>();

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    page1.setTermCount(2);
    page1.setWords(3);
    page1.replaceScore(5);

    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    page2.setTermCount(1);
    page2.setWords(2);
    page2.replaceScore(2);

    Page page3 = new Page("*PAGE:http://page3.com", "title3");
    page3.setTermCount(1);
    page3.setWords(3);
    page3.replaceScore(6);

    Page page4 = new Page("*PAGE:http://page1.com", "title1");
    page4.setTermCount(1);
    page4.setWords(3);
    page4.replaceScore(10);

    Page page5 = new Page("*PAGE:http://page3.com", "title3");
    page5.setTermCount(1);
    page5.setWords(3);
    page5.replaceScore(2);

    resultTest.addAll(Arrays.asList(page2, page3, page4));
    pageList.addAll(Arrays.asList(page1, page2, page3, page4, page5));

    assertEquals(
      resultTest.get(0).getScore(),
      classUnderTest.populateFinalResult(pageList).get(0).getScore()
    );
  }

  @Test
  void TestPresentSet() {
    Search classUnderTest = new Search(db.getInverseIndex());

    List<String> responseTest = new ArrayList<>();
    List<Page> pageList = new ArrayList<>();
    String execTime = "1.000";
    final Charset CHARSET = StandardCharsets.UTF_8;

    Page page1 = new Page("*PAGE:http://page1.com", "title1");
    page1.setTermCount(2);
    page1.setWords(3);
    page1.replaceScore(0);

    Page page2 = new Page("*PAGE:http://page2.com", "title2");
    page2.setTermCount(1);
    page2.setWords(2);
    page2.replaceScore(0);

    Page page3 = new Page("*PAGE:http://page3.com", "title3");
    page3.setTermCount(1);
    page3.setWords(3);
    page3.replaceScore(0);

    pageList.addAll(Arrays.asList(page1, page2, page3));

    for (Page page : pageList) {
      responseTest.add(
        String.format(
          "{\"url\": \"%s\", \"title\": \"%s\",\"score\": \"%s\"}",
          page.getUrl().substring(6),
          page.getTitle(),
          page.getScore()
        )
      );
    }

    byte[] bytesTest = responseTest.toString().getBytes(CHARSET);

    assertEquals(
      bytesTest.length,
      classUnderTest.presentSet(execTime, pageList).length
    );
  }
}
