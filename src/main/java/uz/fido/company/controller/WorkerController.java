package uz.fido.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.WorkerDto;
import uz.fido.company.service.WorkerService;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;


    @PostMapping("/addWorker")
    public HttpEntity<ApiResponce> addWorker(@RequestBody WorkerDto workerDto) {
        ApiResponce apiResponce = workerService.addWorker(workerDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getOneWorker/{id}")
    public HttpEntity<ApiResponce> getOneWorker(@PathVariable Integer id) {
        ApiResponce apiResponce = workerService.getOneWorker(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @GetMapping("/getAllWorker")
    public HttpEntity<ApiResponce> getAllWorker() {
        ApiResponce apiResponce = workerService.getAllWorker();
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @PutMapping("/updateWorker/{id}")
    public HttpEntity<ApiResponce> updateWorker(@PathVariable Integer id, @RequestBody WorkerDto workerDto) {
        ApiResponce apiResponce = workerService.updateWorker(id, workerDto);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }

    @DeleteMapping("/deleteWorker/{id}")
    public HttpEntity<ApiResponce> deleteWorker(@PathVariable Integer id) {
        ApiResponce apiResponce = workerService.deleteWorker(id);
        if (apiResponce.isSuccess())
            return ResponseEntity.status(HttpStatus.OK).body(apiResponce);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponce);
    }
}
