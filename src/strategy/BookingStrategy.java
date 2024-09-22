package strategy;

import entity.Car;
import model.Slot;

import java.util.List;

public interface BookingStrategy {
  public Car reserve(Slot slot, List<Car> availableCars);
}
