package uz.fido.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.company.entity.Address;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/addAddress")
    public HttpEntity<ApiResponce> addAddress(@RequestBody Address address) {
        ApiResponce apiResponce = addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneAddress/{id}")
    public HttpEntity<ApiResponce> getOneAddress(@PathVariable Integer id) {
        ApiResponce oneAddress = addressService.getOneAddress(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(oneAddress);
    }

    @GetMapping("/getAllAddress")
    public HttpEntity<ApiResponce> getAllAddress() {
        ApiResponce allAddress = addressService.getAllAddress();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(allAddress);
    }

    @PutMapping("/updateAddress/{id}")
    public HttpEntity<ApiResponce> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        ApiResponce apiResponce = addressService.updateAddress(id, address);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public HttpEntity<ApiResponce> deleteAddress(@PathVariable Integer id){
        ApiResponce apiResponce = addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }



}
