import java.util.List;

public class ParkingBoy extends ParkingStaffBase {

    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    boolean canParkCarWithBestCondition(ParkingLot maxParkingLot, ParkingLot parkingLot) {
        return maxParkingLot.IsParkLotFull() && !parkingLot.IsParkLotFull();
    }

}
