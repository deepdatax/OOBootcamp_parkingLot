import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;


public class ParkingBoyTest {
    @Test
    public void WhenParkCarViaParkingBoyThenShouldPickTheCarViaParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        CarTicket ticket = parkingBoy.park(car);

        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    public void WhenParkCarViaParkingBoyThenShouldPickTheCarViaParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket ticket = parkingBoy.park(car);

        assertSame(car, parkingBoy.pick(ticket));
    }

    @Test
    public void WhenParkLotIsFullThenShouldNotPickAnyCarViaParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        assertNull(parkingBoy.park(new Car()));
    }

    @Test
    public void WhenCarIsParkedThenShouldNotPickAnyCarWithoutTicketsViaParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        assertNull(parkingBoy.pick(null));
    }

    @Test
    public void WhenCarIsParkedThenShouldNotPickAnyCarWithWrongTicketsViaParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        assertNull(parkingBoy.pick(new CarTicket()));
    }


    @Test
    public void WhenPickCarWithSameTicketTwiceShouldNotPickAnyCar() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot);
        CarTicket carTicket = parkingBoy.park(new Car());
        parkingBoy.pick(carTicket);

        assertNull(parkingBoy.pick(carTicket));
    }

    @Test
    public void WhenParkLotIsFullThenShouldPickCarViaParkingBoyAfterOneCarBeingPicked() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket carTicket = parkingBoy.park(new Car());
        parkingBoy.pick(carTicket);

        assertNotNull(parkingBoy.park(new Car()));
    }

    @Test
    public void WhenTwoAvailableParkLotsShouldParkInFirstParkLot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }


    @Test
    public void WhenTwoParkLotsAndFirstIsFullShouldParkInSecondParkLot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        parkingBoy.park(new Car());
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void WhenTwoParkLotsAndFirstIsFullShouldParkInSecondParkLotAfterOneCarBeingPickedFromSecondParkLot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        parkingBoy.park(new Car());
        CarTicket secondCarTicket = parkingBoy.park(new Car());
        secondParkingLot.pick(secondCarTicket);

        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        assertSame(car, secondParkingLot.pick(carTicket));
    }


}
