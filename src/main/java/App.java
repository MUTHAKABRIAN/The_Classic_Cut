
import com.google.gson.Gson;
import dao.*;
import exceptions.ApiException;
import models.BarberShop;
import models.HairStyle;
import models.Review;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 5432; //return default port if heroku-port isn't set (i.e. on localhost)
    }

  public static void main(String[] args) {
        port(getHerokuAssignedPort());
    staticFileLocation("/public");

    Sql2oReviewDao ReviewDao;
    Sql2oHairstyleDao HairstyleDao;
    Sql2oBarberShopDao BarberShopDao;

    Connection conn;
    Gson gson = new Gson();

//        String connectionString = "jdbc:postgresql://ec2-54-159-175-113.compute-1.amazonaws.com:5432/d8grc02bjh5thu";
//        Sql2o sql2o = new Sql2o(connectionString, "avcpobtkxusfwy", "3fca13919bffb8ddee615b4f8980f42b0f84603e8aa69e85ac40a21933e0ddd0");

    String connectionString = "jdbc:postgresql://localhost:5432/barber";
    Sql2o sql2o = new Sql2o(connectionString, "moring", "root");

    BarberShopDao = new Sql2oBarberShopDao(sql2o);
    ReviewDao = new Sql2oReviewDao(sql2o);
    HairstyleDao = new Sql2oHairstyleDao(sql2o);


    get("/", "application/json", (req, res) ->
      "{\"Note\":\"Welcome To Tech Night Barber-Shops Connection\"}");

    post("/barbershops/new", "application/json", (request, response) -> {
      BarberShop barberShop = gson.fromJson(request.body(), BarberShop.class);
      BarberShopDao.add(barberShop);
      response.status(201);
      return gson.toJson(barberShop);
    });
    get("/barbershops", "application/json", (request, response) -> {
      System.out.println(BarberShopDao.getAll());
      return gson.toJson(BarberShopDao.getAll());
    });

    post("/hairstyles/new", "application/json", (req, res) -> {
      HairStyle hairStyle= gson.fromJson(req.body(), HairStyle.class);
      HairstyleDao.add(hairStyle);
      res.status(201);
      return gson.toJson(hairStyle);
    });
    get("/hairstyles", "application/json", (req, res) -> {
      res.type("application/json");
      return gson.toJson(HairstyleDao.getAll());//send it back to be displayed
    });
    post("/reviews/new", "application/json", (req, res) -> {
      Review review = gson.fromJson(req.body(), Review.class);
      ReviewDao.add(review);
      res.status(201);
      res.type("application/json");
      return gson.toJson(review);
    });
    get("/reviews", "application/json", (req, res) -> {
      res.type("application/json");
      return gson.toJson(ReviewDao .getAll());//send it back to be displayed
    });
    get("/barbershops/:id", "application/json", (req, res) -> {
      int Bid = Integer.parseInt(req.params("id"));
      BarberShop barbershopToFind = BarberShopDao.findById(Bid);
      if(barbershopToFind == null) {
        throw new ApiException (404, String.format("No barbershop with the id: \"%s\" exists", req.params("id")));
      }
      return gson.toJson(barbershopToFind);
    });
    get("/barbershops/:id/hairstyles", "application/json", (req, res) -> {
      int barbershopId = Integer.parseInt(req.params("id"));
      BarberShop barberShopToFind = BarberShopDao.findById(barbershopId);
      if (barberShopToFind == null){
        throw new ApiException(404, String.format("No barbershop with the id: \"%s\" exists", req.params("id")));
      }
      else if (BarberShopDao.getAllHairStylesForABarberShop(barbershopId).size()==0){
        return "{\"message\":\"I'm sorry, but no hairstyles are listed for this barbershop.\"}";
      }
      else {
        return gson.toJson(BarberShopDao.getAllHairStylesForABarberShop(barbershopId));
      }
    });
    get("/barbershops/:id/sortedReviews", "application/json", (req, res) -> { //// TODO: 1/18/18 generalize this route so that it can be used to return either sorted reviews or unsorted ones.
      int barbershopId = Integer.parseInt(req.params("id"));
      BarberShop barberShopToFind = BarberShopDao.findById(barbershopId);
      List<Review> allReviews;
      if (barberShopToFind == null){
        throw new ApiException(404, String.format("No barbershop with the id: \"%s\" exists", req.params("id")));
      }
      allReviews = ReviewDao.getAllReviewsByBarberShopSortedNewestToOldest(barbershopId);
      return gson.toJson(allReviews);
    });

    get("/barbershops/:id/reviews", "application/json", (req, res) -> {
      int barbershopId = Integer.parseInt(req.params("id"));

      BarberShop barberShopToFind = BarberShopDao.findById(barbershopId);
      List<Review> allReviews;

      if (barberShopToFind == null){
        throw new ApiException(404, String.format("No barbershop with the id: \"%s\" exists", req.params("id")));
      }

      allReviews = ReviewDao.getAllReviewsByBarberShopId(barbershopId);

      return gson.toJson(allReviews);
    });


    //FILTERS
    exception(ApiException.class, (exception, req, res) -> {
      ApiException err = (ApiException) exception;
      Map<String, Object> jsonMap = new HashMap<>();
      jsonMap.put("status", err.getStatusCode());
      jsonMap.put("errorMessage", err.getMessage());
      res.type("application/json");
      res.status(err.getStatusCode());
      res.body(gson.toJson(jsonMap));
    });
    after((req, res) -> {
      res.type("application/json");
    });



  }
}





