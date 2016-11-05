import org.junit.Test;
import static junit.framework.TestCase.assertNotSame;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ParkingLotTest {

    @Test
    public void WhenCarWasParkedInParkLotShouldPickTheSameCar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        CarTicket carTicket = parkingLot.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test()
    public void WhenParkLotIsFullShouldNotParkAnyCars() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        assertNull(parkingLot.park(new Car()));
    }

    @Test()
    public void WhenParkLotIsFullAndOneCarIsPickedShouldParkAnotherCars() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        Car secondCar = new Car();

        parkingLot.pick(firstCarTicket);
        assertNotNull(parkingLot.park(secondCar));
    }

    @Test
    public void WhenCarWasParkedInParkLotShouldNotPickAnyCarsWithoutTickets() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        assertNull(parkingLot.pick(null));
    }

    @Test
    public void WhenCarWasParkedInParkLotShouldNotPickAnyCarWrongTickets() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        assertNull(parkingLot.pick(new CarTicket()));
    }

    @Test()
    public void WhenTwoCarsParkedInParkLotShouldNotPickFirstCarsUsingSecondTicket() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        Car secondCar = new Car();
        CarTicket secondCarTicket = parkingLot.park(secondCar);

        assertNotSame(firstCar, parkingLot.pick(secondCarTicket));
        assertSame(firstCar, parkingLot.pick(firstCarTicket));
    }

    @Test()
    public void WhenTwoCarsParkedInParkLotShouldNotPickCarsUsingSameTicketTwice() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);

        assertSame(firstCar, parkingLot.pick(firstCarTicket));
        assertNull(null, parkingLot.pick(firstCarTicket));
    }

}
