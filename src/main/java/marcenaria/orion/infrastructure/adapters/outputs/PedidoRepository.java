package marcenaria.orion.infrastructure.adapters.outputs;

import org.springframework.data.jpa.repository.JpaRepository;

import marcenaria.orion.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	

}
