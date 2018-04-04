package application.repositories;

import application.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query("select s.name, count(sc), sum(sc.price), avg(sc.price) " +
            "from Student s " +
            "inner join s.courses sc " +
            "group by s.name " +
            "order by sum(sc.price) desc, count(sc), s.name asc")
    List<Object[]> getStudentInfo();

    Student findByName(String name);

    List<Student> findAllByRegistrationDateAfter(Date date);



}
