package uz.brogrammer.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammer.registration.model.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
