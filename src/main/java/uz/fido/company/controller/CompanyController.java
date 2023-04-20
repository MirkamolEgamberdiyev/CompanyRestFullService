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
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneCompany/{id}")
    public HttpEntity<ApiResponce> getOneCompany(@PathVariable Integer id) {
        ApiResponce apiResponce = companyService.getOneCompany(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllCompany")
    public HttpEntity<ApiResponce> getAllCompany() {
        ApiResponce apiResponce = companyService.getAllCompany();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateCompany/{id}")
    public HttpEntity<ApiResponce> updateCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto) {
        ApiResponce apiResponce = companyService.updateCompany(id, companyDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public HttpEntity<ApiResponce> deleteCompany(@PathVariable Integer id) {
        ApiResponce apiResponce = companyService.deleteCompany(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
