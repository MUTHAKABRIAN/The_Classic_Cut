package dao;

import models.BarberShop;
import models.HairStyle;

import java.util.List;

public interface HairStyleDao {
    List<HairStyle> getAll();

    List<BarberShop> getAllBarberShopForHairStyle(int id);

    void add(HairStyle hairstyle);

    void addHairStyleToBarberShop(HairStyle hairstyle, BarberShop barbershop);

    void deleteById(int id);

    void clearAll();
}
