package uz.brogrammer.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammer.admin.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
