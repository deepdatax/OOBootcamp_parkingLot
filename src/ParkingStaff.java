import java.util.Arrays;
import java.util.List;

public class ParkingStaff {
    List<ParkingLot> parkingLots;

    public ParkingStaff(ParkingLot parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    public ParkingStaff(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
    }

    public CarTicket park(Car car) {
        for(ParkingLot parkingLot : parkingLots){
            if(!parkingLot.IsParkLotFull()){
                return parkingLot.park(car);
            }
        }
        return null;
    }

    public Car pick(CarTicket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.IsCarInPark(ticket)){
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }
}
