package dao;

import models.Barbershop;
import models.Hairstyle;

import java.util.List;

public interface BarbershopDao {
    List<Barbershop> getAll();

    List<Hairstyle> getAllHairStylesForABarberShop(int barberShopId);

    Barbershop findById(int id);

    void add(Barbershop barbershop);

    void addBarberShopToHairStyle(Barbershop barbershop, Hairstyle hairstyle);

    void update(int id, String name, String address, String phone, String website, String email);

    void deleteById(int id);

    void clearAll();
}
