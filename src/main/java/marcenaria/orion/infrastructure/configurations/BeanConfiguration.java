package marcenaria.orion.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import marcenaria.orion.application.ports.PedidoRepositoryPort;
import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.application.usecases.PedidoServiceImpl;
import marcenaria.orion.infrastructure.adapters.outputs.PedidoMapper;
import marcenaria.orion.infrastructure.adapters.outputs.PedidoRepository;
import marcenaria.orion.infrastructure.adapters.outputs.PedidoRepositoryImpl;

@Configuration
public class BeanConfiguration {

    @Bean
    public PedidoServicePort pedidoServicePort(PedidoRepositoryPort pedidoRepositoryPort) {
        return new PedidoServiceImpl(pedidoRepositoryPort);
    }

    @Bean
    public PedidoRepositoryPort pedidoRepositoryPort(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        return new PedidoRepositoryImpl(pedidoRepository, pedidoMapper);
    }
}
