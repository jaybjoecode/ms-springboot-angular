package com.example.apiserver.mappers;

import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.models.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicMapper {
    public TopicMapper() {
    }

    public Topic map(TopicDTO source, Topic target) {
        if (target == null) {
            target = new Topic();
        }
        setDirectFields(source, target);
        return target;
    }

    public Topic map(TopicDTO source) {
        return map(source, null);
    }

    private void setDirectFields(TopicDTO source, Topic target) {
        if (target.getName() != null) target.setName(source.getName());
        if (target.getDescription() != null) target.setDescription(source.getDescription());
    }
}

