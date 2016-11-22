public class ParkingManager {
    ParkingLot parkingLot;
    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket park(Car car) {
        return parkingLot.park(car);
    }
}
