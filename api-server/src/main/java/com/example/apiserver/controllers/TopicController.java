package com.example.apiserver.controllers;

import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.models.Topic;
import com.example.apiserver.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService service;

    @GetMapping
    public List<Topic> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Topic get(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody Topic topicDTO) {
        service.create(topicDTO);
    }

    @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody Topic topicDTO) {
        service.update(id, topicDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
