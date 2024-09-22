package storege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import entity.Car;
import model.Booking;
import model.Slot;

public class InMemoryDB {
  Map<String, Booking> bookings = new HashMap<>();
  ConcurrentHashMap<String, Car> cars = new ConcurrentHashMap<>();

  public boolean addCar(Car car) {
    String id = car.getId();
    if(cars.containsKey(id)) {
      System.out.println("Car already exist in system. Persistence skipped");
      return false;
    } else {
      cars.put(id, car);
      System.out.println("Successfully persisted Car: " + car.toString());
      return true;
    }
  }

  public boolean addBooking(Booking booking) {
    String id = booking.getId();
    if(bookings.containsKey(id)) {
      System.out.println("Booking already exist in system. Persistence skipped");
      return false;
    } else {
      bookings.put(id, booking);
      System.out.println("Successfully persisted Car: " + booking.toString());
      return true;
    }
  }

  public synchronized boolean reserveCar(Car car, Slot slot) {
    if(isCarAvailable(car, slot)) {
      cars.get(car.getId()).getBookings().add(slot);
      return true;
    } else {
      System.out.println(car.toString() + " not available Try again");
      return false;
    }

  }

  private boolean isCarAvailable(Car car, Slot slot) {
    boolean isAvailable = true;

    for(Slot bookDate: car.getBookings()) {
      if(!((bookDate.getEndDate()<slot.getStartDate())
          || (bookDate.getStartDate()>slot.getEndDate())
      )) {
        isAvailable = false;
        break;
      }
    }
    return isAvailable;
  }

  public List<Car> getAvailableCars(Slot slot) {
    List<Car> availableCars = new ArrayList<>();
    for(String key: cars.keySet()){
      boolean isAvailable = true;
      Car car = cars.get(key);
      for(Slot bookDate: car.getBookings()) {
        if(!((bookDate.getEndDate()<slot.getStartDate())
            || (bookDate.getStartDate()>slot.getEndDate())
        )) {
          isAvailable = false;
          break;
        }
      }
      if(isAvailable) {
        availableCars.add(car);
      }
    }
    return availableCars;
  }



  public Map<String, Booking> getBookings() {
    return bookings;
  }

  public Map<String, Car> getCars() {
    return cars;
  }
}
