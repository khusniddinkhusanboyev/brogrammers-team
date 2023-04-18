package uz.brogrammer.registration.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@Table(name = "candidates")
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "course_id" , referencedColumnName = "id" , nullable = false)
    @ManyToMany
    private Set<Course> course_id=new HashSet<>();
    private String name;
    private String lastName;
    private String phoneNumber;
    @Column(name = "registrated_at" , nullable = false , length = 200)
    private String localDateTime;


}
