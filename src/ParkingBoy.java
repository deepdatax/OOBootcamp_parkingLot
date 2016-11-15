import java.util.List;

public class ParkingBoy extends ParkingStaffBase {

    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public CarTicket park(Car car) {
        for(ParkingLot parkingLot : parkingLots){
            if(!parkingLot.IsParkLotFull()){
                return parkingLot.park(car);
            }
        }
        return null;
    }
}
