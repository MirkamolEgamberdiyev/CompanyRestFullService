package uz.fido.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.DepartmentDto;
import uz.fido.company.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @PostMapping("/addDepartment")
    public HttpEntity<ApiResponce> addDepartment(@RequestBody DepartmentDto departmentDto) {
        ApiResponce apiResponce = departmentService.addDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneDepartment/{id}")
    public HttpEntity<ApiResponce> getOneDepartment(@PathVariable Integer id) {
        ApiResponce oneDepartment = departmentService.getOneDepartment(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(oneDepartment);
    }

    @GetMapping("/getAllDepartment")
    public HttpEntity<ApiResponce> getAllDepartment() {
        ApiResponce allAddress = departmentService.getAllDepartment();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(allAddress);
    }

    @PutMapping("/updateDepartment/{id}")
    public HttpEntity<ApiResponce> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        ApiResponce apiResponce = departmentService.updateDepartment(id, departmentDto);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public HttpEntity<ApiResponce> deleteDepartment(@PathVariable Integer id){
        ApiResponce apiResponce = departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
