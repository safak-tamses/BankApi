package bankApiV1.Repository;

import bankApiV1.Entity.CreditScore;
import bankApiV1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {
    Optional<CreditScore> findByTckn(Long tckn);
}
