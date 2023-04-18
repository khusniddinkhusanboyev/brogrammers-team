package uz.brogrammer.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammer.registration.model.Candidate;
import uz.brogrammer.registration.repository.CandidateRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public Candidate create(Candidate candidate){
        candidate.setLocalDateTime(LocalDateTime.now().toString());
        return candidateRepository.save(candidate);
    }
    public List<Candidate> candidates()
    {
        return candidateRepository.findAll();


    }
    public void removeById(Integer id){
        candidateRepository.deleteById(id);
    }
    public void removeAll(){
        candidateRepository.deleteAll();
    }
}


