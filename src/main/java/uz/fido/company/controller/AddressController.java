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
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneAddress/{id}")
    public HttpEntity<ApiResponce> getOneAddress(@PathVariable Integer id) {
        ApiResponce oneAddress = addressService.getOneAddress(id);
        if (oneAddress.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(oneAddress);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(oneAddress);
    }

    @GetMapping("/getAllAddress")
    public HttpEntity<ApiResponce> getAllAddress() {
        ApiResponce allAddress = addressService.getAllAddress();
        if (allAddress.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(allAddress);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(allAddress);
    }

    @PutMapping("/updateAddress/{id}")
    public HttpEntity<ApiResponce> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        ApiResponce apiResponce = addressService.updateAddress(id, address);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public HttpEntity<ApiResponce> deleteAddress(@PathVariable Integer id) {
        ApiResponce apiResponce = addressService.deleteAddress(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }


}
