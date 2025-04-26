package dev.hrushikesh.ToyStore.controller;

import dev.hrushikesh.ToyStore.model.Toy;
import dev.hrushikesh.ToyStore.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToyController {

    @Autowired
    private ToyService toyService;

    @PostMapping("/toys")
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        Toy savedToy = toyService.saveToy(toy);
        return ResponseEntity.ok(savedToy);
    }

    @GetMapping("/toys")
    public ResponseEntity<List<Toy>> getAllToys(){
        List<Toy> toys = toyService.getAllToys();
        return ResponseEntity.ok(toys);
    }

    @GetMapping("/toys/{id}")
    public ResponseEntity<Toy> getToyById(@PathVariable("id") int id){
        Toy savedToy = toyService.getToy(id);
        return ResponseEntity.ok(savedToy);
    }

    @PutMapping("/toys/{id}")
    public ResponseEntity<Toy> updateToy(@PathVariable("id") int id,  @RequestBody Toy toy) {
        Toy updatedToy = toyService.updateToy(id, toy);
        return ResponseEntity.ok(updatedToy);
    }

    @DeleteMapping("/toys/{id}")
    public ResponseEntity<Boolean> deleteToyById(@PathVariable("id") int id){
        boolean response = toyService.deleteToy(id);
        return ResponseEntity.ok(response);
    }
}
