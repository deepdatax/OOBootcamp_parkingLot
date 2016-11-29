import java.util.List;

public class ParkingManager {
    List<IParking> parkPickWays;

    public ParkingManager(List<IParking> parkPickWays) {
        this.parkPickWays = parkPickWays;
    }

    public CarTicket park(Car car) {
        for (IParking parkPickWay : parkPickWays) {
            CarTicket carTicket = parkPickWay.park(car);
            if(carTicket != null){
                return carTicket;
            }
        }
        return null;
    }

    public Car pick(CarTicket carTicket) {
        for (IParking parkPickWay : parkPickWays) {
            Car car = parkPickWay.pick(carTicket);
            if(car != null){
                return car;
            }
        }
        return null;
    }
}
