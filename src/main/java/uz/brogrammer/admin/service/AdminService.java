package uz.brogrammer.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammer.admin.model.Admin;
import uz.brogrammer.admin.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin create(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> admins(){
        return adminRepository.findAll();
    }

    public Optional<Admin> findById( Integer id){
        return adminRepository.findById(id);

    }


    public void removeAdmin(Integer id){
        adminRepository.deleteById(id);
    }
}
