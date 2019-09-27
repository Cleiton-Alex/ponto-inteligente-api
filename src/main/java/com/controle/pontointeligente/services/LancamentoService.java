package com.controle.pontointeligente.services;

import com.controle.pontointeligente.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface LancamentoService {

    /**
     * Retorna uma lista paginada de lancamento de um determinado funcionário
     *
     * @param funcionarioId
     * @param pageRequest
     * @return Page<Lancamento>
     *
     * */
    Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);


    /**
     * Retorna um Lançamento por ID
     *
     * @param id
     * @return Optional<Lancamento>
     *
     * */
    Optional<Lancamento> buscarPorId(Long id);


    /**
     * Persiste um lancamento na base de dados
     *
     * @param lancamento
     * @return lancamento
     * */
    Lancamento persistir(Lancamento lancamento);


    /**
     * Retorna uma lista paginada de lancamento de um determinado funcionário
     *
     * @param id
     * */
    void remover(Long id);
}
