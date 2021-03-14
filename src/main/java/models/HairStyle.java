package models;


import java.util.Objects;

public class HairStyle {
  private String name;
  private int id;
  private int barberShopId;


  public HairStyle(String name,int barberShopId) {
    this.name = name;
    this.barberShopId=barberShopId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HairStyle hairStyle = (HairStyle) o;
    return getId() == hairStyle.getId() &&
      getbarberShopId() == hairStyle.getbarberShopId() &&
      Objects.equals(getName(), hairStyle.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getId(), getbarberShopId());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {

    this.id = id;
  }
  public int getbarberShopId(){
    return barberShopId;
  }
  public void setbarberShopId(){
    this.barberShopId=barberShopId;

  }
}

