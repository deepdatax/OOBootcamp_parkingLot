import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void when_park_a_car_via_parking_boy_should_pick_car_via_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void when_park_a_car_via_parking_boy_should_pick_car_via_smart_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, smartParkingBoy.pick(carTicket));
    }

    @Test
    public void when_parking_lot_is_full_should_pick_car_via_smart_parking_boy_after_one_car_being_picked() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        CarTicket carTicket = smartParkingBoy.park(car);
        assertNull(smartParkingBoy.park(new Car()));
        smartParkingBoy.pick(carTicket);

        assertNotNull(smartParkingBoy.park(new Car()));

    }

    @Test
    public void when_park_a_car_via_parking_boy_in_full_parking_lot_should_not_park_car_via_smart_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);

        assertNull(smartParkingBoy.park(new Car()));
    }

    @Test
    public void when_park_a_car_via_parking_boy_should_not_park_car_without_tickets_via_smart_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.park(new Car());

        assertNull(smartParkingBoy.pick(null));
    }

    @Test
    public void when_park_a_car_via_parking_boy_should_not_park_car_with_wrong_tickets_via_smart_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.park(new Car());

        assertNull(smartParkingBoy.pick(new CarTicket()));
    }

    @Test
    public void when_first_parking_lot_has_more_vacancy_than_second_one_and_park_a_car_via_parking_boy_parking_lot_should_pick_car_in_first_parking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));

    }

    @Test
    public void when_second_parking_lot_has_more_vacancy_than_first_one_and_park_a_car_via_parking_boy_parking_lot_should_pick_car_in_second_parking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));

    }

    @Test
    public void when_two_parking_lot_has_same_available_vacancy_and_park_a_car_via_parking_boy_parking_lot_should_pick_car_in_first_parking() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));
        CarTicket carTicket = smartParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));

    }


}
