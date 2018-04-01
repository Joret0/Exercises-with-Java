package application.services.picture;

import application.models.Picture;
import application.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PictureServiceImpl implements PictureService<Picture, Long>{

    private PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture findById(Long id) {
        return this.pictureRepository.findOne(id);
    }

    @Override
    public void remove(Picture object) {
        this.pictureRepository.delete(object);
    }

    @Override
    public List<Picture> findAll() {
        return this.pictureRepository.findAll();
    }

    @Override
    public void save(Picture object) {
        this.pictureRepository.save(object);
    }
}
