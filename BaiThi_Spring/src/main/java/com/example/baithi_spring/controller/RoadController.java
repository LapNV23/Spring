package com.example.baithi_spring.controller;

import com.example.baithi_spring.entity.Road;
import com.example.baithi_spring.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1/road")
public class RoadController {
    @Autowired
    RoadService roadService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Road>> getList() {
        return ResponseEntity.ok(roadService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Road> create(@RequestBody Road road) {
        return ResponseEntity.ok(roadService.save(road));
    }

}
