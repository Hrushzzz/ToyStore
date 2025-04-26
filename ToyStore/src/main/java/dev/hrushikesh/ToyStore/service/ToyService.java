package dev.hrushikesh.ToyStore.service;

import dev.hrushikesh.ToyStore.exception.ToyNotFoundException;
import dev.hrushikesh.ToyStore.model.Toy;
import dev.hrushikesh.ToyStore.repository.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public Toy saveToy(Toy toy) {
        Toy savedToy = toyRepository.save(toy);
        return savedToy;
    }

    public boolean deleteToy(int productId){
        toyRepository.deleteById(productId);
        return true;
    }

    public Toy getToy(int toyId){
        Optional<Toy> productOptional =
                toyRepository.findById(toyId);
        if(productOptional.isEmpty()){
            throw new ToyNotFoundException("Toy with id " + toyId + " not found");
        } else {
            return productOptional.get();
        }
    }

    public List<Toy> getAllToys(){
        return toyRepository.findAll();
    }

    public Toy updateToy(int toyId, Toy newToy) {
        Toy savedToy = getToy(toyId);

        savedToy.setName(newToy.getName());
        savedToy.setDescription(newToy.getDescription());
        savedToy.setManufacturedYear(newToy.getManufacturedYear());
        savedToy.setPrice(newToy.getPrice());
        savedToy.setInStock(newToy.isInStock());

        // Saving the updated existing object
        Toy updatedToy = toyRepository.save(savedToy);
        return updatedToy;
    }
}
