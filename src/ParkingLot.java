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
        if (ReturnNothingWhenParkLotIsFull()) return null;
        CarTicket carTicket = new CarTicket();
        carTicketSystem.put(carTicket, car);
        return carTicket;
    }

    public Car pick(CarTicket carTicket) {
        return carTicketSystem.get(carTicket);
    }

    private boolean ReturnNothingWhenParkLotIsFull() {
        if(carTicketSystem.size() == capacity){
            return true;
        }
        return false;
    }
}
