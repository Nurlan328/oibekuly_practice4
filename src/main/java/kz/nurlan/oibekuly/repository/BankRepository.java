 package kz.nurlan.oibekuly.repository;

 import kz.nurlan.oibekuly.model.Bank;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 @Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
