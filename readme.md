
# Teste prático de admissão

- Este teste tem como objetivo identificar os conhecimentos quantos às tecnologias utilizadas no cotidiano de desenvolvimento da equipe da empresa contratante.

Esta análise propõe avaliar os seguintes temas
```
- Qualidade de código
- Java, Spring boot
- API REST
- Testes
```
# DESAFIO

Usando Spring Boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:
```
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa
```


Uma Pessoa deve ter os seguintes campos:

<ol>
<li>Nome</li>
<li>Data de nascimento</li>
<li>Endereço:</li>

- Logradouro
- CEP
- Número
- Cidade
</ol>

## Requisitos
- Todas as respostas da API devem ser JSON
- Banco de dados H2

## Diferencial 
- Testes
- Clean code
## Será levado em avaliação
- Estrutura, arquitetura e organização do projeto
- Boas práticas de programação
- Alcance dos objetivos propostos

--------------------------------

## Explicação do código:
- Foi utilizado para a criação desta API o pattern DTO, além das tecnologias predefinidas no desafio. 
- Para o teste das querys, escolhi trabalhar com o insomnia(o arquivo com o export das querys do insomnia está na pasta "insomnia").
- A estrutura de diretórios ficou da seguinte forma:

```

├── controller              * Recebe a query do front
├── dto                     * Objetos de entrada e saída da API
├── entity                  * Entidades
├── insomnia                * Arquivo exportado diretamente do insomnia com as querys
├── repository              * Responsável por conversar e efetuar a query no BD
├── service                 * Responsável pela lógica e regras de negócio
├── util                    * Mappers para a aplicação
├── DemoApplication.java
└── readme.md

```