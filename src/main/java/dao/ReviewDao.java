package dao;

import java.util.List;

public interface ReviewsDao {
    // create //
    void add(Review review);

    // read //
    List<Review> getAll();
    List<Review> getAllReviewsByRestaurantId(int restaurantId);

    // update //

    // delete //
    void deleteById(int id);
    void clearAll();

    List<Review> getAllReviewsByRestaurantSortedNewestToOldest(int restaurantId);
}
