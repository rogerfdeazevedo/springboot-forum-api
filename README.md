[![header][header-url]][header-link]

# Spring Boot Forum API
[![Project Version][version-image]][version-url]
[![Backend][Backend-image]][Backend-url]

> Projeto de estudo para desenvolvimento de API REST.

Simula parte de um forum de discussão de um portal de cursos.

---
## Autor

**Roger de Azevedo** 

* *Meu perfil profissional no* [LinkedIn][linkedin-url]

## Apresentação

Esse projeto foi desenvolvimedo para demonstrar:

* Java 
* Orientação a Objetos
* CRUD
* Arquitetra API REST / Micro-serviço

## Tecnologia

* [Maven](https://maven.org/) - Dependency Management
* [Spring Boot Framework](https://https://start.spring.io/) - Framework API Rest

## Release History

* **1.3.0**
* **Spring Security**
  * **Dependências**:
    * * Utilizar o módulo Spring Boot Starter Security para usar o recurso de segurança;
  * **Configurações**:
    * Necessário criar uma nova classe para gerenciar as configurações de segurança;
      * Exemplo: ...config.security.SecurityConfigurations
    * Habilitar as configurações utilizando as anotações @EnableWebSecurity e @ Configuration no inicio da classe;
    * Herdar da classe WebSecurityConfigurerAdapter para sobrescrever métodos de cofiguração que vamos utilizar;
    * Por padrão o módulo de segurança do Spring bloqueia todos os endpoints, preciso fazer as configurações necessárias;
    * Método "configure": 
      * Autenticação (AuthenticationManagerBuilder auth): Serve para realizar validações de login de usuário;
        * * Utilizar um algoritmo de hashing de senha no método passwordEncoder();
      * Autorização (HttpSecurity http): Serve para realizar liberação de endpoint;
        * Permitir acesso a endpoints específicos com o método: "antMathers"
        * Restringir acesso a outros endpoits não pertimitos com os métodos: anyRequest().authenticated();
        * Tela de login para autenticação de usuário em endpoints restritos com os métodos: .and().formLogin();
        * Implementar as interfaces UserDetails na classe Usuario e GrandAuthority na classe Perfil, para que o Spring possa implentar o controle de autenticação;
        * Implementar a interface UserDetailsService para fazer a lógica de autenticação validando o usuário no banco de dados;        
      * Recursos estáticos (WebSecurity web): Serve para realizar liberação de js, css, imagens e etc;

* **1.2.0** 
* **Spring Cache**
  * **Dependências**:
      * Utilizar o módulo Spring Boot Starter Cache para usar o recurso de cache;      
  * **Main**:
    * Utilizar anotação @EnableCaching para hailitar o uso de cache no projeto na classe principal da aplicação;
  * **Controller**:
    * Utilizar anotação @Cacheable para definir qual controller deve utilizar cache;
    * Utilizar um id para cache no atributo value da anotação, no caso de usar cache em mais de um método na mesma controller;
      * Exemplo: @Cacheable (value = "listarTopicos")
    * Utilizar anotação @CacheEvict para resetar o cach quando for cadastrado, atualizado  ou removido um recurso;
    * É necessário indicar qual cache ira ser modificado atráves do seu id;
      * Exempleo: @CacheEvict(value = "listarTopicos", allEntries = true)
  * **Boas práticas**:
    * Utilizar cache padrão em memória para fins de estudo, configurar servidor de cache em produção como boa prática;
    * Utilizar cache em tabelas que ocorram pouca ou nenhum atualização, como tabelas de parametros por exemplo;

* **1.1.0**
  * **Paginição e Ordenação de recursos**
    * **Controller**: 
      * Uso da inteface Pageable para realizar a paginação com Spring Data JPA;
      * Métodos passam a retornar objetos do tipo Page<> ao invés de List<>;
    * **Repository**: 
      * Métodos passam a receber como parâmetro um Pageable e retornar objetos do tipo Page<> ao invés de List<>;
    * **Main**: 
      * Habilitar módulo SpringDataWebSupport adicionando a anotação @EnableSpringDataWebSupport na classe principal da aplicação;

* **1.0.0**
    * **Spring Boot API REST - CRUD Básico**
      * **Spring Initializer**: 
        * Template para criação de projetos com Spring Boot;
      * **Arquitetura REST**: 
        * Principais conceitos como resursos, URIs, verbos HTTP e comunicação Statess;     
      * **Dependências**: 
        * Utilizar o módulo Spring Boot DevTools para não precisar reiniciar manualmente o servidor sempre que ocorre alteração de código;
        * Utilizar o módulo Spring Boot Data JPA para utilizar JPA no projeto;
        * Utilizar banco de dados em memóriia H2;
      * **Controller**: 
        * Como boa prática utilizar objetos DTOs no retorno dos metódos ao invés de devolver entidades JPA;
      * **Bean Validation**: 
        * Utilizar para tratamento de erros do cliente, validações de campos na requisição;
   
      

## Tópico Forum Api

API responsável pelo dominio de negócio de Tópicos de discussão em um fórum de cursos em uma escola de tecnologia. 



---



<!-- Markdown link & img dfn's -->

[header-url]: github-template.png
[header-link]: https://github.com/alexandrerosseto

[repository-url]: https://github.com/alexandrerosseto/wbshopping

[cloud-provider-url]: https://wbshopping.herokuapp.com

[linkedin-url]: https://www.linkedin.com/in/alexandrerosseto

[wiki]: https://github.com/yourname/yourproject/wiki

[version-image]: https://img.shields.io/badge/Version-1.0.0-brightgreen?style=for-the-badge&logo=appveyor
[version-url]: https://img.shields.io/badge/version-1.0.0-green
[Backend-image]: https://img.shields.io/badge/Backend-Java%2011-important?style=for-the-badge
[Backend-url]: https://img.shields.io/badge/Backend-Java%2011-important?style=for-the-badge