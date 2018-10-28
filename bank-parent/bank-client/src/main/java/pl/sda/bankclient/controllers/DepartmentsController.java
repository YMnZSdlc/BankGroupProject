package pl.sda.bankclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.bankcommons.domain.dtos.DepartamentRegistrationDto;

@Controller
public class DepartmentsController {


    @GetMapping("/departments")
    public String showDepartments(){

        return "departments";
    }

    @GetMapping("/departments/save")
    public String viewFormToCreateDepartment(Model model){
        model.addAttribute("save",new DepartamentRegistrationDto());
        return "departments/save";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(@ModelAttribute DepartamentRegistrationDto departamentRegistrationDto){
        return "departments/save";
    }

    @GetMapping("/departments/find")
    private String vievFormToFindDepartment(Model model){
        model.addAttribute("find",new DepartamentRegistrationDto());
        return "departments/find";
    }

    @PostMapping("/departments/find")
    private String findDepartment(@ModelAttribute DepartamentRegistrationDto departamentRegistrationDto){
        return "departments/find";
    }

    @GetMapping("/departments/findall")
    private String findAllDepartmentsByParam(Model model){
        model.addAttribute("findall",new DepartamentRegistrationDto());
        return "departments/findall";
    }

    @PostMapping("/departments/findall")
    private String findAllDepartments(@ModelAttribute DepartamentRegistrationDto departamentRegistrationDto){
        return "departments/findall";
    }

    @GetMapping("/departments/update")
    public String chooseDepartmentsForUpdate(Model model){

        model.addAttribute("update", new DepartamentRegistrationDto());

        return "departments/update";
    }

    @PutMapping("/departments/update")
    public String updateDepartment(@ModelAttribute DepartamentRegistrationDto departamentRegistrationDto){
        return "departments/update";
    }


    @GetMapping("departments/delete")
    public String findDepartmentsToDelete(Model model){

        model.addAttribute("delete", new DepartamentRegistrationDto());

        return "departments/delete";
    }

    @DeleteMapping("departments/delete")
    public String deleteDepartment(@ModelAttribute DepartamentRegistrationDto departamentRegistrationDto){
        return "departments/delete";
    }

}
