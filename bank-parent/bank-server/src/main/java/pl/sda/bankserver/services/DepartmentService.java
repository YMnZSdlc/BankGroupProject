package pl.sda.bankserver.services;

import pl.sda.bankcommons.domain.dtos.DepartmentRegistrationDto;
import pl.sda.bankserver.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    void createDepartment(DepartmentRegistrationDto registrationDto);

    List<Department> findAll();

    List<Department> findDepartment(Map<String, String> customQuery);

    void updateDepartment(Map<String, String> customQuery, DepartmentRegistrationDto registrationDto);

    void deleteDepartment(Map<String, String> customQuery);
}
