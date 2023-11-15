# Sprint4-DDD
Destinado à API-Jersey em Java da Sprint 4 do Challenge-2023 da Porto Seguro. 

> A aplicação Restful a seguir é responsável por conectar o banco de dados presente no Oracle ao JavaScript utilizando da estrutura de projetos Maven, API-Jersey 


## 🖊 Resumo sobre o projeto
Como resposta à necessidade da Porto Seguro Seguros de automatizar o processo de vistorias de bicicletas, a equipe ProjectP propôs uma solução na qual uma inteligência artificial, presente em um site, reconhece as imagens submetidas de uma bike, cataloga suas informações, armazena-as em um banco de dados e processa a aprovação ou negação da contratação de um seguro para o veículo.

Este projeto foi pensado com o objetivo de realizar as requisições ao banco de dados para retornar dados da vistoria em formato de um arquivo JSON para o Front-End produzido com Next.js.


## 📜 Pré-requisitos
- Ter o Eclipse IDE instalado e saber manipulá-lo
- Ter instalado e conhecer o Insomnia


## ☕ Abrindo o projeto
1. Copie o link do repositório no Eclipse
2. Siga o caminho: "projeto" -> src -> main -> java -> br.com.fiap.projeto -> clique em Main
3. No arquivo Main, execute com a tecla F11


## 💻 Usando a aplicação
MÉTODO GET
1. Abra uma nova guia do navegador
2. Digite o endereço de requisição para a classe específica, por exemplo
```
http://localhost:8080/projeto/classe
```

MÉTODO POST
1. Abra o Insomnia
2. Escolha o verbo post
3. Digite a url no mesmo molde apresentado acima
4. Clique em Body -> JSON
5. Inclua informações no molde do JSON
6. Clique em send


MÉTODO POST E DELETE
1. Abra uma nova guia do navegador
2. Digite o endereço de requisição para a classe específica e o id do objeto para exclusão ou alteração:
```
http://localhost:8080/projeto/id
```

## 💙 Sobre nós
Nossa equipe é formada por um grupo de estudantes (até então - 2023) no 1º ano do curso de Análise e Desenvolvimento de Sistemas.
Em nossa faculdade, a cada ano recebemos um Challenge proposto por uma empresa. Esse ano, a Porto Seguro Seguros apresentou o desejo de automatizar a vistoria de bicicletas (vistoria essa, etapa prévia para contratação de seguros). 
A ProjectP buscou apresentar por meio deste, uma proposta pertinente e escalável para outros tipos de vistoriação.

#### ⚠ NOTA:
Esse repositório contém apenas a aplicação em Java. Outras etapas para execução completa do Project P, como o front-end, não estão presentes.


## 🎲 Alguns dados sobre o repositório
![GitHub repo size](https://img.shields.io/github/repo-size/M1relly/Sprint4-DDD?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/M1relly/Sprint4-DDD?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/M1relly/Sprint4-DDD?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/M1relly/Sprint4-DDD?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/M1relly/Sprint4-DDD?style=for-the-badge)
