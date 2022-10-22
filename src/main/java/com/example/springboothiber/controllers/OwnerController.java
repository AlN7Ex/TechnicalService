package com.example.springboothiber.controllers;

import com.example.springboothiber.response.OwnerResponse;
import com.example.springboothiber.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping(value = "/api/v1/owner/{id}")
    public OwnerResponse getById(@PathVariable Long id) {
       return service.getOwner(id);
    }
}
