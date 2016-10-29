import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertSame;

public class ParkingLotTest {
    @Test
    public void ShouldBeEqual() {
        assertEquals(1, 1);
    }

    @Test
    public void ShouldPickTheSameCarWhenCarWasParkedInParkLot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        CarTicket carTicket = parkingLot.park(car);
        assertSame(car, parkingLot.pick(carTicket));
    }

    
}
