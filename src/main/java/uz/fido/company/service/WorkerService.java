package uz.fido.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.company.entity.Address;
import uz.fido.company.entity.Department;
import uz.fido.company.entity.Worker;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.WorkerDto;
import uz.fido.company.repository.AddressRepository;
import uz.fido.company.repository.DepartmentRepository;
import uz.fido.company.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public ApiResponce addWorker(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());

        Optional<Address> optionalAddress = addressRepository.findById(workerDto.getAddress_id());
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday address topildmadi", false);
        Address address = optionalAddress.get();
        worker.setAddress(address);

        Optional<Department> optionalDepartment = departmentRepository.findById(workerDto.getDepartment_id());
        if (!optionalDepartment.isPresent())
            return new ApiResponce("Bunday department mavjud emas", false);

        Department department = optionalDepartment.get();
        worker.setDepartment(department);

        Worker save = workerRepository.save(worker);
        return new ApiResponce("worker qoshildi", true, save);
    }


    public ApiResponce getOneWorker(Integer id) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (!optionalWorker.isPresent())
            return new ApiResponce("Bunday worker mavjud emas", false);

        Worker worker = optionalWorker.get();

        return new ApiResponce("worker topildi", true, worker);

    }

    public ApiResponce getAllWorker() {
        List<Worker> workers = workerRepository.findAll();
        return new ApiResponce("worker topildi", true, workers);

    }

    public ApiResponce updateWorker(Integer id, WorkerDto workerDto) {
        Optional<Worker> optionalWorker = workerRepository.findById(id);
        if (!optionalWorker.isPresent())
            return new ApiResponce("Bunday worker mavjud emas", false);

        Worker worker = optionalWorker.get();
        worker.setName(workerDto.getName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());

        Optional<Address> optionalAddress = addressRepository.findById(workerDto.getAddress_id());
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday address topildmadi", false);
        Address address = optionalAddress.get();
        worker.setAddress(address);

        Optional<Department> optionalDepartment = departmentRepository.findById(workerDto.getDepartment_id());
        if (!optionalDepartment.isPresent())
            return new ApiResponce("Bunday department mavjud emas", false);

        Department department = optionalDepartment.get();
        worker.setDepartment(department);

        Worker save = workerRepository.save(worker);
        return new ApiResponce("worker qoshildi", true, save);

    }

    public ApiResponce deleteWorker(Integer id){
        workerRepository.deleteById(id);
        return new ApiResponce("deleted worker", true);
    }

}
