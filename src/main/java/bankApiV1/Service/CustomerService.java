package bankApiV1.Service;

import bankApiV1.Entity.Customer;
import bankApiV1.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        Customer tempCustomer = customerRepository.findByTckn(customer.getTckn()).orElseThrow();
        tempCustomer.setName(customer.getName());
        tempCustomer.setSurName(customer.getSurName());
        tempCustomer.setMonthlyIncome(customer.getMonthlyIncome());
        tempCustomer.setPhoneNumber(customer.getPhoneNumber());
        tempCustomer.setBirthDate(customer.getBirthDate());
        tempCustomer.setGuarantee(customer.getGuarantee());
        return customerRepository.save(tempCustomer);
    }

    public void deleteCustomer(Long tckn) {
        Customer temp = customerRepository.findByTckn(tckn).orElseThrow();
        customerRepository.delete(temp);
    }

    public Long monthlyIncome(Long tckn) {
        Customer temp = customerRepository.findByTckn(tckn).orElseThrow();
        return temp.getMonthlyIncome();
    }

    public Long guarantee(Long tckn) {
        Customer temp = customerRepository.findByTckn(tckn).orElseThrow();
        return temp.getGuarantee();
    }
    public LocalDate birthDay(Long tckn){
        Customer temp = customerRepository.findByTckn(tckn).orElseThrow();
        return temp.getBirthDate();
    }
}
