package com.example.springboothiber.services;

import com.example.springboothiber.response.OwnerResponse;
import com.example.springboothiber.request.OwnerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    OwnerResponse read(Long id);
    List<OwnerResponse> readAll();
    OwnerResponse create(OwnerRequest request);
    boolean update(OwnerRequest request, Long id);
    boolean delete(Long id);
}
