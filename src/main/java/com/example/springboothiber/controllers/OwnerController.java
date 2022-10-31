package com.example.springboothiber.controllers;

import com.example.springboothiber.model.request.OwnerRequest;
import com.example.springboothiber.model.response.OwnerResponse;
import com.example.springboothiber.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping(value = "/owners/{id}")
    public OwnerResponse getById(@PathVariable Long id) {
       return service.read(id);
    }

    @GetMapping(value = "/owners")
    public List<OwnerResponse> getOwners() {
        return service.readAll();
    }

    @PostMapping(value = "/owners")
    public OwnerResponse addOwner(@RequestBody OwnerRequest request) {
        return service.create(request);
    }

    @PutMapping(value = "/owners/{id}")
    public boolean updateOwner(@RequestBody OwnerRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }

    @DeleteMapping(value = "/owners/{id}")
    public boolean deleteOwner(@PathVariable Long id) {
        return service.delete(id);
    }
}
