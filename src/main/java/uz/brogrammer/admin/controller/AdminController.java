package uz.brogrammer.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.brogrammer.admin.model.Admin;
import uz.brogrammer.admin.service.AdminService;
import uz.brogrammer.registration.model.Course;
import uz.brogrammer.registration.service.CandidateService;
import uz.brogrammer.registration.service.CourseService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final CandidateService candidateService;
    private final CourseService courseService;
    /*manage candidate list */

    @GetMapping
    public String candidates(Model model) {
        model.addAttribute("candidateList", candidateService.candidates());
        return "admin/admin-candidate-list.html";
    }

    /*add new Admin */
    @GetMapping("/new-admin")
    public String newAdmin(Model model) {

        model.addAttribute("newAdmin", new Admin());
        return "admin/admin-registration.html";
    }
    @PostMapping("/save-admin")
    public String saveAdmin(@ModelAttribute("newAdmin") Admin admin) {
        adminService.create(admin);

        return "redirect:/login";
    }

    @GetMapping("/remove-admin/{id}")
    public String removeAdmin(@PathVariable("id") Integer id){
        adminService.removeAdmin(id);
        return "redirect:/admin/new-admin";
    }



    @GetMapping("remove/{id}")
    public String removeCandidate(@PathVariable("id") Integer id) {
        candidateService.removeById(id);
        return "redirect:/admin";
    }

    /*control of courses*/
    @GetMapping("/new-course")
    public String addNewCourse(Model model) {
        model.addAttribute("newCourse", new Course());
        model.addAttribute("courseList", courseService.getAllCourses());
        return "admin/admin-courses-list.html";
    }

    @PostMapping("/save-course")
    public String saveNewCourse(@ModelAttribute("newCourse") Course course, Model model) {
        courseService.addCourse(course);
        return "redirect:/admin/new-course";
    }

    @GetMapping("/edit/{id}")
    public String updateCourse(@PathVariable("id") Integer id, Model model, RedirectAttributes message) {
        var optionalCourse = courseService.editCorse(id);
        if (optionalCourse.isPresent()) {
            model.addAttribute("oldCase", courseService.editCorse(id));
            model.addAttribute("courseList", courseService.getAllCourses());
            return "admin/admin-edit-existing-course.html";
        }
        message.addFlashAttribute("error", "this course is not available...");
        return "redirect:/admin/new-course";
    }

    @PostMapping("/updated")
    public String updated(@ModelAttribute("oldCase") Course course) {
        courseService.addCourse(course);
        return "redirect:/admin/new-course";
    }

    @GetMapping("remove-course/{id}")
    public String removeCourse(@PathVariable("id") Integer id) {
        courseService.removeById(id);
        return "redirect:/admin/new-course";
        }



}
