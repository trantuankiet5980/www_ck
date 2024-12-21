package vn.edu.iuh.fit.backend.resources;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.services.CandidateService;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateResource {
    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<Candidate>> findAll(){
        return ResponseEntity.ok(candidateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(candidateService.findById(id));
    }

    @GetMapping("/findByYearExperience")
    public ResponseEntity<List<Candidate>> getByYearExperience(@RequestParam("year") int year){
        return ResponseEntity.ok(candidateService.findByYearExperience(year));
    }

    @GetMapping("/findByFullName")
    public ResponseEntity<List<Candidate>> getByFullName(@RequestParam("fullName") String fullName){
        return ResponseEntity.ok(candidateService.findByFullName(fullName));
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        candidateService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<Candidate> save(@RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.save(candidate));
    }
}
