package vn.edu.iuh.fit.fronend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.fronend.models.CandidateModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/report02s")
public class Report2 {
    @Autowired
    private CandidateModel candidateModel;

    @GetMapping
    public String getCandidateByCompanyNameExperience(Model model, @RequestParam(value = "compName", required = false, defaultValue = "") String fullName){
        List<Candidate> candidateList = new ArrayList<>();
        if(fullName.isBlank()){
            candidateList = candidateModel.findAll();
        } else {
            candidateList = candidateModel.findByFullName(fullName);
        }
        model.addAttribute("candidates", candidateList);
        model.addAttribute("fullName", fullName);
        return "report2";
    }
}
