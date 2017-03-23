import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    City portland = new City("Portland");
    City seattle = new City("Seattle");
    City spokane = new City("Spokane");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("cities", City.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id/jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city-jobOpening-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities/:id/jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));

      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contact = request.queryParams("contact");

      JobOpening newJobOpening = new JobOpening(title, description, contact);
      city.addJobOpening(newJobOpening);
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:cityId/jobOpenings/:jobId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":cityId")));
      JobOpening jobOpening = JobOpening.find(Integer.parseInt(request.params(":jobId")));
      model.put("jobOpening", jobOpening);
      model.put("template", "templates/jobOpening.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
   }
}
