package uz.brogrammer.registration.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.geom.GeneralPath;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseTitle;
    private String days;
    private String time;
    @ManyToMany
    private Set<Candidate> candidates=new HashSet<>();




}