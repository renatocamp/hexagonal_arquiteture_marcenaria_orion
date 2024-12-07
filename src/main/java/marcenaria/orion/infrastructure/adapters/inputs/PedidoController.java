package marcenaria.orion.infrastructure.adapters.inputs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.domain.Pedido;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServicePort pedidoService;
	
	@PostMapping
	public ResponseEntity<?> criarPedido(@RequestBody Pedido pedido) {
		
	    if (pedido.getId() != null && pedidoService.existePedido(pedido.getId())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	                .body("O pedido com ID " + pedido.getId() + " já existe.");
	    }

	    Pedido novoPedido = pedidoService.criarPedido(pedido);
	    return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
	}
	
	@GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

}
