package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.entities.Roles;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateService;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findById(Long id) {
        Optional<Candidate> otp = candidateRepository.findById(id);
        return otp.orElse(null);    }

    @Override
    public List<Candidate> findByYearExperience(int year) {
        return candidateRepository.findByYearExperience(year);
    }

    @Override
    public List<Candidate> findByFullName(String fullName) {
        return candidateRepository.findByExperienceWithCompanyAndRole(fullName, Roles.ADMIN);
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

}
