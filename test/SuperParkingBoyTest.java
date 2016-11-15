import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void When_Park_Car_Via_Super_Parking_Boy_Should_Pick_Same_Car_In_ParkingLot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, parkingLot.pick(carTicket));
    }

    @Test
    public void When_Park_Car_In_ParkingLot_Should_Pick_Same_Car_Via_Super_Parking_Boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, superParkingBoy.pick(carTicket));
    }

    @Test
    public void When_Parking_Lot_Is_Full_Should_Not_Park_Any_Cars() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        parkingLot.park(car);

        assertNull(superParkingBoy.park(car));
    }

    @Test
    public void When_First_Parking_Has_Zero_Car_With_Space_Two_And_Second_Parking_Has_One_With_Space_Two_Should_Park_The_Car_In_FirstOne() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(carTicket));
    }

    @Test
    public void When_First_Parking_Has_One_Car_With_Space_Two_And_Second_Parking_Lot_Has_Parked_Zero_With_Space_Two_Should_Park_The_Car_In_Second_One() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(2);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }

    @Test
    public void When_First_Parking_Has_One_Car_With_Space_Two_And_Second_ParkingLot_Has_Parked_One_With_Space_Two_Should_Park_The_Car_In_First_One() {
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
    public void When_First_Parking_Has_One_Car_With_Space_Three_And_Second_Parking_Has_Zero_Car_With_Space_Two_Should_Park_The_Car_In_Second_One() {
        Car car = new Car();
        ParkingLot firstParkingLot = new ParkingLot(3);
        ParkingLot secondParkingLot = new ParkingLot(2);
        firstParkingLot.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(firstParkingLot, secondParkingLot));

        CarTicket carTicket = superParkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(carTicket));
    }
}
