import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int capacity;
    Map<CarTicket, Car> carTicketSystem;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        carTicketSystem = new HashMap<>();
    }

    public CarTicket park(Car car) {
        if (IsParkLotFull()) return null;
        CarTicket carTicket = new CarTicket();
        carTicketSystem.put(carTicket, car);
        return carTicket;
    }

    public Car pick(CarTicket carTicket) {
        Car car = carTicketSystem.get(carTicket);
        carTicketSystem.remove(carTicket);
        return car;
    }

    public boolean IsCarInPark(CarTicket carTicket) {
        return carTicketSystem.containsKey(carTicket);
    }

    public boolean IsParkLotFull() {
        return carTicketSystem.size() == capacity;
    }
}
