package marcenaria.orion.infrastructure.adapters.outputs;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import marcenaria.orion.domain.ItemPedido;
import marcenaria.orion.domain.Pedido;

@Component
public class PedidoMapper {
	
	public PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());
        entity.setCliente(pedido.getCliente());
        entity.setItens(pedido.getItens().stream()
                .map(PedidoMapper::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    public Pedido toDomain(PedidoEntity entity) {
        Pedido pedido = new Pedido();
        pedido.setId(entity.getId());
        pedido.setCliente(entity.getCliente());
        pedido.setItens(entity.getItens().stream()
                .map(PedidoMapper::toDomain)
                .collect(Collectors.toList()));
        return pedido;
    }

    public static ItemPedidoEntity toEntity(ItemPedido item) {
        ItemPedidoEntity entity = new ItemPedidoEntity();
        entity.setId(item.getId());
        entity.setDescricao(item.getDescricao());
        entity.setQuantidade(item.getQuantidade());
        return entity;
    }

    public static ItemPedido toDomain(ItemPedidoEntity entity) {
        ItemPedido item = new ItemPedido();
        item.setId(entity.getId());
        item.setDescricao(entity.getDescricao());
        item.setQuantidade(entity.getQuantidade());
        return item;
    }

}
