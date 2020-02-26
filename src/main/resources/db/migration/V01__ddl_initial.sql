
CREATE TABLE public.t_condominio (
  id bigserial NOT NULL,
  email varchar(255) NULL,
  nome varchar(255) NULL,
  telefone varchar(255) NULL,
  CONSTRAINT t_condominio_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_aviso_condominio (
  id bigserial NOT NULL,
  descricao_aviso varchar(255) NULL,
  id_condominio bigint NULL,
  CONSTRAINT t_aviso_condominio_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_unidade (
  id bigserial NOT NULL,
  id_condominio bigint NOT NULL,
  cpf_responsavel varchar(14) NULL,
  bloco_unidade varchar(255) NULL,
  numero_unidade varchar(255) NULL,
  UNIQUE(bloco_unidade, numero_unidade),
  CONSTRAINT t_unidade_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_aviso_unidade (
  id bigserial NOT NULL,
  descricao_aviso varchar(255) NULL,
  id_unidade bigint NULL,
  CONSTRAINT t_aviso_pkey PRIMARY KEY (id)
);

CREATE TABLE public.t_multa (
  id bigserial NOT NULL,
  data_multa date NULL,
  descricao_multa varchar(255) NULL,
  valor_multa numeric(19,2) NULL,
  id_unidade bigint NULL,
  CONSTRAINT t_multa_pkey PRIMARY KEY (id)
);


ALTER TABLE public.t_aviso_condominio ADD CONSTRAINT fk_avisos_condominio_condominio_id FOREIGN KEY (id_condominio) REFERENCES t_condominio(id);
ALTER TABLE public.t_aviso_unidade ADD CONSTRAINT fk_avisos_unidade_unidade_id FOREIGN KEY (id_unidade) REFERENCES t_unidade(id);

ALTER TABLE public.t_unidade ADD CONSTRAINT fk_unidade_condominio_id FOREIGN KEY (id_condominio) REFERENCES t_condominio(id);
ALTER TABLE public.t_multa ADD CONSTRAINT fk_multa_unidade_id FOREIGN KEY (id_unidade) REFERENCES t_unidade(id);


-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
  INCREMENT BY 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1
  NO CYCLE;
