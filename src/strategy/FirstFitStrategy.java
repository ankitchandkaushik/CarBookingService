package strategy;

import entity.Car;
import model.Slot;
import strategy.BookingStrategy;

import java.util.List;

public class FirstFitStrategy implements BookingStrategy {


  @Override
  public Car reserve(Slot slot, List<Car> availableCars) {
    if(availableCars.isEmpty()) {
      System.out.println("No car available");
      return null;
    } else {
      return availableCars.get(0);
    }
  }
}
