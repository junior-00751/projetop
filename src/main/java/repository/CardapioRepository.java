package repository;

import entity.CardapioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardapioRepository extends JpaRepository<CardapioItem, Long> {
    List<CardapioItem> findByEstabelecimentoId(Long estabelecimentoId);
}
