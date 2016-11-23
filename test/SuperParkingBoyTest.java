import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void when_park_car_via_super_parking_boy_should_pick_same_car_in_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void when_park_car_in_parking_lot_should_pick_same_car_via_super_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, superParkingBoy.pick(carTicket));
    }

    @Test
    public void when_parking_lot_is_full_should_not_park_any_cars() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot));
        parkingLot.park(car);

        assertNull(superParkingBoy.park(car));
    }

    @Test
    public void when_first_parking_has_zero_car_with_space_two_and_second_parking_has_one_with_space_two_should_park_the_car_in_first_one() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }

    @Test
    public void when_first_parking_has_one_car_with_space_two_and_second_parking_lot_has_parked_zero_with_space_two_should_park_the_car_in_second_one() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void when_first_parking_has_one_car_with_space_two_and_second_parking_lot_has_parked_one_with_space_two_should_park_the_car_in_first_one() {
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
    public void when_first_parking_has_one_car_with_space_three_and_second_parking_has_zero_car_with_space_two_should_park_the_car_in_second_one() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }
}
