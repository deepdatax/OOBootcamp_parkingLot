import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ParkingManagerTest {
    @Test
    public void when_manager_manages_one_parkingLot_and_park_one_car_should_the_same_car_pick_in_this_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }
}
