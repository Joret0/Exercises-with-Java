package application.repositories;

import application.models.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface LicenceRepository extends JpaRepository<License, Long>{
    List<License> findAllByResourceCourseId(Long id);
}
