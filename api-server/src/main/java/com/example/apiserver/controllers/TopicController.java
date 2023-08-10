package com.example.apiserver.controllers;

import com.example.apiserver.core.CustomError;
import com.example.apiserver.core.CustomResponse;
import com.example.apiserver.dtos.TopicDTO;
import com.example.apiserver.models.Topic;
import com.example.apiserver.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService service;
    public ResponseEntity<?> getPerson() {
        var list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public CustomResponse<List<Topic>> getAll() {
        var list = service.getAll();
        return CustomResponse.ok(list);
    }

    @GetMapping("{id}")
    public CustomResponse<Topic> get(@PathVariable String id) {
        var response = service.get(id);
        return CustomResponse.ok(response);
    }

    @PostMapping
    public CustomResponse<?> create(@RequestBody TopicDTO dto) {
        service.create(dto);
        return CustomResponse.ok();
    }

    @PutMapping("{id}")
    public CustomResponse<?> update(@PathVariable String id, @RequestBody TopicDTO dto) {
        service.update(id, dto);
        return CustomResponse.ok();
    }

    @DeleteMapping("{id}")
    public CustomResponse<?> delete(@PathVariable String id) {
        service.delete(id);
        return CustomResponse.ok();
    }

    @GetMapping("test-error")
    public CustomResponse<?> testError() {
        // simulate error
        throw new CustomError("Topics blocked!");
    }
}
