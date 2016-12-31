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

INSERT INTO livro VALUES (1, 'Design Patterns com Java - Projeto orientado a objetos guiado por padrões', 'Eduardo Guerra', 'Tecnologia', 334);
INSERT INTO livro VALUES (1, 'Test-Driven Development - Teste e Design no Mundo Real', 'Mauricio Aniche', 'Tecnologia', 194);
INSERT INTO livro VALUES (1, 'Como Se Dar Bem com Quem Você Quer Bem', 'Márcio Mendes', 'Religião', 312);
INSERT INTO livro VALUES (1, 'Novena de Natal 2016', 'Canção Nova', 'Religião', 48);