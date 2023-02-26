package bankApiV1.Service;

import bankApiV1.Entity.Credit;
import bankApiV1.Repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService {
    private final CustomerService customerService;
    private final CreditScoreService creditScoreService;

    private final CreditRepository creditRepository;

    public CreditService(CustomerService customerService, CreditScoreService creditScoreService, CreditRepository creditRepository) {
        this.customerService = customerService;
        this.creditScoreService = creditScoreService;
        this.creditRepository = creditRepository;
    }

    public void yazdir(Long tckn) {
        System.out.println(customerService.monthlyIncome(tckn));
        System.out.println(customerService.guarantee(tckn));
        System.out.println(creditScoreService.creditScore(tckn));
    }

    public Credit loanApplicationRequest(Long tckn) {
        Credit credit = new Credit();
        if (creditScoreService.creditScore(tckn) < 500) {
            //Red
            credit.setTckn(tckn);
            credit.setBirthDate(customerService.birthDay(tckn));
            credit.setCreateDate(LocalDate.now());
            credit.setResult(false);
            credit.setLoanAmount(0);

            creditRepository.save(credit);
            return credit;

        } else if (creditScoreService.creditScore(tckn) >= 500 && creditScoreService.creditScore(tckn) < 1000) {
            if (customerService.monthlyIncome(tckn) < 5000) {
                credit.setTckn(tckn);
                credit.setBirthDate(customerService.birthDay(tckn));
                credit.setCreateDate(LocalDate.now());
                credit.setResult(true);
                credit.setLoanAmount((long) (10000 + (customerService.guarantee(tckn) * 0.1)));

                creditRepository.save(credit);
                return credit;
            } else if (customerService.monthlyIncome(tckn) >= 5000 && customerService.monthlyIncome(tckn) < 10000) {
                credit.setTckn(tckn);
                credit.setBirthDate(customerService.birthDay(tckn));
                credit.setCreateDate(LocalDate.now());
                credit.setResult(true);
                credit.setLoanAmount((long) (20000 + (customerService.guarantee(tckn) * 0.2)));

                creditRepository.save(credit);
                return credit;
            } else if (customerService.monthlyIncome(tckn) >= 10000) {
                credit.setTckn(tckn);
                credit.setBirthDate(customerService.birthDay(tckn));
                credit.setCreateDate(LocalDate.now());
                credit.setResult(true);
                credit.setLoanAmount((long) ((customerService.monthlyIncome(tckn) * 2) + (customerService.guarantee(tckn) * 0.25)));

                creditRepository.save(credit);
                return credit;
            }

        } else if (creditScoreService.creditScore(tckn) >= 1000) {
            credit.setTckn(tckn);
            credit.setBirthDate(customerService.birthDay(tckn));
            credit.setCreateDate(LocalDate.now());
            credit.setResult(true);
            credit.setLoanAmount((long) ((customerService.monthlyIncome(tckn) * 4) + (customerService.guarantee(tckn) * 0.5)));

            creditRepository.save(credit);
            return credit;
        }
        {

        }

        return credit;
    }


    public List<Optional<Credit>> loanApplicationResults(Long tckn, LocalDate birthDate) {
        //tckn check
        List<Optional<Credit>> temp =  creditRepository.findAllByTckn(tckn);
        Optional<Credit> test= temp.get(0);
        if(test.isEmpty()){
            //Kredi başvurusu yok
            System.out.println("boş");
            return null;
        }
        else if(test.get().getBirthDate().isEqual(birthDate)){
            return temp;
        }
        else{
            //birthdate yanlış
            System.out.println("yanlış doğum tarihi");
            return null;
        }



    }

}
