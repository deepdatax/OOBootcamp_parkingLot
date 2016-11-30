import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertNotSame;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {

    @Test
    public void when_car_was_parked_in_park_lot_should_pick_the_same_car() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        CarTicket carTicket = parkingLot.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test()
    public void when_park_lot_is_full_should_not_park_any_cars() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        assertNull(parkingLot.park(new Car()));
    }

    @Test()
    public void when_park_lot_is_full_and_one_car_is_picked_should_park_another_cars() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        Car secondCar = new Car();

        parkingLot.pick(firstCarTicket);
        assertNotNull(parkingLot.park(secondCar));
    }

    @Test
    public void when_car_was_parked_in_park_lot_should_not_pick_any_cars_without_tickets() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        assertNull(parkingLot.pick(null));
    }

    @Test
    public void when_car_was_parked_in_park_lot_should_not_pick_any_car_wrong_tickets() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        assertNull(parkingLot.pick(new CarTicket()));
    }

    @Test()
    public void when_two_cars_parked_in_park_lot_should_not_pick_first_cars_using_second_ticket() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);
        Car secondCar = new Car();
        CarTicket secondCarTicket = parkingLot.park(secondCar);

        assertNotSame(firstCar, parkingLot.pick(secondCarTicket));
        assertSame(firstCar, parkingLot.pick(firstCarTicket));
    }

    @Test()
    public void when_two_cars_parked_in_park_lot_should_not_pick_cars_using_same_ticket_twice() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        CarTicket firstCarTicket = parkingLot.park(firstCar);

        assertSame(firstCar, parkingLot.pick(firstCarTicket));
        assertNull(null, parkingLot.pick(firstCarTicket));
    }

    @Test
    public void when_parking_lot_has_one_available_position_should_print_report() {
        ParkingLot parkingLot = new ParkingLot(1);

        assertEquals("ParkingLot\t1\t1\n", parkingLot.report());

    }

    @Test
    public void when_parking_lot_has_no_available_position_should_print_report() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        assertEquals("ParkingLot\t0\t1\n", parkingLot.report());
    }
}
