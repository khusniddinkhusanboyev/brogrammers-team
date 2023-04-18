package uz.brogrammer.registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.brogrammer.registration.model.Candidate;
import uz.brogrammer.registration.service.CandidateService;
import uz.brogrammer.registration.service.CourseService;

@Controller
@RequiredArgsConstructor
public class RegisterationController {
    private final CandidateService candidateService;
    private final CourseService courseService;

    @GetMapping("/")
    public String create(Model model){
        model.addAttribute("courses" , courseService.getAllCourses());
        model.addAttribute("registerCandidate" , new Candidate());
        return "index.html";
    }

    @PostMapping("/save-candidate")
    public String saveCandidate(@ModelAttribute("registerCandidate") Candidate candidate ){

        candidateService.create(candidate);

        return "redirect:/";
    }
}
