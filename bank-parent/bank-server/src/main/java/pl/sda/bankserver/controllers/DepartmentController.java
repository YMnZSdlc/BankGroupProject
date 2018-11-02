package pl.sda.bankserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.DepartmentRegistrationDto;
import pl.sda.bankserver.domain.Department;

import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    
//    private DepartmentService departmentService;
//
//    @Autowired
//    public DepartmentController(DepartmentService departmentService) {
//        this.departmentService = departmentService;
//    }
    
    @PostMapping("/server/department/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDepartment(@RequestBody DepartmentRegistrationDto registrationDto) {
//        departmentService.createDepartment(registrationDto);
    }
    
    @GetMapping("/server/department/all")
    public List<Department> findAll() {
        return null;
    }
    
    @GetMapping("/server/department/find")
    public Department findDepartment(@RequestParam Map<String, String> customQuery) {
        return null;
    }
    
    @PutMapping("/server/department/update")
    public void updateDepartment(@RequestParam Map<String, String> customQuery, @RequestBody DepartmentRegistrationDto registrationDto) {
//        departmentService.updateDepartment(customQuery, registrationDto);
    }
    
    @DeleteMapping("/server/department/delete")
    public void deleteDepartment(@RequestParam Map<String, String> customQuery) {
//        DepartmentService.deleteDepartment(customQuery);
    }
}
