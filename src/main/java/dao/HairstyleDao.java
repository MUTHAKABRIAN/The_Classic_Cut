package dao;

import models.Barbershop;
import models.Hairstyle;

import java.util.List;

public interface HairstyleDao {
    List<Hairstyle> getAll();

    List<Barbershop> getAllBarberShopForHairStyle(int id);

    void add(Hairstyle hairstyle);

    void addHairStyleToBarberShop(Hairstyle hairstyle, Barbershop barbershop);

    void deleteById(int id);

    void clearAll();
}
