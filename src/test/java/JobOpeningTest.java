import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class JobOpeningTest {

  @Test
  public void JobOpening_instantiatesCorrectly_true() {
    JobOpening myJobOpening = new JobOpening("title", "description",  "contact");
    assertEquals(true, myJobOpening instanceof JobOpening);
  }

  @Test
  public void getTitle_getsTitleValue_title() {
    JobOpening myJobOpening = new JobOpening("title", "description",  "contact");
    assertEquals("title", myJobOpening.getTitle());
  }

  @Test
  public void getDescription_getsDescriptionValue_description() {
    JobOpening myJobOpening = new JobOpening("title", "description",  "contact");
    assertEquals("description", myJobOpening.getDescription());
  }

  @Test
  public void getContact_getsContactValue_contact() {
    JobOpening myJobOpening = new JobOpening("title", "description",  "contact");
    assertEquals("contact", myJobOpening.getContact());
  }

  @Test
  public void all_returnsAllInstancesOfJobOpening_true(){
    JobOpening firstJobOpening = new JobOpening("Java Developer", "description",  "contact");
    JobOpening secondJobOpening = new JobOpening("UI Developer", "description",  "contact");
    assertEquals(true, JobOpening.all().contains(firstJobOpening));
    assertEquals(true, JobOpening.all().contains(secondJobOpening));
  }

  @Test
  public void clear_emptiesAllJobOpeningsFromArrayList_0(){
    JobOpening myJobOpening = new JobOpening("UI Developer", "description",  "contact");
    JobOpening.clear();
    assertEquals(0, JobOpening.all().size());
  }

  @Test
  public void getId_JobOpeningInstantiatesWIthAnID_1(){
    JobOpening.clear();
    JobOpening myJobOpening = new JobOpening("UI Developer", "description",  "contact");
    assertEquals(1, myJobOpening.getId());
  }
}
