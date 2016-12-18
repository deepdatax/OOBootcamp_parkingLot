public interface IParking extends IReport {
    Car pick(CarTicket ticket);

    CarTicket park(Car car);

}
