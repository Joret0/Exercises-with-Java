import entities.motor.Car;
import entities.motor.Plane;
import entities.motor.ship.CargoShip;
import entities.motor.ship.CruiseShip;
import entities.motor.train.Carriage;
import entities.motor.train.CarriageType;
import entities.motor.train.Locomotive;
import entities.motor.train.Train;
import entities.nonmotor.Bike;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle_database");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Car car = new Car();
        car.setManufacturer("BMW");
        car.setMaxSpeed(200);
        car.setModel("BMW 530 M");
        car.setPrice(new BigDecimal(5000));
        car.setNumberOfDoors(5);
        car.setInformation("Some info");
        car.setEngineType("Diesel");
        car.setNumberOfEngine(5);
        car.setTankCapacity(80);
        em.persist(car);

        Bike bike = new Bike();
        bike.setPrice(new BigDecimal(200));
        bike.setModel("bmx");
        bike.setMaxSpeed(55);
        bike.setManufacturer("BMX");
        bike.setColor("white");
        bike.setShiftCount(1);
        em.persist(bike);

        CargoShip cargoShip = new CargoShip();
        cargoShip.setTankCapacity(1000);
        cargoShip.setManufacturer("Navi Transport");
        cargoShip.setNumberOfEngine(10);
        cargoShip.setEngineType("Diesel");
        cargoShip.setMaxSpeed(80);
        cargoShip.setMaxLoadKg(2000000);
        cargoShip.setCaptainName("Georgi Stalev");
        cargoShip.setCrewSize(50);
        cargoShip.setModel("Tanker");
        cargoShip.setPrice(new BigDecimal(900000));
        em.persist(cargoShip);

        CruiseShip cruiseShip = new CruiseShip();
        cruiseShip.setTankCapacity(1000);
        cruiseShip.setManufacturer("Navi Transport");
        cruiseShip.setNumberOfEngine(20);
        cruiseShip.setEngineType("Diesel");
        cruiseShip.setMaxSpeed(90);
        cruiseShip.setPassengerCapacity(4000);
        cruiseShip.setCaptainName("Georgi Stalev");
        cruiseShip.setCrewSize(200);
        cruiseShip.setModel("ShipModel");
        cruiseShip.setPrice(new BigDecimal(20000000));
        em.persist(cruiseShip);

        Plane plane = new Plane();
        plane.setMaxSpeed(1000);
        em.persist(plane);

        Locomotive locomotive = new Locomotive();
        locomotive.setModel("Locomotive Model");
        locomotive.setPower(20000);
        em.persist(locomotive);

        Train train = new Train();
        train.setManufacturer("Train Construction");
        train.setMaxSpeed(160);
        train.setModel("RocketTrain");
        train.setPrice(new BigDecimal(1000000));
        train.setEngineType("Diesel");
        train.setNumberOfEngine(4);
        train.setTankCapacity(1000);
        train.setLocomotive(locomotive);
        train.setNumberOfCarriage(900);
        em.persist(train);

        Carriage carriage = new Carriage();
        carriage.setCarriageType(CarriageType.Restauraunt);
        carriage.setTrain(train);
        carriage.setCarriageTypeCount(120);
        em.persist(carriage);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
