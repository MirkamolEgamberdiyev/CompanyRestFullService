package uz.fido.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.fido.company.entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {
}
