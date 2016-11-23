import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertSame;

public class ParkingManagerTest {
    @Test
    public void when_manager_manages_one_parkingLot_and_park_one_car_should_the_same_car_pick_in_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingLot_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingBoy_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingBoy);
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingBoy_one_parkingLot_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingBoy, parkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }
}
