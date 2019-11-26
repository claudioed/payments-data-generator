package tech.claudioed.payments.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudioed on 23/11/19.
 * Project payments-data-generator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  private String name;

  private String lastName;

  private String address;

  private String nation;

  private String city;

  private String country;

}
