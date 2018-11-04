package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByDeptNameOrDeptNoOrPhoneNumber(String deptName, Integer deptNo, String phoneNumber);
}
