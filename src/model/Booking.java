package model;

import java.util.UUID;

public class Booking {
  String id;
  String carId;
  Slot slot;

  public Booking(Slot slot) {
    this.id = UUID.randomUUID().toString();
    this.slot = slot;
  }

  public String getId() {
    return id;
  }

  public String getCarId() {
    return carId;
  }

  public Slot getSlot() {
    return slot;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public void setSlot(Slot slot) {
    this.slot = slot;
  }
}
