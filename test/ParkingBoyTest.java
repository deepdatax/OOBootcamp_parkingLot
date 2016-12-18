import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ParkingBoyTest {
    @Test
    public void when_park_car_via_parking_boy_then_should_pick_the_car_via_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();

        CarTicket ticket = parkingBoy.park(car);

        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    public void when_park_car_via_parking_boy_then_should_pick_the_car_via_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        Car car = new Car();
        CarTicket ticket = parkingBoy.park(car);

        assertSame(car, parkingBoy.pick(ticket));
    }

    @Test
    public void when_park_lot_is_full_then_should_not_pick_any_car_via_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        parkingBoy.park(new Car());

        assertNull(parkingBoy.park(new Car()));
    }

    @Test
    public void when_car_is_parked_then_should_not_pick_any_car_without_tickets_via_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        parkingBoy.park(new Car());

        assertNull(parkingBoy.pick(null));
    }

    @Test
    public void when_car_is_parked_then_should_not_pick_any_car_with_wrong_tickets_via_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        parkingBoy.park(new Car());

        assertNull(parkingBoy.pick(new CarTicket()));
    }


    @Test
    public void when_pick_car_with_same_ticket_twice_should_not_pick_any_car() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot));
        CarTicket carTicket = parkingBoy.park(new Car());
        parkingBoy.pick(carTicket);

        assertNull(parkingBoy.pick(carTicket));
    }

    @Test
    public void when_park_lot_is_full_then_should_pick_car_via_parking_boy_after_one_car_being_picked() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
        CarTicket carTicket = parkingBoy.park(new Car());
        parkingBoy.pick(carTicket);

        assertNotNull(parkingBoy.park(new Car()));
    }

    @Test
    public void when_two_available_park_lots_should_park_in_first_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }


    @Test
    public void when_two_park_lots_and_first_is_full_should_park_in_second_park_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        parkingBoy.park(new Car());
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void when_two_park_lots_and_first_is_full_should_park_in_second_park_lotAfterOneCarBeingPickedFromSecondParkLot() {
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

    @Test
    public void when_parking_boy_manages_one_parking_lot_should_give_report() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));

        assertEquals("ParkingBoy\t1\t1\n\tParkingLot\t1\t1\n", parkingBoy.report(""));
    }


    @Test
    public void when_parking_boy_manages_many_parking_lots_should_give_report() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        assertEquals("ParkingBoy\t3\t3\n\tParkingLot\t1\t1\n\tParkingLot\t2\t2\n", parkingBoy.report(""));
    }
}
