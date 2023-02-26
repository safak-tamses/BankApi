package bankApiV1.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credit_score")
@Getter
@Setter
public class CreditScore {
    @Id
    @Column(name = "tckn")
    private long tckn;
    private long creditScore;
}
