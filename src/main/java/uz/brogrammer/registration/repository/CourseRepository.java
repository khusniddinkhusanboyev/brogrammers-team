package uz.brogrammer.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.brogrammer.registration.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}