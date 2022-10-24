package com.example.springboothiber.services;

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
        //        response.setCars(owner.getCars().stream()
//                .map(car -> new CarResponse(car.getBrand(), car.getModel()))
//                .collect(Collectors.toList()));
        return new OwnerResponse(
                owner.getFirstName(),
                owner.getLastName()
        );
    }

    @Override
    public List<OwnerResponse> getAllOwners() {
        List<Owner> owners = repository.getOwners();
        return owners.stream()
                .map(owner -> new OwnerResponse(
                        owner.getFirstName(), owner.getLastName())
                )
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponse addOwner(OwnerRequest request) {
        Owner owner = new Owner();
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setAge(request.getAge());
        Owner saved = repository.save(owner);

        return new OwnerResponse(
                saved.getFirstName(), saved.getLastName()
        );
    }
}
