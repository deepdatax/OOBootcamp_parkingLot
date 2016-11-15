import java.util.Arrays;
import java.util.List;

public class ParkingStaffBase {
    List<ParkingLot> parkingLots;

    public ParkingStaffBase(ParkingLot parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    public ParkingStaffBase(List<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
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
