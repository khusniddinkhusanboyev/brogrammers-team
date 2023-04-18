package uz.brogrammer.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammer.registration.model.Course;
import uz.brogrammer.registration.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> editCorse(Integer id){
        return courseRepository.findById(id);
    }
    public void removeById(Integer id){
        courseRepository.deleteById(id);
    }
}
