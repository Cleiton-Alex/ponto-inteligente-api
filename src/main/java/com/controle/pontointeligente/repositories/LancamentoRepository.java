package com.controle.pontointeligente.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.controle.pontointeligente.entities.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

// server para criar query mais antes tenho que referenciar a class e depois definir o metodo para ela
//criando a consulta no banco mais voltado para os objetos
@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "LancamentoRepository.findByFuncionarioId",

                query = "SELECT lanc FROM Lancamento lanc WHERE lanc.funcionario.id = :funcionarioId") })
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    //criando  o metodo e o parametro que dever ser recebido por eles
    List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);

    Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);

}

