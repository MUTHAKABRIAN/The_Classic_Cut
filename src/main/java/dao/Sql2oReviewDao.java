package dao;

import models.BarberShop;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oReviewDao implements ReviewDao {
  private final Sql2o sql2o;

  public Sql2oReviewDao(Sql2o sql2o) {
    this.sql2o = sql2o;
  }


  @Override
  public void add(Review review) {
    String sql = "INSERT INTO reviews(content, writtenby, rating, barbershopId) VALUES (:content, :writtenBy, :rating,:barberShopId)";
    try (Connection conn = sql2o.open()) {
      int id = (int) conn.createQuery(sql, true)
        .bind(review)
        .executeUpdate()
        .getKey();
      review.setId(id);
    }
  }

  @Override
  public List<Review> getAll() {
    try(Connection conn =sql2o.open()){
      System.out.println(conn.createQuery("SELECT * FROM reviews")
        .executeAndFetch(Review.class));
      return conn.createQuery("SELECT * FROM reviews")
        .executeAndFetch(Review.class);

    }
  }

  @Override
  public List<Review> getAllReviewsByBarberShopId(int barberShopId) {
    try(Connection con = sql2o.open()){
      return con.createQuery("SELECT * FROM reviews WHERE barbershopId = :barbershopId")
        .addParameter("barbershopId",barberShopId)
        .executeAndFetch(Review.class);
    }
  }

  @Override
  public void deleteById(int id) {
    String sql = "DELETE from reviews WHERE id =:id";
    try (Connection con = sql2o.open()){
      con.createQuery(sql)
        .addParameter("id",id)
        .executeUpdate();
    }catch(Sql2oException ex){
      System.out.println(ex);

    }

  }

  @Override
  public void clearAll() {
    String sql ="DELETE from reviews";
    try(Connection con=sql2o.open()){
      con.createQuery(sql).executeUpdate();
    }catch (Sql2oException ex){
      System.out.println(ex);
    }

  }

  @Override
  public List<Review> getAllReviewsByBarberShopSortedNewestToOldest(int barbershopId) {
    return null;
  }
}
