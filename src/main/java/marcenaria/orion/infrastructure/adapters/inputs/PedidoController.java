package marcenaria.orion.infrastructure.adapters.inputs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marcenaria.orion.application.ports.PedidoServicePort;
import marcenaria.orion.domain.Pedido;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    public PedidoController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoServicePort.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoServicePort.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos() {
        return ResponseEntity.ok(pedidoServicePort.buscarTodos());
    }
}
