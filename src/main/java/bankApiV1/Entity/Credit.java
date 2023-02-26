package bankApiV1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "credit")
@Getter
@Setter
public class Credit {
    @Id
    @Column(name = "tckn")
    private long tckn;

    private LocalDate birthDate;

    private LocalDate createDate;
    private boolean result;
    private long loanAmount;

}
