package marcenaria.orion.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.application.usecases.PedidoServiceImpl;

@Configuration
public class BeanConfiguration {
	
	@Bean
    public PedidoServicePort pedidoService() {
        return new PedidoServiceImpl();
    }

}
