package tech.claudioed.payments.domain;

import com.github.javafaker.Faker;
import io.nats.client.Connection;
import io.nats.client.Nats;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author claudioed on 23/11/19.
 * Project payments-data-generator
 */
public class RandomPaymentsVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.setPeriodic(1,handler ->{
      Faker faker = new Faker(new Locale("en_US"));
      final Customer customer = Customer.builder().address(faker.address().fullAddress())
          .city(faker.address().city()).name(faker.name().name()).lastName(faker.name().lastName())
          .nation(faker.nation().nationality()).country(faker.address().country()).build();

      double random = ThreadLocalRandom.current().nextDouble(1, 100);
      final Payment payment = Payment.builder().id(UUID.randomUUID().toString())
          .status("processed").value(BigDecimal.valueOf(random)).customer(customer).build();
      System.out.println(payment.toString());
      try {

        final String natsHost = System.getenv("NATS_HOST");
        Connection nc = Nats.connect(natsHost);
        final String data = Json.encode(payment);
        nc.publish("payments-processed", data.getBytes(StandardCharsets.UTF_8));
        nc.flush(Duration.ZERO);
        nc.close();
      } catch (Exception e) {
        System.out.println("Error " + e);
      }
    });
  }

}
