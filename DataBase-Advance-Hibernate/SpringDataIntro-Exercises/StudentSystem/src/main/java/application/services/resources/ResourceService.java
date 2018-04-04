package application.services.resources;

import application.services.base.BaseService;

import java.util.List;


public interface ResourceService<Resource, Long> extends BaseService<Resource, Long>{
    Resource findByName(String name);
    List<Resource> findAllByCourseName(String name);
}
