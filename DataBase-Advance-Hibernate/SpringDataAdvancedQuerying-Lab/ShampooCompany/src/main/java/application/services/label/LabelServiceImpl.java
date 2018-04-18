package application.services.label;

import application.model.labels.BasicLabel;
import application.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class LabelServiceImpl implements LabelService<BasicLabel, Long>{
    private LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public BasicLabel findOne(Long aLong) {
        return this.labelRepository.findOne(aLong);
    }
}
