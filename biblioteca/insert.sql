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

