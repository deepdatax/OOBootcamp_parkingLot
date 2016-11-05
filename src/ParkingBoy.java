import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = Arrays.asList(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
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
