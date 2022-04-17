
package kz.nurlan.oibekuly.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope("prototype")
@Component
@Entity(name = "account")
@ApiModel
@Table(name = "account")
public class Account  {

    @Id
    @Column(name = "account_id")
    private Integer account_id;

    @Column(name = "accountnumber")
    private Long accountnumber;

    @Column(name = "balance")
    private double balance = 10000.0;

    @Column(name = "interest")
    private double interest;

    public Account(Long accountnumber, double balance, double interest) {
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.interest = interest;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
