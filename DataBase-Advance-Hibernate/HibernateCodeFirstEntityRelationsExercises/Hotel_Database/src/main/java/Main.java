import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_database");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = new Employee();
        employee.setFirstName("Georgi");
        employee.setLastName("Stalev");
        employee.setTitle("Project Manager");
        em.persist(employee);

        Customer customer = new Customer();
        customer.setAccountNumber("1234567890");
        customer.setFirstName("Ivan");
        customer.setLastName("Stalev");
        customer.setPhoneNumber("0123456789");
        customer.setEmergencyName("Aneta");
        customer.setPhoneNumber("0123456789");
        em.persist(customer);

        RoomStatus roomStatus = new RoomStatus();
        roomStatus.setRoomStatus("reserved");
        em.persist(roomStatus);

        RoomType roomType1 = new RoomType();
        roomType1.setRoomType("Large room");
        em.persist(roomType1);

        RoomType roomType2 = new RoomType();
        roomType2.setRoomType("Single room");
        em.persist(roomType2);

        BedType bedType = new BedType();
        bedType.setBedType("Large bed");
        em.persist(bedType);

        Room room = new Room();
        room.setRoomNumber("10");
        room.setRoomType(roomType1);
        room.setBedType(bedType);
        room.setRate(new BigDecimal(10));
        room.setRoomStatus(roomStatus);
        em.persist(room);

        Occupancy occupancy = new Occupancy();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 07, 07);
        Date date = calendar.getTime();
        occupancy.setDateOccupied(date);
        occupancy.setAccountNumber(customer);
        occupancy.setRoomNumber(room);
        occupancy.setRateApplied(new BigDecimal(9.3));
        occupancy.setPhoneCharge("0123456789");
        em.persist(occupancy);

        Payment payment = new Payment();
        payment.setPaymentDate(date);
        payment.setAccountNumber(customer);

        payment.setFirstDateOccupied(occupancy);
        payment.setLastDateOccupied(occupancy);

        payment.setTotalDays(20);
        payment.setAmountCharged(new BigDecimal(8.2));
        payment.setTaxRate(new BigDecimal(2));
        payment.setTaxAmount(new BigDecimal(10));
        payment.setPaymentTotal(new BigDecimal(500));
        em.persist(payment);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
