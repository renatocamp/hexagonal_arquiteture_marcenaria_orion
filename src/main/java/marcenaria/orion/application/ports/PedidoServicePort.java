package marcenaria.orion.application.ports;

import java.util.List;
import java.util.Optional;

import marcenaria.orion.domain.Pedido;

public interface PedidoServicePort {
	
    Pedido criarPedido(Pedido pedido);
    
    Optional<Pedido> buscarPorId(Long id);
    
    List<Pedido> buscarTodos();
}
