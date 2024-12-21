package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.entities.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> findAll();
    Candidate findById(Long id);
    List<Candidate> findByYearExperience(int year);
    List<Candidate> findByFullName(String fullName);
    void deleteById(Long id);
    Candidate save(Candidate candidate);
}
