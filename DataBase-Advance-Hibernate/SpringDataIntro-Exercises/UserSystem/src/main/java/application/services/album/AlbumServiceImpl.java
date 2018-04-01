package application.services.album;

import application.models.Album;
import application.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AlbumServiceImpl implements AlbumService<Album,Long> {

    private AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album findById(Long id) {
        return this.albumRepository.findOne(id);
    }

    @Override
    public void remove(Album object) {
        this.albumRepository.delete(object);
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepository.findAll();
    }

    @Override
    public void save(Album object) {
        this.albumRepository.save(object);
    }
}
