package com.example.springboothiber.controllers;

import com.example.springboothiber.request.OwnerRequest;
import com.example.springboothiber.response.OwnerResponse;
import com.example.springboothiber.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping(value = "/api/v1/owner/{id}")
    public OwnerResponse getById(@PathVariable Long id) {
       return service.read(id);
    }

    @GetMapping(value = "/api/v1/owner")
    public List<OwnerResponse> getOwners() {
        return service.readAll();
    }

    @PostMapping(value = "/api/v1/owner")
    public OwnerResponse addOwner(@RequestBody OwnerRequest request) {
        return service.create(request);
    }

    @PutMapping(value = "/api/v1/owner/{id}")
    public boolean updateOwner(@RequestBody OwnerRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }

    @DeleteMapping(value = "/api/v1/owner/{id}")
    public boolean deleteOwner(@PathVariable Long id) {
        return service.delete(id);
    }
}
