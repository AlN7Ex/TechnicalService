package com.example.springboothiber.repositories;

import com.example.springboothiber.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query(value = "SELECT service.owners.id, first_name, last_name, age, c.model, c.brand FROM service.owners INNER JOIN service.cars c ON owners.id = c.owner_id WHERE owners.id = :id",nativeQuery = true)
    Owner getOwnerById(Long id);
//    List<Owner> getOwners();
//    Owner addOwner(Owner owner);
}
