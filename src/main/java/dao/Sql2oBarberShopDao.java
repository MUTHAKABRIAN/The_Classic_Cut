package dao;

import models.BarberShop;
import models.HairStyle;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oBarberShopDao implements BarbershopDao {

  private final Sql2o sql2o;

  public Sql2oBarberShopDao(Sql2o sql2o){
    this.sql2o =sql2o;
  }

  @Override
  public List<BarberShop> getAll() {
    try(Connection conn =sql2o.open()){
      System.out.println(conn.createQuery("SELECT * FROM barbershops")
        .executeAndFetch(BarberShop.class));
      return conn.createQuery("SELECT * FROM barbershops")
        .executeAndFetch(BarberShop.class);

    }
  }

  @Override
  public List<HairStyle> getAllHairStylesForABarberShop(int barberShopId){
    ArrayList<HairStyle> hairstyles = new ArrayList<>();

    String joinQuery = "SELECT barbershopId FROM hairstyles WHERE barbershopId = :barbershopId";

    try (Connection conn = sql2o.open()) {
      List<Integer> allBarbersIds = conn.createQuery(joinQuery)
        .addParameter("barbershopId", barberShopId)
        .executeAndFetch(Integer.class);
      for (Integer barberId : allBarbersIds){
        String userQuery = "SELECT * FROM barberShops WHERE id = :id";
        hairstyles.add(conn.createQuery(userQuery)
          .addParameter("barberId", barberId)
          .executeAndFetchFirst(HairStyle.class));
      }
    } catch (Sql2oException ex){
      System.out.println(ex);
    }
    return hairstyles;
  }




  @Override
  public BarberShop findById(int id) {
    String sql ="SELECT * FROM barbershops WHERE id =:id";
    try (Connection conn = sql2o.open()){
      return conn.createQuery(sql)
        .addParameter("id",id)
        .executeAndFetchFirst(BarberShop.class);
    }
  }

  @Override
  public void add(BarberShop barbershop) {
    String sql = "INSERT INTO barbershops(hairstylename, name, address,phone,website,email) VALUES (:hairstyleName, :name,:address,:phone,:website,:email)";
    try (Connection conn = sql2o.open()){
      int id =(int) conn.createQuery(sql,true )
        .bind(barbershop)
        .executeUpdate()
        .getKey();
      barbershop.setId(id);
    }

  }

  @Override
  public void addBarberShopToHairStyle(BarberShop barbershop, HairStyle hairstyle){
    String sql = "INSERT INTO hairstyles (barbershopId, name) VALUES (:barbershopId, :name)";
    try (Connection conn = sql2o.open()) {
      conn.createQuery(sql)
        .addParameter("barbershopId", barbershop.getId())
        .addParameter("name", hairstyle.getName())
        .executeUpdate();
    } catch (Sql2oException ex){
      System.out.println(ex);
    }

  }



  @Override
  public void update(int id, String name, String address, String phone, String website, String email) {
    String sql = "UPDATE barbershops SET (name, address, phone, website, email) = (:name, :address, :zipcode, :phone, :website, :email) WHERE id=:id"; //CHECK!!!
    try (Connection con = sql2o.open()) {
      con.createQuery(sql)
        .addParameter("name", name)
        .addParameter("address", address)
        .addParameter("phone", phone)
        .addParameter("website", website)
        .addParameter("email", email)
        .addParameter("id", id)
        .executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }



  @Override
  public void deleteById(int id) {


  }

  @Override
  public void clearAll() {
    String sql = "DELETE from barbershops";
    try (Connection con = sql2o.open()) {
      con.createQuery(sql).executeUpdate();
    } catch (Sql2oException ex) {
      System.out.println(ex);
    }
  }

}


