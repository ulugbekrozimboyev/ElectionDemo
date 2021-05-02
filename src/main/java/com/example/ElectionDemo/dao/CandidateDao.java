package com.example.ElectionDemo.dao;

import com.example.ElectionDemo.dto.CandidateDto;

import java.util.*;

public class CandidateDao {

    private static ArrayList<CandidateDto> candidateDtos = new ArrayList<>(Arrays.asList(
            new CandidateDto(1L, "Candidate 1", "chairman at OFB", "about candidate 1", getMap()),
            new CandidateDto(2L, "Candidate 2", "director at 42 school", "about candidate 2", getMap()),
            new CandidateDto(3L, "Candidate 3", "driver at Bank", "about candidate 3", getMap())
    ));

    public static void save(CandidateDto candidateDto) {
        candidateDto.setId((long) (candidateDtos.size() + 1));
        candidateDtos.add(candidateDto);
    }

    public Optional<CandidateDto> findById(Long id) {
        return Optional.empty();
    }

    public static List<CandidateDto> findAll() {
        HashMap<String, String> info = new HashMap<>();
        info.put("age", "21");
        info.put("phone", "12345");
        return candidateDtos;
    }

    public static CandidateDto update(CandidateDto candidateDto) {
        return candidateDto;
    }

    public static void delete(Long id) {
        candidateDtos.removeIf(candidateDto -> candidateDto.getId().equals(id));
    }

    private static HashMap<String, String> getMap() {
        HashMap<String, String> info = new HashMap<>();
        info.put("age", "21");
        info.put("phone", "12345");
        return info;
    }
}
