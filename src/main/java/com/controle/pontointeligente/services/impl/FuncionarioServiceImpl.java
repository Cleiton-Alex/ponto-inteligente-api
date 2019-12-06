package com.controle.pontointeligente.services.impl;

import com.controle.pontointeligente.entities.Funcionario;
import com.controle.pontointeligente.repositories.FuncionarioRepository;
import com.controle.pontointeligente.services.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {


    private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Override
    public Funcionario persiste(Funcionario funcionario) {
        log.info("Pesistindo funcionario:{}", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("Buscando funcionario pelo CPF {}", cpf);
        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    @Override
    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("Buscando funcionario pelo EMAIL {}", email);
        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("Buscando funcionario pelo ID {}", id);
        return this.funcionarioRepository.findById(id);
    }
}
