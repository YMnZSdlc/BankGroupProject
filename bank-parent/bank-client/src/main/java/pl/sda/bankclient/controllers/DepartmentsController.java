package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.DepartmentRegistrationDto;

@Controller
public class DepartmentsController {
    
    @GetMapping("/departments")
    public String showDepartments(){
        return "departments";
    }

    @GetMapping("/departments/save")
    public String viewFormToCreateDepartment(Model model){
        model.addAttribute("save",new DepartmentRegistrationDto());
        return "departments/save";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(@ModelAttribute DepartmentRegistrationDto departmentRegistrationDto){
        return "departments/save";
    }

    @GetMapping("/departments/find")
    public String viewFormToFindDepartment(Model model){
        model.addAttribute("find",new DepartmentRegistrationDto());
        return "departments/find";
    }

    @PostMapping("/departments/find")
    public String findDepartment(@ModelAttribute DepartmentRegistrationDto departmentRegistrationDto){
        return "departments/find";
    }

    @GetMapping("/departments/findall")
    public String findAllDepartmentsByParam(Model model){
        model.addAttribute("findall",new DepartmentRegistrationDto());
        return "departments/findall";
    }

    @PostMapping("/departments/findall")
    public String findAllDepartments(@ModelAttribute DepartmentRegistrationDto departmentRegistrationDto){
        return "departments/findall";
    }

    @GetMapping("/departments/update")
    public String chooseDepartmentsForUpdate(Model model){
        model.addAttribute("update", new DepartmentRegistrationDto());
        return "departments/update";
    }

    @PutMapping("/departments/update")
    public String updateDepartment(@ModelAttribute DepartmentRegistrationDto departmentRegistrationDto){
        return "departments/update";
    }
    
    @GetMapping("departments/delete")
    public String findDepartmentsToDelete(Model model){
        model.addAttribute("delete", new DepartmentRegistrationDto());
        return "departments/delete";
    }

    @DeleteMapping("departments/delete")
    public String deleteDepartment(@ModelAttribute DepartmentRegistrationDto departmentRegistrationDto){
        return "departments/delete";
    }

}
