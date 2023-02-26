package bankApiV1.Controller;

import bankApiV1.Entity.Customer;
import bankApiV1.Service.CustomerService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankApi/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customerCreate")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);

    }
    @PutMapping("/customerUpdate")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/customerDelete")
    public void deleteCustomer(@RequestParam(value = "tckn")  Long tckn) {
        customerService.deleteCustomer(tckn);

    }
}
