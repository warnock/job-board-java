import java.util.ArrayList;
import java.util.List;


public class JobOpening {
  private String mTitle;
  private String mDescription;
  private String mContact;
  private static List<JobOpening> instances = new ArrayList<JobOpening>();
  private int mId;

  public JobOpening (String title, String description, String contact) {
    mTitle = title;
    mDescription = description;
    mContact = contact;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription(){
    return mDescription;
  }

  public String getContact(){
    return mContact;
  }

  public static List<JobOpening> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }
}
