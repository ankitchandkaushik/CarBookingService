package entity;

import model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Car {
  String id;

  String name;

  String description;

  List<Slot> bookings;

  public Car(String name, String description) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.description = description;
    bookings = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Slot> getBookings() {
    return bookings;
  }

  @Override
  public String toString() {
    return "Car{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='" + description + '\'' + ", bookings=" + bookings + '}';
  }
}
