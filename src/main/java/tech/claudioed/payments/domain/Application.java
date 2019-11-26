package tech.claudioed.payments.domain;

import io.vertx.core.AbstractVerticle;

/**
 * @author claudioed on 23/11/19.
 * Project payments-data-generator
 */
public class Application extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.deployVerticle(new RandomPaymentsVerticle());
  }


}
