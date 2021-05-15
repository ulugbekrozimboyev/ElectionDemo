package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.CandidateDto;

import java.util.List;
import java.util.Optional;

public interface CandidateDao {
    public List<CandidateDto> findAll();
    public Optional<CandidateDto> findById(Long id);
    public void save(CandidateDto candidateDto);
    public void delete(Long id);
}