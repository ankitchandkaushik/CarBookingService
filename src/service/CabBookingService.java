package service;

import entity.Car;
import model.Slot;
import storege.InMemoryDB;
import strategy.BookingStrategy;
import strategy.FirstFitStrategy;

import java.util.List;

public class CabBookingService {

  private static CabBookingService instance;
  private InMemoryDB database;
  private BookingStrategy bookingStrategy;
  private CabBookingService() {
  }

  public static CabBookingService getInstance() {
    if(instance == null) {
      synchronized (CabBookingService.class) {
        if(instance == null) {
          instance = new CabBookingService();
          instance.database = new InMemoryDB();
          instance.bookingStrategy = new FirstFitStrategy();
        }
      }
    }
    return instance;
  }

  public List<Car> getAllCars(Slot slot) {
    return database.getAvailableCars(slot);
  }

  public boolean reserveCar(Slot slot) {
    Car reservedCar = bookingStrategy.reserve(slot, getAllCars(slot));
    if(reservedCar==null) {
      return false;
    } else {
      database.reserveCar(reservedCar, slot);
      return true;
    }
  }

  public boolean addCar(Car car) {
    return database.addCar(car);
  }

}
