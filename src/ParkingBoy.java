import java.util.List;

public class ParkingBoy extends ParkingStaff {


    public ParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    ///////////////////////////////////////////////////////
    public CarTicket parkLamda(Car car) {
        final CarTicket[] ticket = new CarTicket[1];

        parkingLots.stream().anyMatch(x -> {
            ticket[0] = x.park(car);
            return ticket[0] != null;
        });

        return ticket[0];
    }

    public Car pickLamda(CarTicket ticket) {
        final Car[] pick = new Car[1];
        parkingLots.stream().anyMatch(x -> {
            pick[0] = x.pick(ticket);
            return pick[0] != null;
        });
        return pick[0];
    }
}
