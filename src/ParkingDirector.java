import java.io.PrintStream;

public class ParkingDirector implements IReport{
    private ParkingManager parkingManager;

    public ParkingDirector(ParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public void report(PrintStream out) {
    }

    @Override
    public int getVacancy() {
        return parkingManager.getVacancy();
    }

    @Override
    public int getCapacity() {
        return parkingManager.getCapacity();
    }

    @Override
    public String report(String tab) {
        return getClass().getName() + "\t" + getVacancy() + "\t" + getCapacity() + "\n" + parkingManager.report("\t");
    }
}
