import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkPick{

    int capacity;
    Map<CarTicket, Car> carTicketSystem;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        carTicketSystem = new HashMap<>();
    }

    @Override
    public CarTicket park(Car car) {
        if (IsParkLotFull()) return null;
        CarTicket carTicket = new CarTicket();
        carTicketSystem.put(carTicket, car);
        return carTicket;
    }

    @Override
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

    public int vacancy() {
        return capacity - carTicketSystem.size();
    }

    public double vacancyRate() {
        return vacancy()/capacity;
    }
}
