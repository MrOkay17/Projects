package searchengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(Lifecycle.PER_CLASS)
public class HourglassTest {

  @BeforeAll
  void setUp() {}

  @Test
  void testExecTime() throws InterruptedException {
    Hourglass classUnderTest = new Hourglass();
    DecimalFormat df = new DecimalFormat("0.0000");

    TimeUnit.SECONDS.sleep(2);
    classUnderTest.stop();
    double testDiff =
      (classUnderTest.getEndTime() - classUnderTest.getStarttime()) /
      1000000000.0;

    assertEquals(df.format(testDiff), classUnderTest.execTime());
  }
}
