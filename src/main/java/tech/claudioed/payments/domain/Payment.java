package tech.claudioed.payments.domain;

import java.math.BigDecimal;
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
public class Payment {

  private String id;

  private BigDecimal value;

  private Customer customer;

  private String status;

}
