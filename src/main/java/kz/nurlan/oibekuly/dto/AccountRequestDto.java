package kz.nurlan.oibekuly.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto implements Serializable {
    @ApiModelProperty
    private Long accountnumber;
    @ApiModelProperty
    private double balance = 10000.0;
    @ApiModelProperty
    private double interest;
}
