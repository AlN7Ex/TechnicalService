//package com.example.springboothiber.services.delete;
//
//import com.example.springboothiber.model.response.OwnerResponse;
//import com.example.springboothiber.model.entity.Owner;
//import com.example.springboothiber.repositories.OwnerRepository;
//import com.example.springboothiber.model.request.OwnerRequest;
//import com.example.springboothiber.services.delete.OwnerService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class OwnerServiceImpl implements OwnerService {
//
//    private final OwnerRepository repository;
//
//    @Override
//    public OwnerResponse read(Long id) {
//        Owner owner = repository.getOwnerById(id);
//
//        return new OwnerResponse(
//                owner.getId(),
//                owner.getFirstname(),
//                owner.getLastname(),
//                owner.getAge()
//        );
//    }
//
//    @Override
//    public List<OwnerResponse> readAll() {
//        List<Owner> owners = repository.getOwners();
//        return owners.stream()
//                .map(owner -> new OwnerResponse(
//                        owner.getId(),
//                        owner.getFirstname(),
//                        owner.getLastname(),
//                        owner.getAge())
//                )
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public OwnerResponse create(OwnerRequest request) {
//        Owner owner = new Owner();
//        owner.setFirstname(request.getFirstName());
//        owner.setLastname(request.getLastName());
//        owner.setAge(request.getAge());
//        Owner saved = repository.save(owner);
//
//        return new OwnerResponse(
//                saved.getId(),
//                saved.getFirstname(),
//                saved.getLastname(),
//                saved.getAge()
//        );
//    }
//
//    @Override
//    public boolean update(OwnerRequest request, Long id) {
//        Owner ownerById = repository.getOwnerById(id);
//
//        if (ownerById != null) {
//            ownerById.setFirstname(request.getFirstName());
//            ownerById.setLastname(request.getLastName());
//            ownerById.setAge(request.getAge());
//            repository.save(ownerById);
//
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        if (repository.existsById(id)) {
//            repository.deleteById(id);
//
//            return true;
//        }
//        return false;
//    }
//}
