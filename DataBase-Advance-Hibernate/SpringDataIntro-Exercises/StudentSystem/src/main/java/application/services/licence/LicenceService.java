package application.services.licence;

import application.services.base.BaseService;

import java.util.List;

public interface LicenceService<License, Long> extends BaseService<License, Long>{
    List<License> findAllByResourceCourseId(Long id);
}
