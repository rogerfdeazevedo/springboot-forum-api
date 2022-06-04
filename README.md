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

* **1.1.0**
  * **Paginição e Ordenação de recursos**
    * **Controller**: Uso da inteface Pageable para realizar a paginação com Spring Data JPA;
    * **Controller**: Métodos passam a retornar objetos do tipo Page<> ao invés de List<>;
    * **Repository**: Métodos passam a receber como parâmetro um Pageable e retornar objetos do tipo Page<> ao invés de List<>;
    * **Main**: Habilitar módulo SpringDataWebSupport adicionando a anotação @EnableSpringDataWebSupport na classe principal da aplicação;

* **1.0.0**
    * **Spring Boot API REST - CRUD Básico**
      * **Spring Initializer**: Template para criação de projetos com Spring Boot;
      * **Arquitetura REST**: Principais conceitos como resursos, URIs, verbos HTTP e comunicação Statess;     
      * **Dependências**: Utilizar o módulo Spring Boot DevTools para não precisar reiniciar manualmente o servidor sempre que ocorre alteração de código;
      * **Dependências**: Utilizar o módulo Spring Boot Data JPA para utilizar JPA no projeto;
      * **Dependências**: Utilizar banco de dados em memóriia H2;
      * **Controller**: Como boa prática utilizar objetos DTOs no retorno dos metódos ao invés de devolver entidades JPA;
      * **Bean Validation**: Utilizar para tratamento de erros do cliente, validações de campos na requisição;
   
      

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