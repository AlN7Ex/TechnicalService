package com.example.springboothiber.repositories;

import com.example.springboothiber.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository {
    Owner getOwnerById(Long id);
    List<Owner> getOwners();
    Owner addOwner(Owner owner);
}
