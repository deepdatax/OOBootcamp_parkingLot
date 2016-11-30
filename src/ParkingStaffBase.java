import java.io.PrintStream;
import java.util.List;

public abstract class ParkingStaffBase implements IParking {
    List<ParkingLot> parkingLots;

    public ParkingStaffBase(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    @Override
    public Car pick(CarTicket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.IsCarInPark(ticket)){
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }

    @Override
    public CarTicket park(Car car) {
        ParkingLot maxParkingLot = parkingLots.get(0);
        for(ParkingLot parkingLot : parkingLots){
            if(canParkCarWithBestCondition(maxParkingLot, parkingLot)){
                maxParkingLot = parkingLot;
            }
        }
        return maxParkingLot.park(car);
    }

    abstract boolean canParkCarWithBestCondition(ParkingLot maxParkingLot, ParkingLot parkingLot);

    public String report() {
        int vacancy = 0;
        int total = 0;
        String parkingLotReport = "";

        for (ParkingLot parkingLot : parkingLots) {
            vacancy += parkingLot.vacancy();
            total += parkingLot.capacity;
            parkingLotReport += "\t" + parkingLot.report();
        }

        return getClass().getName()+"\t"+vacancy+"\t"+total+"\n" + parkingLotReport;

    }
}
