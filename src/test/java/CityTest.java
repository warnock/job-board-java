import org.junit.*;
import static org.junit.Assert.*;

public class  CityTest {

  @Test
  public void CityTest_instantiatesCorrectly_true() {
    City testCity = new City("Portland");
    assertEquals(true, testCity instanceof City);
  }

  @Test
  public void getName_getsCityName_Portland() {
    City testCity = new City("Portland");
    assertEquals("Portland", testCity.getName());
  }

  @Test
  public void all_getsAllCities_true() {
    City testCity1 = new City("Portland");
    City testCity2 = new City("Seattle");
    assertEquals(true, City.all().contains(testCity1));
    assertEquals(true, City.all().contains(testCity2));
  }

  @Test
  public void clear_emptiesAllCitiesFromArrayList_0() {
    City.clear();
    assertEquals(0, City.all().size());
  }

  @Test
  public void getId_CityInstantiatesWithId_1() {
    City.clear();
    City testCity = new City("Portland");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_testCity1() {
    City.clear();
    City testCity1 = new City("Portland");
    assertEquals(testCity1, City.find(testCity1.getId()));
  }

  @Test
  public void getJobOpenings_initiallyReturnsEmptyList_ArrayList() {
    City.clear();
    City testCity = new City("Portland");
    assertEquals(0, testCity.getJobOpenings().size());
  }

  @Test
  public void addJobOpening_addJobOpeningToList_true() {
    City.clear();
    City testCity = new City("Portland");
    JobOpening testJobOpening = new JobOpening("title", "description",  "contact");
    testCity.addJobOpening(testJobOpening);
    assertTrue(testCity.getJobOpenings().contains(testJobOpening));
  }
}
