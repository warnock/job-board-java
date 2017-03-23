import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {

  @Test
  public void JobOpening_instantiatesCorrectly_true() {
    JobOpening myJobOpening = new JobOpening("title", "description",  "contact");
    assertEquals(true, myJobOpening instanceof JobOpening);
  }
}
