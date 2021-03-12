package dao;

import models.BarberShop;
import models.HairStyle;

import java.util.List;

public interface BarbershopDao {
    List<BarberShop> getAll();

    List<HairStyle> getAllHairStylesForABarberShop(int barberShopId);

    BarberShop findById(int id);

    void add(BarberShop barbershop);

    void addBarberShopToHairStyle(BarberShop barbershop, HairStyle hairstyle);

    void update(int id, String name, String address, String phone, String website, String email);

    void deleteById(int id);

    void clearAll();
}


