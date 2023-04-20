package uz.fido.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.company.entity.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Integer> {
    boolean existsByCorpName(String corpName);
}
