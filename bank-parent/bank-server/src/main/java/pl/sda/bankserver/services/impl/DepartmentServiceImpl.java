package pl.sda.bankserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bankcommons.domain.dtos.DepartmentRegistrationDto;
import pl.sda.bankserver.domain.Department;
import pl.sda.bankserver.repository.DepartmentRepository;
import pl.sda.bankserver.services.DepartmentService;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void createDepartment(DepartmentRegistrationDto registrationDto) {
        Department department = Department.builder()
                .deptName(registrationDto.getDeptName())
                .deptNo(registrationDto.getDeptNo())
                .phoneNumber(registrationDto.getPhoneNumber())
                .build();
        departmentRepository.saveAndFlush(department);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> findDepartment(Map<String, String> customQuery) {
        String deptName = customQuery.get("deptName");
        String deptNo = customQuery.get("deptNo");
        String phoneNumber = customQuery.get("phoneNumber");
        return departmentRepository.findByDeptNameOrDeptNoOrPhoneNumber(deptName, parseInt(deptNo), phoneNumber);
    }

    @Override
    public void updateDepartment(Map<String, String> customQuery, DepartmentRegistrationDto registrationDto) {
        Department department = findDepartment(customQuery).get(0);
        department = Department.builder()
                .deptName(registrationDto.getDeptName())
                .deptNo(registrationDto.getDeptNo())
                .phoneNumber(registrationDto.getPhoneNumber())
                .build();
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Map<String, String> customQuery) {
        Department department = findDepartment(customQuery).get(0);
        departmentRepository.delete(department);
    }
}
