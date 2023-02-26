package bankApiV1.Service;

import bankApiV1.Entity.Credit;
import bankApiV1.Entity.CreditScore;
import bankApiV1.Entity.Customer;
import bankApiV1.Repository.CreditScoreRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreService  {
    private final CreditScoreRepository creditScoreRepository;

    public CreditScoreService(CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }


    public Long creditScore(Long tckn){
        CreditScore temp = creditScoreRepository.findByTckn(tckn).orElseThrow();
        return temp.getCreditScore();
    }
}
