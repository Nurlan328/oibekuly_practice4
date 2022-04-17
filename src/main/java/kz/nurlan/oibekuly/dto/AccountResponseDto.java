package kz.nurlan.oibekuly.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountResponseDto implements Serializable {

    private Integer account_id;
    private Long accountnumber;
    private double balance = 10000.0;
    private double interest;

}
