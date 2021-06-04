package br.com.criaproposta.demo.config.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;


@Component
public class MeuHealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		Map<String, Object> details = new HashMap<>();
        details.put("name", "demo");
        details.put("description", "Demo criacao de proposta");
        details.put("endereço", "127.0.0.1");
      
        return Health.status(Status.UP).withDetails(details).build();
	}

}
