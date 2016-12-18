import java.io.PrintStream;
import java.util.List;

public class ParkingManager implements IReport {
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

    @Override
    public int getVacancy() {
        int vacancy = 0;
        for (IParking parkPickWay : parkPickWays) {
            vacancy += parkPickWay.getVacancy();
        }
        return vacancy;
    }

    @Override
    public int getCapacity() {
        int capacity = 0;
        for (IParking parkPickWay : parkPickWays) {
            capacity += parkPickWay.getCapacity();
        }
        return capacity;
    }

    @Override
    public String report(String tab) {
        String parkingLotReport = "";

        for (IParking parkPickWay : parkPickWays) {
            parkingLotReport += parkPickWay.report(tab + "\t");
        }

        return tab + getClass().getName()+"\t"+getVacancy()+"\t"+getCapacity()+"\n" + parkingLotReport;
    }
}
