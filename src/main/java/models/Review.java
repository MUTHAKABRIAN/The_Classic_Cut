package models;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Review {
  private int id;
  private String content;
  private String writtenBy;
  private int rating;
  private int barberShopId;

  public Review(String content, String writtenBy, int rating, int barberShopId){
    this.content = content;
    this.writtenBy = writtenBy;
    this.rating = rating;
    this.barberShopId = barberShopId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return getId() == review.getId() &&
      getRating() == review.getRating() &&
      getBarberShopId() == review.getBarberShopId() &&
      Objects.equals(getContent(), review.getContent()) &&
      Objects.equals(getWrittenBy(), review.getWrittenBy());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getContent(), getWrittenBy(), getRating(), getBarberShopId());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWrittenBy() {
    return writtenBy;
  }

  public void setWrittenBy(String writtenBy) {
    this.writtenBy = writtenBy;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public int getBarberShopId() {
    return barberShopId;
  }

  public void setBarberShopId(int barberShopId) {
    this.barberShopId = barberShopId;
  }
}
