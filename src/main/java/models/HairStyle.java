package models;


import java.util.Objects;

public class HairStyle {
  private String name;
  private int id;
  private int barbershopId;


  public HairStyle(String name,int barbershopId) {
    this.name = name;
    this.barbershopId=barbershopId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HairStyle hairStyle = (HairStyle) o;
    return getId() == hairStyle.getId() &&
      getBarbershopId() == hairStyle.getBarbershopId() &&
      Objects.equals(getName(), hairStyle.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getId(), getBarbershopId());
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
  public int getBarbershopId(){
    return barbershopId;
  }
  public void setBarbershopId(){
    this.barbershopId=barbershopId;

  }
}

