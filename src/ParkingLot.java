public class ParkingLot {

    int capacity;
    Car car;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        this.car = car;
        return new CarTicket();
    }

    public Car pick(CarTicket carTicket) {
        return car;
    }
}
