package vn.edu.iuh.fit.fronend.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.fronend.models.CandidateModel;

import java.util.List;

@Component
public class CandidateModelImpl implements CandidateModel {
    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/candidates";

    @Override
    public List<Candidate> findAll() {
        return restTemplate.getForObject(URL, List.class);
    }

    @Override
    public Candidate findById(Long id) {
        return restTemplate.getForObject(URL + "/" + id, Candidate.class);
    }

    @Override
    public List<Candidate> findByYearExperience(int year) {
        return restTemplate.getForObject(URL + "/findByYearExperience?year=" + year, List.class);
    }

    @Override
    public List<Candidate> findByFullName(String fullName) {
        return restTemplate.getForObject(URL + "/findByFullName?fullName=" + fullName, List.class);
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.getForObject(URL + "/delete/" + id, Void.class);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return restTemplate.postForObject(URL, candidate, Candidate.class);
    }

}
