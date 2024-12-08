package marcenaria.orion.application.usecases;

import java.util.List;
import java.util.Optional;

import marcenaria.orion.application.ports.PedidoRepositoryPort;
import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.domain.Pedido;

public class PedidoServiceImpl implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoServiceImpl(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepositoryPort.salvar(pedido);
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepositoryPort.buscarPorId(id);
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepositoryPort.buscarTodos();
    }
}