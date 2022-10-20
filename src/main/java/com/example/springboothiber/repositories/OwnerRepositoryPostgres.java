package com.example.springboothiber.repositories;

import com.example.springboothiber.model.Owner;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public class OwnerRepositoryPostgres implements OwnerRepository{
    @Override
    @Query(value = "SELECT * FROM ",nativeQuery = true)
    public Owner getOwnerById(Long id) {
        return null;
    }

    @Override
    public List<Owner> getOwners() {
        return null;
    }

    @Override
    public Owner addOwner(Owner owner) {
        return null;
    }
}
