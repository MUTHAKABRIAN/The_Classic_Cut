package dao;

import models.BarberShop;
import models.HairStyle;

import java.util.List;

public interface HairstyleDao {
    List<HairStyle> getAll();

    List<HairStyle> getAllHairStyleByBarbershop(int barbershopId);

    void add(HairStyle hairstyle);

    void addHairStyleToBarberShop(HairStyle hairstyle, BarberShop barbershop);

    void deleteById(int id);

    void clearAll();
}
