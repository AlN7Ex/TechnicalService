package com.example.springboothiber.services;

import com.example.springboothiber.response.OwnerResponse;
import com.example.springboothiber.request.OwnerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    OwnerResponse getOwner(Long id);
    List<OwnerResponse> getAllOwners();
    OwnerResponse addOwner(OwnerRequest request);
}
