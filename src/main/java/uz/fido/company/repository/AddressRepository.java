package uz.fido.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.company.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    boolean existsByHomeNumber(Integer homeNumber);
}
