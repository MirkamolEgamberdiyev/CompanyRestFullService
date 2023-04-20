package uz.fido.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.company.entity.Address;
import uz.fido.company.repository.AddressRepository;
import uz.fido.company.payload.ApiResponce;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public ApiResponce addAddress(Address address) {
        boolean existsByHomeNumber = addressRepository.existsByHomeNumber(address.getHomeNumber());
        if (existsByHomeNumber)
            return new ApiResponce("Bunday raqamli uy mavjud", false);
        Address save = addressRepository.save(address);
        return new ApiResponce("address qoshildi", true, save);
    }

    public ApiResponce getOneAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday address mavjud emas!", false);

        Address address = optionalAddress.get();
        return new ApiResponce("Addres topildi", true, address);
    }

    public ApiResponce getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return new ApiResponce("Addresslar topildi", true, addresses);
    }

    public ApiResponce updateAddress(Integer id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (!optionalAddress.isPresent())
            return new ApiResponce("Bunday addres mavjud emas!", false);
        Address address1 = optionalAddress.get();
        address1.setStreet(address.getStreet());
        address1.setHomeNumber(address.getHomeNumber());
        Address save = addressRepository.save(address1);
        return new ApiResponce("Address update qilindi", true, save);
    }

    public ApiResponce deleteAddress(Integer id) {
        addressRepository.deleteById(id);
        return new ApiResponce("address o'chirildi", true);
    }


}
