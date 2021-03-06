package dao;


import models.Review;
import java.util.List;

public interface ReviewDao {
  void add(Review review);

  List<Review> getAll();

  List<Review> getAllReviewsByBarberShopId(int barberShopId);

  void deleteById(int id);

  void clearAll();

  List<Review> getAllReviewsByBarberShopSortedNewestToOldest(int restaurantId);

}
