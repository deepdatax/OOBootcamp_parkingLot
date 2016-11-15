import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void WhenParkCarInParkingLotShouldPickSameCarInParkingLot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void WhenParkCarInParkingLotShouldPickSameCarViaSuperParkingLot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, superParkingBoy.pick(carTicket));
    }

    @Test
    public void WhenParkingLotIsFullShouldNotParkAnyCars() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        parkingLot.park(car);

        assertNull(superParkingBoy.park(car));
    }

    @Test
    public void WhenFirstParkingHasZeroCarWithSpaceTwoAndSecondParkingLotHasParkedOneWithSpaceTwoShouldParkTheCarInFirstOne() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }

    @Test
    public void WhenFirstParkingHasOneCarWithSpaceTwoAndSecondParkingLotHasParkedZeroWithSpaceTwoShouldParkTheCarInSecondOne() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void WhenFirstParkingHasOneCarWithSpaceTwoAndSecondParkingLotHasParkedOneWithSpaceTwoShouldParkTheCarInFirstOne() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        secondParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }

    @Test
    public void WhenFirstParkingHasOneCarWithSpaceThreeAndSecondParkingLotHasZeroCarWithSpaceTwoShouldParkTheCarInSecondOne() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }
}
