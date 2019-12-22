[![Build Status](https://travis-ci.org/Cleiton-Alex/ponto-inteligente-api.svg?branch=master)](https://travis-ci.org/Cleiton-Alex/ponto-inteligente-api)

#Ponto Inteligente 

API do sistema de ponto inteligente com Java e Spring Boot. 


<h3>Detalhes da API RESTful</h3>
    <div>
     <p>A Api Restful de Ponto Inteligente contém as 
     seguintes características:</p>
    </div>
<div>
    <ul>
    <li>Projeto criado com Spring Boot 2 e Java 8</li>
    <li>Banco de dados MYSQL JPA e Spring Data JPA</li>
    <li>Autenticação e autorização com Spring Security e tokens JWT(JSON WEB Token)</li>
    <li>Migração de banco de dados com Flyway</li>
    <li>Testes unitários e de integração com JUnit Mockito</li>
    <li>Caching com EhCache</li>
    <li>Integração contínua com TravisCI</li>
    </ul>
</div>


<h3>Documentação da API de acesso aos endpoints com Swagger </h3>

http://localhost:8080/swagger-ui.html#/

<h3>Como executar a aplicação</h3>
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.


    git clonehttps://github.com/Cleiton-Alex/ponto-inteligente-api.git
    cd ponto-inteligente-api
    mvn spring-boot:run
    Acesse os endpoints através da url http://localhost:8080
    
 <h3>Importando o projeto no Eclipse, STS ou Intellij</h3>
 <p>no terminal, execute a seguinte operações</p>
 
    mvn eclipse:eclipse
    mvn intellij:intellij
    
No Eclipse/STS/Intellij, importe o projeto como projeto Maven.
