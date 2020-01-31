/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chrismark.controllers;

import com.chrismark.entities.Salesman;
import com.chrismark.service.SalesmanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    SalesmanService service;

    @GetMapping
    public ResponseEntity<List<Salesman>> list() {

        List<Salesman> list = service.getSalesmen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salesman> get(@PathVariable("id") int id) {

        Salesman s = service.getSalesmanById(id);
        return ResponseEntity.ok().body(s);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Salesman>> getSalesmanByCity(@PathVariable("city") String city) {

        List<Salesman> list = service.getSalesmanByCity(city);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/comm/{min}/and/{max:.+}")
    public ResponseEntity<List<Salesman>> getSalesmanBetweenComm(@PathVariable("min") double minComm, @PathVariable("max") double maxComm) {
        List<Salesman> list = service.getBetweenComm(minComm, maxComm);
        return ResponseEntity.ok().body(list);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {

        service.deleteSalesman(id);
        return ResponseEntity.ok().body("Salesman has been deleted successfully");
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Salesman s) {
        int id = service.createSalesman(s);
        return ResponseEntity.ok().body("Salesman has been created successfully with ID: " + id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSalesman(@PathVariable("id") int id, @RequestBody Salesman s) {

        service.updateSalesman(id, s);
        return ResponseEntity.ok().body("Salesman has been updated successfully.");

    }

}
