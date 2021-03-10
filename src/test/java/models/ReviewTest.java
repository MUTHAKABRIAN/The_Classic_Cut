package models;

import org.junit.*;
import static org.junit.Assert.*;

public class ReviewTest {
    @Test
    public void ReviewIsAnInstanceOfReview_true() {
        Review testReview = setUpNewReview();
        assertTrue(testReview instanceof Review);
    }

    @Test
    public void ReviewsContentInstantiatesCorrectly() {
        Review testReview = setUpNewReview();
        assertEquals("Cool Work", testReview.getContent());
    }

    @Test
    public void ReviewsWrittenByInstantiatesCorrectly() {
        Review testReview = setUpNewReview();
        assertEquals("Cliff", testReview.getWrittenBy());
    }

    @Test
    public void ReviewsRatingInstantiatesCorrectly() {
        Review testReview = setUpNewReview();
        assertEquals(16, testReview.getRating());
    }

    @Test
    public void BarbershopIdInstantiatesCorrectly() {
        Review testReview = setUpNewReview();
        assertEquals(1, testReview.getBarberShopId());
    }

    @Test
    public void ReturnsTrueIfReviewsAreTheSame() {
        Review testReview = setUpNewReview();
        Review anotherReview = setUpNewReview();
        assertTrue(testReview.equals(anotherReview));
    }

    // Helper Method //
    public Review setUpNewReview(){
        return new Review("Cool Work", "Cliff", 16, 1);
    }
}