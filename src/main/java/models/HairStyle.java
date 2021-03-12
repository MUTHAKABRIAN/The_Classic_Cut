package models;


import java.util.Objects;

public class HairStyle {
  private String name;
  private int id;
  private int barbershopId;
  private int hairstyleId;


  public HairStyle(int id,String name, int hairstyleId ,int barbershopId) {
    this.id=id;
    this.name = name;
    this.barbershopId=barbershopId;
    this.hairstyleId =hairstyleId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof HairStyle))return false;
    HairStyle hairStyle =(HairStyle)o;
    return id == hairStyle.id &&
      barbershopId == hairStyle.barbershopId &&
      hairstyleId == hairStyle.hairstyleId &&
      Objects.equals(name,hairStyle.name);

  }

  @Override
  public int hashCode() {
    return Objects.hash(name,hairstyleId,barbershopId, id);
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
  public int getHairstyleId(){
    return hairstyleId;
  }
  public void setHairstyleId(){
    this.hairstyleId=hairstyleId;
  }
}

