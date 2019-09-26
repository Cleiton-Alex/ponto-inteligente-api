package com.controle.pontointeligente.services;

import com.controle.pontointeligente.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    /**
     * Retorna uma empresa dado um CNPJ
     *
     * @return Optional<Empresa>
     * @Param cnpj
     */

    Optional<Empresa> buscarPorCnpj(String cnpj);


    /**
     * Cadastra uma nova empresa na base de dados
     *
     * @param empresa
     * @return Empresa
     */
    Empresa persistir(Empresa empresa);

}
