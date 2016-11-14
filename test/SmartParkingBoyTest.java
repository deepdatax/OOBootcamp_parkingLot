import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void WhenParkACarViaParkingBoyShouldPickCarViaParkingLot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void WhenParkACarViaParkingBoyShouldPickCarViaSmartParkingBoy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, smartParkingBoy.pick(carTicket));
    }

    @Test
    public void WhenParkingLotIsFullShouldPickCarViaSmartParkingBoyAfterOneCarBeingPicked() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);
        assertNull(smartParkingBoy.park(new Car()));
        smartParkingBoy.pick(carTicket);

        assertNotNull(smartParkingBoy.park(new Car()));

    }

    @Test
    public void WhenParkACarViaParkingBoyInFullParkingLotShouldNotParkCarViaSmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);

        assertNull(smartParkingBoy.park(new Car()));
    }

    @Test
    public void WhenParkACarViaParkingBoyShouldNotParkCarWithoutTicketsViaSmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.park(new Car());

        assertNull(smartParkingBoy.pick(null));
    }

    @Test
    public void WhenParkACarViaParkingBoyShouldNotParkCarWithWrongTicketsViaSmartParkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.park(new Car());

        assertNull(smartParkingBoy.pick(new CarTicket()));
    }

    @Test
    public void WhenFirstParkingLotHasMoreVacancyThanSecondOneAndParkACarViaParkingBoyParkingLotShouldPickCarInFirstParking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));

    }

    @Test
    public void WhenSecondParkingLotHasMoreVacancyThanFirstOneAndParkACarViaParkingBoyParkingLotShouldPickCarInSecondParking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));

    }

    @Test
    public void WhenTwoParkingLotHasSameAvailableVacancyAndParkACarViaParkingBoyParkingLotShouldPickCarInFirstParking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));

    }


}
