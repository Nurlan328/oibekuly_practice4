package kz.nurlan.oibekuly.repository;
import kz.nurlan.oibekuly.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
