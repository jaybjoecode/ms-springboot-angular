package com.example.apiserver.services;

import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.mappers.TopicMapper;
import com.example.apiserver.models.Topic;
import com.example.apiserver.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TopicService {

    @Autowired
    private TopicRepository repository;
    @Autowired
    private TopicMapper mapper;

    public TopicService() {
    }

    public List<Topic> getAll() {
        List<Topic> topics = new ArrayList<>();
        topics = repository.findAll();
        return topics;
    }

    public Topic get(String id) {
        return repository.findById(id).get();
    }

    public void create(TopicDTO dto) {
        Topic topic = mapper.map(dto);
        repository.save(topic);

    }

    public void update(String id, TopicDTO dto) {
        Topic topic = repository.findById(id).get();
        mapper.map(dto, topic);
        repository.save(topic);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
