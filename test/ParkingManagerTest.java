import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertSame;

public class ParkingManagerTest {
    @Test
    public void when_manager_manages_one_parkingLot_and_park_one_car_should_the_same_car_pick_in_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingLot_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingBoy_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingBoy));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }

    @Test
    public void when_manager_manages_one_parkingBoy_one_parkingLot_and_park_one_car_should_the_same_car_pick_via_manager() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingBoy, parkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(carTicket));
    }

    @Test
    public void when_there_are_two_parkingLots_manager_let_smart_parkingBoy_park_one_car_should_the_same_car_pick_in_more_vacancy_one() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(smartParkingBoy, firstParkingLot, secondParkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void when_there_are_two_parkingLots_manager_let_super_parkingBoy_park_one_car_should_the_same_car_pick_in_more_vacancy_rate_one() {
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(superParkingBoy, firstParkingLot, secondParkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingManager.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }
}
