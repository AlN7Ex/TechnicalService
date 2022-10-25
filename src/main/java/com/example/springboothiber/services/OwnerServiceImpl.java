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
    public OwnerResponse read(Long id) {
        Owner owner = repository.getOwnerById(id);

        return new OwnerResponse(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getAge()
        );
    }

    @Override
    public List<OwnerResponse> readAll() {
        List<Owner> owners = repository.getOwners();
        return owners.stream()
                .map(owner -> new OwnerResponse(
                        owner.getId(),
                        owner.getFirstName(),
                        owner.getLastName(),
                        owner.getAge())
                )
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponse create(OwnerRequest request) {
        Owner owner = new Owner();
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setAge(request.getAge());
        Owner saved = repository.save(owner);

        return new OwnerResponse(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getAge()
        );
    }

    @Override
    public boolean update(OwnerRequest request, Long id) {
        Owner ownerById = repository.getOwnerById(id);

        if (ownerById != null) {
            ownerById.setFirstName(request.getFirstName());
            ownerById.setLastName(request.getLastName());
            ownerById.setAge(request.getAge());
            repository.save(ownerById);

            return true;
        } else {
            repository.save(new Owner(
                    request.getFirstName(),
                    request.getLastName(),
                    request.getAge()));
            return true;
        }
//        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }
        return false;
    }
}
