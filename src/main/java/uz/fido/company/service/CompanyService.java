package uz.fido.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.company.entity.Address;
import uz.fido.company.entity.Company;
import uz.fido.company.payload.ApiResponce;
import uz.fido.company.payload.CompanyDto;
import uz.fido.company.repository.AddressRepository;
import uz.fido.company.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    AddressRepository addressRepository;


    public ApiResponce addCompany(CompanyDto companyDto) {
        boolean existsByCorpName = companyRepository.existsByCorpName(companyDto.getCorpName());
        if (existsByCorpName)
            return new ApiResponce("Bunday nomli company bor", false);
        Company company = new Company();
        company.setDirectorName(company.getDirectorName());
        company.setCorpName(company.getCorpName());

        Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddress_id());
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday address topildmadi", false);
        Address address = optionalAddress.get();
        company.setAddress(address);
        Company save = companyRepository.save(company);
        return new ApiResponce("Company qoshildi", true, save);
    }

    public ApiResponce getOneCompany(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent())
            return new ApiResponce("Buday Company topilmadi", false);
        Company company = optionalCompany.get();

        return new ApiResponce("Company topildi", true, company);
    }

    public ApiResponce getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return new ApiResponce("Companiyalar ro'yxati", true, companies);
    }

    public ApiResponce updateCompany(Integer id, CompanyDto companyDto) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (!optionalCompany.isPresent())
            return new ApiResponce("Buday Company topilmadi", false);

        Company company = optionalCompany.get();
        company.setDirectorName(company.getDirectorName());
        company.setCorpName(company.getCorpName());

        Optional<Address> optionalAddress = addressRepository.findById(companyDto.getAddress_id());
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday address topildmadi", false);
        Address address = optionalAddress.get();
        company.setAddress(address);
        Company save = companyRepository.save(company);
        return new ApiResponce("Company qoshildi", true, save);

    }


    public ApiResponce deleteCompany(Integer id) {
        companyRepository.deleteById(id);
        return new ApiResponce("company o'chirildi", true);
    }
}
