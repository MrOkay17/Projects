package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class ScoringTest {

  private Scoring classundertest;
  private Database db;
  private Search search;

  @BeforeAll
  void setUp() {
    classundertest = new Scoring();

    try {
      db = new Database("data/test-file.txt");
      search = new Search(db.getInverseIndex());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testTF1() {
    search.search("word1");
    double tf = classundertest.tf(2, "*PAGE:http://page1.com");
    assertEquals(0.6666666666666666, tf);
  }

  @Test
  void testTF2() {
    search.search("word2");
    double tf = classundertest.tf(1, "*PAGE:http://page1.com");
    assertEquals(0.3333333333333333, tf);
  }

  @Test
  void testIDF1() {
    search.search("word1");
    double idf = classundertest.idf(3);
    assertEquals(0.00, idf);
  }

  @Test
  void testIDF2() {
    search.search("word2");
    double idf = classundertest.idf(2);
    assertEquals(0.17609125905568124, idf);
  }

  @Test
  void testTFIDF1() {
    search.search("word1");
    double tfIDF = classundertest.tfIDF(2, "*PAGE:http://page1.com", 3);
    assertEquals(0, tfIDF);
  }

  @Test
  void testTFIDF2() {
    search.search("word2");
    double tfIDF = classundertest.tfIDF(1, "*PAGE:http://page1.com", 2);
    assertEquals(0.058697086351893746, tfIDF);
  }
}
