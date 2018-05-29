package application.services.api;

import java.util.List;

public interface Service<E, K> {
    E findById(K id);
    void remove(E object);
    List<E> findAll();
    void save(E object);
}
