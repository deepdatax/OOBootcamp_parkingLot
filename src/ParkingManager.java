import java.io.PrintStream;
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

    public String report() {
        int vacancy = 0;
        int total = 0;
        String parkingLotReport = "";

        for (IParking parkPickWay : parkPickWays) {
            vacancy += parkPickWay.getVacancy();
            total += parkPickWay.getCapacity();
            parkingLotReport += "\t" + parkPickWay.report();
        }

        return getClass().getName()+"\t"+vacancy+"\t"+total+"\n" + parkingLotReport;
    }
}
