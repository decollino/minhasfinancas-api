package com.bernardes.minhasfinancas.service;

import java.util.List;

import com.bernardes.minhasfinancas.model.entity.Lancamento;
import com.bernardes.minhasfinancas.model.enums.StatusLancamento;

public interface LancamentoService {

	Lancamento salvar(Lancamento lancamento);
	
	Lancamento atualizar(Lancamento lancamento);
	
	void deletar(Lancamento lancamento);
	
	List<Lancamento> buscar( Lancamento lancamentoFiltro );
	
	void atualizarStatus(Lancamento lancamento, StatusLancamento status);
	
	void validar(Lancamento lancamento);
	
//	Optional<Lancamento> obterPorId(Long id);
	
//	BigDecimal obterSaldoPorUsuario(Long id);
}
