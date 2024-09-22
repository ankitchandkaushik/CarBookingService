import entity.Car;
import model.Slot;
import service.CabBookingService;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to CarBooking Service!");

    CabBookingService cabBookingService = CabBookingService.getInstance();

    Car car1 = new Car("Nexon", "Tata Car");
    Car car2 = new Car("Baleno", "MS Car");
    Car car3 = new Car("Slavia", "Skoda Car");
    Car car4 = new Car("XUV 700", "Mahindra Car");
    Car car5 = new Car("Compass", "Jeep Car");

    cabBookingService.addCar(car1);
    cabBookingService.addCar(car2);
    cabBookingService.addCar(car3);
    cabBookingService.addCar(car4);
    cabBookingService.addCar(car5);

    List<Car> availableCars = cabBookingService.getAllCars(new Slot(1,5));
    System.out.println(availableCars);
    cabBookingService.reserveCar(new Slot(1,5));
    availableCars = cabBookingService.getAllCars(new Slot(1,5));
    System.out.println(availableCars);
    cabBookingService.reserveCar(new Slot(1,5));
    cabBookingService.reserveCar(new Slot(1,5));
    cabBookingService.reserveCar(new Slot(1,5));
    cabBookingService.reserveCar(new Slot(2,3));

    availableCars = cabBookingService.getAllCars(new Slot(4,5));
    System.out.println(availableCars);



  }
}
