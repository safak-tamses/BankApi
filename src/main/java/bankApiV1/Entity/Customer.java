package bankApiV1.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    private long tckn;

    private String name;
    private String surName;
    private long monthlyIncome;
    private String phoneNumber;
    private LocalDate birthDate;

    private long guarantee=0; // optional

    @OneToMany
    @JoinColumn(name = "tckn")
    private List<Credit> creditList;

    @OneToOne
    @JoinColumn(name = "tckn")
    private CreditScore creditScore;

}
