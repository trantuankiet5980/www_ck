package vn.edu.iuh.fit.fronend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.fronend.models.CandidateModel;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateModel candidateModel;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("candidates", candidateModel.findAll());
        return "candidates";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable("id") Long id){
        model.addAttribute("candidate", candidateModel.findById(id));
        return "candidate-detail";
    }
    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        candidateModel.deleteById(id);
        return "redirect:/candidates";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("candidate", new Candidate());
        return "addCandidate";
    }
    //add candidate
    @PostMapping("/add")
    public String add(Model model, Candidate candidate){
        candidateModel.save(candidate);
        return "redirect:/candidates";
    }
}
