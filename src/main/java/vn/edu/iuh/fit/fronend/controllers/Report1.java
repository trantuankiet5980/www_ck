package vn.edu.iuh.fit.fronend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.fronend.models.CandidateModel;

@Controller
@RequestMapping("/report01s")
public class Report1 {
    @Autowired
    private CandidateModel candidateModel;
    @GetMapping
    public String findByYearExperience(Model model){
        model.addAttribute("candidates", candidateModel.findByYearExperience(5));
        return "report1";
    }
}
