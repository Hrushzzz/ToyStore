package dev.hrushikesh.ToyStore.repository;

import dev.hrushikesh.ToyStore.model.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Integer> {
}

/*
    Extending JpaRepository adds all fundamental CRUD operation methods in ProductRepository interface
    we don't need to implement those methods, Spring Data JPA will do that for us
    We will just use them directly
 */