import java.util.List;

public class SuperParkingBoy extends ParkingStaffBase {

    public SuperParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    boolean canParkCarWithBestCondition(ParkingLot maxParkingLot, ParkingLot parkingLot) {
        return parkingLot.vacancyRate() > maxParkingLot.vacancyRate();
    }
}
