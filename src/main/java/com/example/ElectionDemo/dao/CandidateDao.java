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
        candidateDto.setId((candidateDtos.get(candidateDtos.size() - 1).getId() + 1));
        candidateDtos.add(candidateDto);
    }

    public static Optional<CandidateDto> findById(Long id) {
        for (CandidateDto candidateDto : candidateDtos) {
            if(Objects.equals(candidateDto.getId(), id)) {
                return Optional.of(candidateDto);
            }
        }
        return Optional.empty();
    }
    public static Optional<CandidateDto> findByFullName(String username) {
        for (CandidateDto candidateDto : candidateDtos) {
            if(Objects.equals(candidateDto.getFullName(), username)) {
                return Optional.of(candidateDto);
            }
        }
        return Optional.empty();
    }

    public static List<CandidateDto> findAll() {
        return candidateDtos;
    }

    public static boolean existCandidate(String username) {
        return candidateDtos.stream().anyMatch(candidateDto -> candidateDto.getFullName().equals(username));
    }

    public static void update(CandidateDto candidateDto) {
        for (int i = 0; i < candidateDtos.size(); i++) {
            if(Objects.equals(candidateDto.getId(), candidateDtos.get(i).getId())) {
                candidateDtos.set(i, candidateDto);
                return;
            }
        }
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
