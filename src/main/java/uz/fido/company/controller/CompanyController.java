package uz.fido.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.CompanyDto;
import uz.fido.company.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("/addCompany")
    public HttpEntity<ApiResponce> addCompany(@RequestBody CompanyDto companyDto) {
        ApiResponce apiResponce = companyService.addCompany(companyDto);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneCompany/{id}")
    public HttpEntity<ApiResponce> getOneCompany(@PathVariable Integer id) {
        ApiResponce oneAddress = companyService.getOneCompany(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(oneAddress);
    }

    @GetMapping("/getAllCompany")
    public HttpEntity<ApiResponce> getAllCompany() {
        ApiResponce allAddress = companyService.getAllCompany();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(allAddress);
    }

    @PutMapping("/updateCompany/{id}")
    public HttpEntity<ApiResponce> updateCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto) {
        ApiResponce apiResponce = companyService.updateCompany(id, companyDto);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public HttpEntity<ApiResponce> deleteCompany(@PathVariable Integer id){
        ApiResponce apiResponce = companyService.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
