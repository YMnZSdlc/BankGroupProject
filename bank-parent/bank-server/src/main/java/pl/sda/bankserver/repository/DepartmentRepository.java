package pl.sda.bankserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.bankserver.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
