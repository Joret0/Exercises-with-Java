package application.services.licence;

import application.models.License;
import application.repositories.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LicenceServiceImpl implements LicenceService<License, Long>{
    private LicenceRepository licenceRepository;

    @Autowired
    public LicenceServiceImpl(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    @Override
    public List<License> findAllByResourceCourseId(Long id) {
        return this.licenceRepository.findAllByResourceCourseId(id);
    }

    @Override
    public License findById(Long id) {
        return this.licenceRepository.findOne(id);
    }

    @Override
    public void remove(License object) {
        this.licenceRepository.delete(object);
    }

    @Override
    public List<License> findAll() {
        return this.licenceRepository.findAll();
    }

    @Override
    public void save(License object) {
        this.licenceRepository.save(object);
    }
}
