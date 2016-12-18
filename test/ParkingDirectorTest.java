import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingDirectorTest {
    @Test
    public void when_there_is_parking_manager_and_parking_lot_should_return_report() throws Exception {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        assertEquals("ParkingDirector\t1\t1\n\tParkingManager\t1\t1\n\t\tParkingLot\t1\t1\n",
                parkingDirector.report(""));
    }

    @Test
    public void when_there_is_parking_manager_and_car_is_parked_in_parking_lot_should_return_report() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingLot));
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);
        parkingLot.park(new Car());

        assertEquals("ParkingDirector\t0\t1\n\tParkingManager\t0\t1\n\t\tParkingLot\t0\t1\n",
                parkingDirector.report(""));
    }

    @Test
    public void when_parking_manager_and_parking_boy_manage_parking_lot_should_return_report() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1)));
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1), parkingBoy));
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        assertEquals("ParkingDirector\t2\t2\n\tParkingManager\t2\t2\n\t\tParkingLot\t1\t1\n\t\tParkingBoy\t1\t1\n\t\t\tParkingLot\t1\t1\n",
                parkingDirector.report(""));
    }

    @Test
    public void when_there_is_parking_manager_and_parking_lot_should_print_report() throws Exception {
        ParkingManager parkingManager = new ParkingManager(Arrays.asList(new ParkingLot(1)));
        ParkingDirector parkingDirector = new ParkingDirector(parkingManager);

        PrintStream out = mock(PrintStream.class);

        parkingDirector.printReport(out);
        verify(out).print("ParkingDirector\t1\t1\n\tParkingManager\t1\t1\n\t\tParkingLot\t1\t1\n");
    }
}
