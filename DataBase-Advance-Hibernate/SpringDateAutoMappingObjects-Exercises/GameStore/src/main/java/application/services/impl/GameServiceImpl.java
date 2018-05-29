package application.services.impl;

import application.models.Game;
import application.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.GameRepository;
import application.services.api.GameService;

import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService<Game, Long>{

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findGameByTitle(String title) {
        return this.gameRepository.findGameByTitle(title);
    }

    @Override
    public List<Game> findGameByOwners(Set<User> owners) {
        return this.findGameByOwners(owners);
    }

    @Override
    public Game findById(Long id) {
        return this.gameRepository.findOne(id);
    }

    @Override
    public void remove(Game object) {
        this.gameRepository.delete(object);
    }

    @Override
    public List<Game> findAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public void save(Game object) {
        this.gameRepository.save(object);
    }
}
