import java.util.Arrays;
import java.util.List;

public class ParkingManager {
    List<ParkPick> parkPickWays;

    public ParkingManager(ParkPick parkPickWay) {
        this.parkPickWays = Arrays.asList(parkPickWay);
    }

    public ParkingManager(List<ParkPick> parkPickWays) {
        this.parkPickWays = parkPickWays;
    }

    public CarTicket park(Car car) {
        for (ParkPick parkPickWay : parkPickWays) {
            CarTicket carTicket = parkPickWay.park(car);
            if(carTicket != null){
                return carTicket;
            }
        }
        return null;
    }

    public Car pick(CarTicket carTicket) {
        for (ParkPick parkPickWay : parkPickWays) {
            Car car = parkPickWay.pick(carTicket);
            if(car != null){
                return car;
            }
        }
        return null;
    }
}
