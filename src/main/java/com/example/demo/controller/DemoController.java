package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(path="/all")
    public ResponseEntity<List<Demo>> getAllItems() {
        return ResponseEntity.ok().body(demoService.getAllItems());
    }

    @GetMapping(path="/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok().body("Welcome!!!");
    }

    @PostMapping
    public ResponseEntity<Demo> addNew(@RequestBody Demo demo) {
        return ResponseEntity.ok().body(demoService.addNew(demo));
    }

    @GetMapping(path="/exception")
    public ResponseEntity<String> getException() throws Exception {
        throw new Exception("Exception thrown!!!");
    }

    @GetMapping(path="/bad-request")
    public ResponseEntity<String> getBadRequest() {
        return ResponseEntity.badRequest().body("BAD REQUEST!!!");
    }

}