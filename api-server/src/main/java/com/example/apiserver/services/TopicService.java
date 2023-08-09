package com.example.apiserver.services;

import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.models.Topic;
import com.example.apiserver.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public TopicService() {
    }

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "name 1", "description 1"),
            new Topic("2", "name 2", "description 2"),
            new Topic("3", "name 3", "description 3")
    ));

    public List<Topic> getAll() {
        //return topics;
        List<Topic> topics = new ArrayList<>();
        repository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic get(String id) {
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return repository.findById(id).get();
    }

    public void create(Topic topicDTO) {

        repository.save(topicDTO);
    }

    public void update(String id, Topic topicDTO) {
        /*for (int i=0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.set(i, topicDTO);
                return;
            }
        }*/
        repository.save(topicDTO);
    }

    public void delete(String id) {
        //topics.removeIf(t -> t.getId().equals(id));
        repository.deleteById(id);
    }

}
