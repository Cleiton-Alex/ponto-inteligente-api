package com.controle.pontointeligente.services;

import com.controle.pontointeligente.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioService {
    /**
     * Persiste um funcionario na base de dados
     *
     * @param funcionario
     * @return funcionario
     */
    Funcionario persiste(Funcionario funcionario);


    /**
     * Buscar e retorna um funcionario dado um CPF
     *
     * @param cpf
     * @return Optional<Funcionairo>
     */
    Optional<Funcionario> buscarPorCpf(String cpf);


    /**
     * Buscar e retorna um funcionario dado um email
     *
     * @param email
     * @return Optional<Funcionairo>
     */
    Optional<Funcionario> buscarPorEmail(String email);


    /**
     * Buscar e retorna um funcionario dado um email
     *
     * @param id
     * @return Optional<Funcionairo>
     */
    Optional<Funcionario> buscarPorId(Long id);

}





