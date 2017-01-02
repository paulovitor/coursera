CREATE TABLE usuario
(
  login text NOT NULL,
  email text,
  nome text,
  senha text,
  pontos integer,
  CONSTRAINT usuario_pkey PRIMARY KEY (login)
);

INSERT INTO usuario (login, email, nome, senha, pontos) VALUES ('jesus', 'jesus@coursera.org', 'Jesus', 'jesus', 0);
INSERT INTO usuario (login, email, nome, senha, pontos) VALUES ('mariazinha', 'maria@coursera.org', 'Maria', 'maria', 0);
    
CREATE SEQUENCE livro_id_livro_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE TABLE livro
(
  id integer NOT NULL DEFAULT nextval('livro_id_livro_seq'::regclass),
  titulo text,
  autor text,
  estilo text,
  paginas int,
  CONSTRAINT livro_pkey PRIMARY KEY (id)
);

INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Design Patterns com Java - Projeto orientado a objetos guiado por padrões', 'Eduardo Guerra', 'Tecnologia', 334);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Test-Driven Development - Teste e Design no Mundo Real', 'Mauricio Aniche', 'Tecnologia', 194);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Como Se Dar Bem com Quem Você Quer Bem', 'Márcio Mendes', 'Religião', 312);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Novena de Natal 2016', 'Canção Nova', 'Religião', 48);

CREATE TABLE usuario_leu_livros
(
  login text NOT NULL,
  id_livro int NOT NULL,
  CONSTRAINT usuario_leu_livros_pkey PRIMARY KEY (login, id_livro),
  CONSTRAINT usuario_leu_livros_id_livro_fkey FOREIGN KEY (id_livro)
    REFERENCES livro (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_leu_livros_login_fkey FOREIGN KEY (login)
    REFERENCES usuario (login) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);