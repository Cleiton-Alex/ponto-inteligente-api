package com.controle.pontointeligente.services.impl;

import com.controle.pontointeligente.entities.Lancamento;
import com.controle.pontointeligente.repositories.LancamentoRepository;
import com.controle.pontointeligente.services.LancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Override
    public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
        log.info("Buscando Lançaamento para o funcionários ID {}", funcionarioId);
        return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
    }
    @Cacheable("lancamentoPorId")
    public Optional<Lancamento> buscarPorId(Long id) {
        log.info("Buscar Lançaamento por ID {}", id);
        Optional byId = Optional.ofNullable(this.lancamentoRepository.findById(id));
        return byId;
    }

    @CachePut("lancamentoPorId")
    public Lancamento persistir(Lancamento lancamento) {
        log.info("Persistindo Lançamento: {}", lancamento);
        return this.lancamentoRepository.save(lancamento);
    }

    @Override
    public void remover(Long id) {
        log.info("Removendo Lançamento por ID {}", id);
        this.lancamentoRepository.deleteById(id);
    }
}
