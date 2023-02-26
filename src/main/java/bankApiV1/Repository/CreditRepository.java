package bankApiV1.Repository;

import bankApiV1.Entity.Credit;
import bankApiV1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
    Optional<Credit> findByTckn(Long tckn);


    List<Optional<Credit>> findAllByTckn(Long tckn);
}
