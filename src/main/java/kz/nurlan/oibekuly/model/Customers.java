package kz.nurlan.oibekuly.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
@Component
@Entity(name = "customers")
@Table(name = "customers")
public class Customers implements Serializable {
    @Id
    @Column(name = "customer_id")
    @ApiModelProperty(notes = "Customer Id",name="customer_id",required=true,value="1")
    private Integer customer_id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "firstname")
    @ApiModelProperty(notes = "Customer firstname",name="firstname",required=true,value=" test firstname")
    private String firstname;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lastname")
    @ApiModelProperty(notes = "Customer lastname",name="lastname",required=true,value=" test lastname")
    private String lastname;

    @Column(name = "age")
    @Min(
            value = 18,
            message = "You have to be 18 to be a customer of a bank"
    )
    @Digits(integer = 0, fraction = 0)
    @ApiModelProperty(notes = "Customer age",name="age",required=true,value=" test age")
    private int age;

    @Column(name = "address")
    @ApiModelProperty(notes = "Customer address",name="address",required=true,value=" test address")
    public String address;

    @Size(min = 1, max = 20)
    @ApiModelProperty(notes = "Customer iin",name="iin",required=true,value=" test iin")
    private String iin;

    @Column(name = "isRegistered")
    @ApiModelProperty(notes = "Customer isRegistered",name="isRegistered",required=true,value=" test isRegistered")
    private boolean isRegistered;

    @NotNull
    @Column(name = "dateOfBirth")
    @ApiModelProperty(notes = "Customer dateOfBirth",name="dateOfBirth",required=true,value=" test dateOfBirth")
    private Date dateOfBirth;

    public Customers(String firstname) {
        this.firstname = firstname;
    }

    public Customers(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customers(int customer_id, String james, String johnson, int age, String texas, String iin, boolean isRegistered, LocalDate date) {
    }

    public String customertoString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", iin='" + iin + '\'' +
                ", isRegistered=" + isRegistered +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
