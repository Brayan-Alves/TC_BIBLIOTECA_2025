INSERT INTO editora (id_editora, nome) VALUES
(1, 'Companhia das Letras'),
(2, 'Editora Record'),
(3, 'Editora Globo'),
(4, 'Rocco'),
(5, 'Penguin'),
(6, 'Intrínseca');

INSERT INTO autor (id_autor, nome) VALUES
(1, 'Machado de Assis'),
(2, 'Graciliano Ramos'),
(3, 'J. R. R. Tolkien'),
(4, 'George Orwell'),
(5, 'J. K. Rowling'),
(6, 'Antoine de Saint-Exupéry'),
(7, 'Dan Brown'),
(8, 'Suzanne Collins');

INSERT INTO livro (id_livro, titulo, ano, id_editora) VALUES
(1, 'Dom Casmurro', 1899, 1),
(2, 'Vidas Secas', 1938, 2),
(3, 'O Senhor dos Anéis: A Sociedade do Anel', 1954, 3),
(4, '1984', 1949, 5),
(5, 'Harry Potter e a Pedra Filosofal', 1997, 4),
(6, 'O Pequeno Príncipe', 1943, 6),
(7, 'O Código Da Vinci', 2003, 6),
(8, 'Jogos Vorazes', 2008, 6);

INSERT INTO autor_livro (id_livro, id_autor) VALUES
(1, 1),
(2, 2),
(3, 3), 
(4, 4),
(5, 5),
(6, 6), 
(7, 7), 
(8, 8); 

INSERT INTO usuario (nome, endereco, email, senha) VALUES
('Carlos Almeida', 'Rua das Flores, 123', 'carlos.almeida@email.com', '123456'),
('Mariana Santos', 'Av. Paulista, 890', 'mariana.santos@email.com', 'senha123'),
('João Pereira', 'Rua do Sol, 45', 'joao.pereira@email.com', 'abc123'),
('Ana Paula Silva', 'Rua das Acácias, 222', 'ana.paula@email.com', 'paula2025'),
('Brayan Alves dos Santos', 'Rua Serra Encantada, 319', 'brayanalvesdossantos67@gmail.com', 'tcb123'),
('Lucas Ferreira', 'Rua Verde, 900', 'lucas.ferreira@email.com', 'lucaspass');

INSERT INTO emprestimo (data_emprestimo, data_devolucao, id_livro, id_usuario, devolvido) VALUES
('2025-01-10', '2025-01-20', 1, 1, 1),  
('2025-01-15', '2025-01-25', 4, 1, 0),  
('2025-01-12', '2025-01-22', 6, 2, 1), 
('2025-01-28', '2025-02-07', 8, 2, 0),  
('2025-01-05', '2025-01-15', 2, 3, 1),  
('2025-01-18', '2025-01-28', 7, 3, 0), 
('2025-01-07', '2025-01-17', 3, 4, 1), 
('2025-01-25', '2025-02-04', 5, 4, 0),  
('2025-01-03', '2025-01-13', 5, 5, 1),  
('2025-01-20', '2025-01-30', 1, 5, 0); 

