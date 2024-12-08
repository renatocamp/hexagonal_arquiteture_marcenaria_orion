package marcenaria.orion.infrastructure.adapters.outputs;

import java.util.List;
import java.util.Optional;

import marcenaria.orion.application.ports.PedidoRepositoryPort;
import marcenaria.orion.domain.Pedido;

public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoRepositoryImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        var entity = pedidoMapper.toEntity(pedido);
        return pedidoMapper.toDomain(pedidoRepository.save(entity));
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id).map(pedidoMapper::toDomain);
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll().stream().map(pedidoMapper::toDomain).toList();
    }
}
