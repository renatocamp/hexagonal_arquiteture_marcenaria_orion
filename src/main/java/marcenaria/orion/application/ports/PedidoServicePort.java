package marcenaria.orion.application.ports;

import java.util.List;

import marcenaria.orion.domain.Pedido;

public interface PedidoServicePort {
	
	boolean existePedido(Long pedidoId);
	
	Pedido criarPedido(Pedido pedido);

	List<Pedido> listarPedidos();

}
