package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.DepartmentRegistrationDto;
import pl.sda.bankserver.domain.Department;
import pl.sda.bankserver.services.DepartmentService;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    private DepartmentService departmentService;
    
    @Autowired
    public DepartmentServiceImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @Override
    public void createDepartment(DepartmentRegistrationDto registrationDto) {
    
    }
    
    @Override
    public List<Department> findAll() {
        return null;
    }
    
    @Override
    public List<Department> findDepartment(Map<String, String> customQuery) {
        return null;
    }
    
    @Override
    public void updateDepartment(Map<String, String> customQuery, DepartmentRegistrationDto registrationDto) {
    
    }
    
    @Override
    public void deleteDepartment(Map<String, String> customQuery) {
    
    }
}
