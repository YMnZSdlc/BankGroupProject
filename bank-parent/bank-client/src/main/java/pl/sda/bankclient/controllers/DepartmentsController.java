package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.DepartmentDto;

@Controller
public class DepartmentsController {
    
    @GetMapping("/departments")
    public String showDepartments(){
        return "departments";
    }

    @GetMapping("/departments/save")
    public String viewFormToCreateDepartment(Model model){
        model.addAttribute("save",new DepartmentDto());
        return "departments/save";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(@ModelAttribute DepartmentDto departmentDto){
        return "departments/save";
    }

    @GetMapping("/departments/find")
    public String viewFormToFindDepartment(Model model){
        model.addAttribute("find",new DepartmentDto());
        return "departments/find";
    }

    @PostMapping("/departments/find")
    public String findDepartment(@ModelAttribute DepartmentDto departmentDto){
        return "departments/find";
    }

    @GetMapping("/departments/findall")
    public String findAllDepartmentsByParam(Model model){
        model.addAttribute("findall",new DepartmentDto());
        return "departments/findall";
    }

    @PostMapping("/departments/findall")
    public String findAllDepartments(@ModelAttribute DepartmentDto departmentDto){
        return "departments/findall";
    }

    @GetMapping("/departments/update")
    public String chooseDepartmentsForUpdate(Model model){
        model.addAttribute("update", new DepartmentDto());
        return "departments/update";
    }

    @PutMapping("/departments/update")
    public String updateDepartment(@ModelAttribute DepartmentDto departmentDto){
        return "departments/update";
    }
    
    @GetMapping("departments/delete")
    public String findDepartmentsToDelete(Model model){
        model.addAttribute("delete", new DepartmentDto());
        return "departments/delete";
    }

    @DeleteMapping("departments/delete")
    public String deleteDepartment(@ModelAttribute DepartmentDto departmentDto){
        return "departments/delete";
    }

}
