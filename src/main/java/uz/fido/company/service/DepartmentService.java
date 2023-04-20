package uz.fido.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.company.entity.Company;
import uz.fido.company.entity.Department;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.DepartmentDto;
import uz.fido.company.repository.CompanyRepository;
import uz.fido.company.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    CompanyRepository companyRepository;


    public ApiResponce addDepartment(DepartmentDto departmentDto) {
        boolean existsByName = departmentRepository.existsByName(departmentDto.getName());
        if (existsByName)
            return new ApiResponce("Bunday department mavjud", false);

        Department department = new Department();
        department.setName(departmentDto.getName());

        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompany_id());
        if (!optionalCompany.isPresent())
            return new ApiResponce("Bunday company mavjud emas", false);

        Company company = optionalCompany.get();
        department.setCompany(company);
        Department save = departmentRepository.save(department);
        return new ApiResponce("Department qoshildi", true, save);
    }

    public ApiResponce getOneDepartment(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new ApiResponce("Bunday department mavjud emas", false);

        Department department = optionalDepartment.get();
        return new ApiResponce("department topildi", true, department);
    }

    public ApiResponce getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return new ApiResponce("Departmentlar topildi" , true, departments);
    }

    public ApiResponce updateDepartment(Integer id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (!optionalDepartment.isPresent())
            return new ApiResponce("Bunday department topilmadi", false);

        Department department = optionalDepartment.get();

        department.setName(departmentDto.getName());

        Optional<Company> optionalCompany = companyRepository.findById(departmentDto.getCompany_id());
        if (!optionalCompany.isPresent())
            return new ApiResponce("Bunday company mavjud emas", false);

        Company company = optionalCompany.get();
        department.setCompany(company);
        Department save = departmentRepository.save(department);
        return new ApiResponce("Department qoshildi", true, save);
    }

    public ApiResponce deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
        return new ApiResponce("department o'chirildi", true);
    }
}
