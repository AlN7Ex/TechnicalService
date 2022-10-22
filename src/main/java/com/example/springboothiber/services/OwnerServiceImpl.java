package com.example.springboothiber.services;

import com.example.springboothiber.response.CarResponse;
import com.example.springboothiber.response.OwnerResponse;
import com.example.springboothiber.model.Owner;
import com.example.springboothiber.repositories.OwnerRepository;
import com.example.springboothiber.request.OwnerRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository repository;

    @Override
    public OwnerResponse getOwner(Long id) {
        Owner owner = repository.getOwnerById(id);
        OwnerResponse response = new OwnerResponse();
        response.setFirstName(owner.getFirstName());
        response.setLastName(owner.getLastName());
        response.setCars(owner.getCars().stream()
                .map(car -> new CarResponse(car.getBrand(), car.getModel()))
                .collect(Collectors.toList()));
        return response;
    }

    @Override
    public List<OwnerResponse> getAllOwners() {
        return null;
    }

    @Override
    public OwnerResponse addOwner(OwnerRequest request) {
        return null;
    }
}
