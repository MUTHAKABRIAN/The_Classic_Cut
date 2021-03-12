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
  private long createdAt;
  private String formattedCreatedAt;

  public Review(String content, String writtenBy, int rating, int barberShopId){
    this.content = content;
    this.writtenBy = writtenBy;
    this.rating = rating;
    this.barberShopId = barberShopId;
    this.createdAt = System.currentTimeMillis();
    setFormattedCreatedAt();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Review review = (Review) o;
    return id == review.id &&
      rating == review.rating &&
      barberShopId == review.barberShopId &&
      createdAt == review.createdAt &&
      Objects.equals(content, review.content) &&
      Objects.equals(writtenBy, review.writtenBy) &&
      Objects.equals(formattedCreatedAt, review.formattedCreatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, content, writtenBy, rating, barberShopId, createdAt, formattedCreatedAt);
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

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = System.currentTimeMillis();
  }

  public String getFormattedCreatedAt(){
    Date date = new Date(createdAt);
    String datePatternToUse = "MM/dd/yyyy @ K:mm a";
    SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
    return sdf.format(date);
  }

  public void setFormattedCreatedAt() {
    Date date = new Date(this.createdAt);
    String datePattern = "MM/dd/yyyy @ K:mm a";
    SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
    this.formattedCreatedAt = sdf.format(date);
  }

}
