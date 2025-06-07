package controller;

import entity.CardapioItem;
import entity.Pedido;
import entity.User;
import repository.CardapioRepository;
import repository.PedidoRepository;
import repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoRepository pedidoRepository;
    private final UserRepository userRepository;
    private final CardapioRepository cardapioRepository;

    @PostMapping
    public Pedido fazerPedido(@RequestParam Long clienteId, @RequestParam Long itemId) {
        User cliente = userRepository.findById(clienteId).orElseThrow();
        CardapioItem item = cardapioRepository.findById(itemId).orElseThrow();
        Pedido pedido = new Pedido(null, cliente, item, LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/{clienteId}")
    public List<Pedido> listarPedidos(@PathVariable Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }
}