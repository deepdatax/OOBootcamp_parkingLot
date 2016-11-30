import java.util.List;

public class SmartParkingBoy extends ParkingStaffBase {

    public SmartParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }

    @Override
    boolean canParkCarWithBestCondition(ParkingLot maxParkingLot, ParkingLot parkingLot) {
        return parkingLot.getVacancy() > maxParkingLot.getVacancy();
    }


}
