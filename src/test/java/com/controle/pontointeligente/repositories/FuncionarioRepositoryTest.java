package com.controle.pontointeligente.repositories;

import com.controle.pontointeligente.entities.Empresa;
import com.controle.pontointeligente.entities.Funcionario;
import com.controle.pontointeligente.enums.PerfilEnum;
import com.controle.pontointeligente.utils.PasswordUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    @Autowired
    private EmpresaRepository empresaRepository;

    private static final String EMAIL = "email@email.com";
    private static final String CPF = "000000000000";


    @Before
    public void setUp() throws Exception {

        Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
        this.funcionarioRepository.save(obterDadosFuncionario(empresa));
    }


    @After
    public void tearDown() {
        this.empresaRepository.deleteAll();

    }

    @Test
    public void testebuscarFuncionarioPorEmail(){
        Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);

        assertEquals(EMAIL, funcionario.getEmail());
    }

    @Test
    public void testbuscarFuncionarioPorCpf(){
        Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
        assertEquals(CPF, funcionario.getCpf());
    }


    @Test
    public void testBuscarFuncionarioEmailECpf(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
        assertNotNull(funcionario);
    }

    @Test
    public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");
        assertNotNull(funcionario);
    }


    @Test
    public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido(){
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);
        assertNotNull(funcionario);
    }


    private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Fulano de Tal");
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
        funcionario.setCpf(CPF);
        funcionario.setEmail(EMAIL);
        funcionario.setEmpresa(empresa);
        return funcionario;
    }



    private Empresa obterDadosEmpresa(){
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa exemplo");
        empresa.setCnpj("51463645000100");
        return empresa;
    }

}
