package marcenaria.orion.application.usecases;

import java.math.BigDecimal;
import java.util.List;

import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.domain.Pedido;
import marcenaria.orion.infrastructure.adapters.outputs.PedidoRepository;

public class PedidoServiceImpl implements PedidoServicePort{
	
	
	private PedidoRepository pedidoRepository;
	
	public PedidoServiceImpl() {
		
	}
	
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public Pedido criarPedido(Pedido pedido) {
		
		pedido.setValorTotal(calcularValorTotal(pedido));
		
		return pedidoRepository.save(pedido);
	}
	
	private BigDecimal calcularValorTotal(Pedido pedido) {
		
		return pedido.getItens().stream()
				.map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public List<Pedido> listarPedidos() {
		
		return pedidoRepository.findAll();
	}

	@Override
	public boolean existePedido(Long pedidoId) {
		
		return pedidoRepository.existsById(pedidoId);
	}

}
