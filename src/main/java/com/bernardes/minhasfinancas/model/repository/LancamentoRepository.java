package com.bernardes.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bernardes.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
