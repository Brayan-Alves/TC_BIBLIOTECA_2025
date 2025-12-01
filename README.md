Sistema de Biblioteca

Sobre o Projeto:
Este projeto é um Sistema de Gerenciamento de Biblioteca, desenvolvido em Java utilizando o padrão MVC (Model–View–Controller).
O sistema permite que usuários comuns realizem empréstimos, devoluções e consultem livros, enquanto administradores podem gerenciar autores, editoras, livros e usuários.

Funcionalidades Principais
Usuário
-Criar conta
-Fazer login
-Listar livros disponíveis
-Realizar empréstimo
-Devolver livro
-Consultar seus empréstimos
-Alterar senha

Administrador
Gerenciar Autores
-Cadastrar
-Listar
-Atualizar
-Excluir
Gerenciar Editoras
-Cadastrar
-Listar
-Atualizar
-Excluir
Gerenciar Livros
-Cadastrar (com múltiplos autores)
-Listar
-Atualizar
-Excluir
-Gerenciar Usuários
-Cadastrar
-Listar
-Atualizar
-Excluir

Arquitetura do Projeto
/src
 ├── controller
 │     ├── AutorController.java
 │     ├── EditoraController.java
 │     ├── LivroController.java
 │     ├── LivroAutorController.java
 │     ├── UsuarioController.java
 │     └── EmprestimoController.java
 │
 ├── model
 │     ├── Autor.java
 │     ├── Editora.java
 │     ├── Livro.java
 │     ├── Usuario.java
 │     └── Emprestimo.java
 │
 └── view
       └── Main.java

Banco de Dados

Banco de dados MySQL com tabelas:
autor
editora
livro
usuario
emprestimo
autor_livro

Como Executar o Projeto
Pré-requisitos

Java 21+
MySQL 8+
JDBC
IDE (InteliJ, VSCode) ou terminal

Passos

Clone o repositório:
git clone https://github.com/Brayan-Alves/TC_BIBLIOTECA_2025.git
Importe o projeto na IDE
Configure a conexão MySQL nos controllers
Execute o arquivo:
Main.java

Acesso de Administrador
Senha padrão:
1234

Tecnologias Utilizadas

Java 21
MySQL
JDBC
MVC
Programação Orientada a Objetos

Autor: Brayan Alves dos Santos
Turma: 2 Técnico em Informâtica
IFPR - Câmpus Cascavel