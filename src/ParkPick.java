public interface ParkPick {
    Car pick(CarTicket ticket);

    CarTicket park(Car car);
}
