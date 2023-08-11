package com.example.apiserver.mappers;

import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.models.Topic;
import org.springframework.stereotype.Service;

@Service
public class TopicMapper extends BaseMapper<TopicDTO, Topic> {
    public TopicMapper() {
    }

    @Override
    protected void setParameters(TopicDTO dto, Topic entity) {
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
    }
}

