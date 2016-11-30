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

    @Override
    public int getVacancy() {
        int vacancy = 0;
        for (ParkingLot parkingLot : parkingLots) {
            vacancy += parkingLot.getVacancy();
        }
        return vacancy;
    }

    @Override
    public int getCapacity() {
        int capacity = 0;
        for (ParkingLot parkingLot : parkingLots) {
            capacity += parkingLot.getCapacity();
        }
        return capacity;
    }

    abstract boolean canParkCarWithBestCondition(ParkingLot maxParkingLot, ParkingLot parkingLot);

    @Override
    public String report() {
        String parkingLotReport = "";

        for (ParkingLot parkingLot : parkingLots) {
            parkingLotReport += "\t" + parkingLot.report();
        }

        return getClass().getName()+"\t"+getVacancy()+"\t"+getCapacity()+"\n" + parkingLotReport;

    }
}
