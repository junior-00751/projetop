package controller;

import entity.CardapioItem;
import repository.CardapioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@RequiredArgsConstructor
public class CardapioController {
    private final CardapioRepository cardapioRepository;

    @PostMapping
    public CardapioItem adicionar(@RequestBody CardapioItem item) {
        return cardapioRepository.save(item);
    }

    @GetMapping("/{estabelecimentoId}")
    public List<CardapioItem> listar(@PathVariable Long estabelecimentoId) {
        return cardapioRepository.findByEstabelecimentoId(estabelecimentoId);
    }
}