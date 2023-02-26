package bankApiV1.Controller;

import bankApiV1.Entity.Credit;
import bankApiV1.Service.CreditService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bankApi/")
public class CreditController {
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("credit/")
    public List<Optional<Credit>> loanInquiry(@RequestParam(value = "tckn") Long tckn, @RequestParam(value = "birthDate") LocalDate birthdate) {
        return creditService.loanApplicationResults(tckn, birthdate);
    }


    @GetMapping("test/")
    public void test(@RequestParam(value = "tckn") Long tckn) {
        creditService.yazdir(tckn);
    }

    @GetMapping("creditApplication/")
    public Credit creditApplication(@RequestParam(value = "tckn") Long tckn){
        return creditService.loanApplicationRequest(tckn);
    }
}
