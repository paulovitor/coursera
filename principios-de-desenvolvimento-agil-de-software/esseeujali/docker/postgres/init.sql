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
INSERT INTO usuario (login, email, nome, senha, pontos) VALUES ('maria', 'maria@coursera.org', 'Maria', 'maria', 0);
INSERT INTO usuario (login, email, nome, senha, pontos) VALUES ('jose', 'jose@coursera.org', 'José', 'jose', 0);

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
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Test-Driven Development - Teste e Design no Mundo Real', 'Caio Ribeiro Pereira', 'Tecnologia', 194);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Aplicações web real-time com Node.js', 'Mauricio Aniche', 'Tecnologia', 161);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Controlando versões com Git e GitHub', 'Alexandre Aquiles, Rodrigo Ferreira', 'Tecnologia', 204);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('DevOps na prática - entrega de software confiável e automatizada', 'Danilo Sato', 'Tecnologia', 248);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Como Se Dar Bem com Quem Você Quer Bem', 'Márcio Mendes', 'Religião', 312);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Novena de Natal 2016', 'Canção Nova', 'Religião', 48);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Preparai o caminho do Senhor', 'Monsenhor Jonas Abib', 'Religião', 144);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('O Nome de Deus é Misericórdia', 'Papa Francisco', 'Religião', 142);
INSERT INTO livro (titulo, autor, estilo, paginas) VALUES ('Cura dos Traumas da Morte', 'Padre Leo', 'Religião', 136);

CREATE TABLE usuario_leu_livros
(
  login text NOT NULL,
  id_livro int NOT NULL,
  CONSTRAINT usuario_leu_livros_pkey PRIMARY KEY (login, id_livro),
  CONSTRAINT usuario_leu_livros_login_fkey FOREIGN KEY (login)
    REFERENCES usuario (login) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_leu_livros_id_livro_fkey FOREIGN KEY (id_livro)
    REFERENCES livro (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE usuario_tem_trofeus
(
  login text NOT NULL,
  estilo text NOT NULL,
  CONSTRAINT usuario_tem_trofeus_pkey PRIMARY KEY (login, estilo),
  CONSTRAINT usuario_tem_trofeus_login_fkey FOREIGN KEY (login)
    REFERENCES usuario (login) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);