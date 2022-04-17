package kz.nurlan.oibekuly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto  implements Serializable {
    @Id
    private Integer account_id;
    private Long accountnumber;
    private double balance = 10000.0;
    private double interest;

}
