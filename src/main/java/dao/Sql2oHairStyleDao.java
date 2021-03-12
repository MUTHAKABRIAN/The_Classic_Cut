package dao;

import models.BarberShop;
import models.HairStyle;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oHairStyleDao implements HairstyleDao {

    private final Sql2o sql2o;

    public Sql2oHairStyleDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public List<HairStyle> getAll() {
        try (Connection conn = sql2o.open()) {
            System.out.println(conn.createQuery("SELECT * FROM hairstyles")
                    .executeAndFetch(HairStyle.class));
            return conn.createQuery("SELECT * FROM hairstyles")
                    .executeAndFetch(HairStyle.class);
        }
    }

    @Override
    public List<HairStyle> getAllHairStyleByBarbershop(int barbershopId) {
        ArrayList<HairStyle> hairStyles = new ArrayList<>();

        String joinQuery = "SELECT hairstylename FROM barbershops WHERE hairstylename = :hairstyleName";

        try (Connection conn = sql2o.open()) {
            List<String> allHairstylesNames = conn.createQuery(joinQuery)
                    .addParameter("barbershopId", barbershopId)
                    .executeAndFetch(String.class);
            for (String hairName : allHairstylesNames) {
                String userQuery = "SELECT * FROM hairstyles WHERE id = :id";
                hairStyles.add(conn.createQuery(userQuery)
                        .addParameter("hairstylename", hairName)
                        .executeAndFetchFirst(HairStyle.class));
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
        return hairStyles;
    }


    @Override
    public void add(HairStyle hairstyle) {
        String sql = "INSERT INTO ( barbershopId,name  ) VALUES (:barbershopId,:name)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(hairstyle)
                    .executeUpdate()
                    .getKey();
            hairstyle.setId(id);
        }


    }

    @Override
    public void addHairStyleToBarberShop(HairStyle hairstyle, BarberShop barbershop) {
        String sql = "INSERT INTO barbershop (hairstyleId,name,address ,phone ,website,email ) VALUES (:hairstyleId,:name,:address ,:phone ,:website,:email)";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("hairstyleId", hairstyle.getId())
                    .addParameter("name", barbershop.getName())
                    .addParameter("address", barbershop.getAddress())
                    .addParameter("phone", barbershop.getPhone())
                    .addParameter("website", barbershop.getWebsite())
                    .addParameter("email", barbershop.getWebsite())
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }


    @Override
    public void deleteById(int id) {
        String sql = "DELETE from hairstyles WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();


        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }



    @Override
    public void clearAll() {
        String sql = "DELETE from hairstyles";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}