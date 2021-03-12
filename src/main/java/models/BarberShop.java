package models;


import java.util.Objects;

public class BarberShop {
  private String name;
  private String address;
  private String phone;
  private String website;
  private String email;
  private int id;
  private String hairstyleName;

  public BarberShop(String name, String address, String phone, String website, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.website = website;
    this.email = email;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BarberShop that = (BarberShop) o;
    return Objects.equals(name, that.name) &&
      Objects.equals(address, that.address) &&
      Objects.equals(phone, that.phone) &&
      Objects.equals(website, that.website) &&
      Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phone, website, email);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {

    this.id = id;
  }
  public String getHairstyleName() {
    return hairstyleName;
  }


}
