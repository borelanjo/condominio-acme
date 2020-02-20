
-- Drop table

-- DROP TABLE public.tb_area_comum;

CREATE TABLE public.tb_area_comum (
  id int8 NOT NULL,
  codigo int4 NULL,
  descricao varchar(255) NULL,
  CONSTRAINT tb_area_comum_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_condominio;

CREATE TABLE public.tb_condominio (
  id int8 NOT NULL,
  email varchar(255) NULL,
  nome varchar(255) NULL,
  telefone varchar(255) NULL,
  CONSTRAINT tb_condominio_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_avisos;

CREATE TABLE public.tb_avisos (
  id int8 NOT NULL,
  descricao_aviso varchar(255) NULL,
  id_condominio int8 NULL,
  CONSTRAINT tb_avisos_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_condominio_avisos;

CREATE TABLE public.tb_condominio_avisos (
  condominio_id int8 NOT NULL,
  avisos_id int8 NOT NULL,
  CONSTRAINT tb_condominio_avisos_pkey PRIMARY KEY (condominio_id, avisos_id),
  CONSTRAINT uk_bl9neb6ci6s2cpmc4ctbnd509 UNIQUE (avisos_id)
);

-- Drop table

-- DROP TABLE public.tb_endereco;

CREATE TABLE public.tb_endereco (
  id int8 NOT NULL,
  cep varchar(255) NULL,
  cidade varchar(255) NULL,
  rua varchar(255) NULL,
  id_condominio int8 NULL,
  CONSTRAINT tb_endereco_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_responsavel;

CREATE TABLE public.tb_responsavel (
  id int8 NOT NULL,
  email varchar(255) NULL,
  nome varchar(255) NULL,
  telefone varchar(255) NULL,
  bloco_unidade varchar(255) NULL,
  numero_unidade varchar(255) NULL,
  id_responsavel int8 NULL,
  CONSTRAINT tb_responsavel_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_multas;

CREATE TABLE public.tb_multas (
  id int8 NOT NULL,
  data_multa date NULL,
  descricao_multa varchar(255) NULL,
  valor_multa numeric(19,2) NULL,
  id_condominio int8 NULL,
  id_unidade int8 NULL,
  CONSTRAINT tb_multas_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_reclamacao;

CREATE TABLE public.tb_reclamacao (
  id int8 NOT NULL,
  data_reclamacao date NULL,
  descricao_reclamacao varchar(255) NULL,
  id_responsavel int8 NULL,
  CONSTRAINT tb_reclamacao_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.tb_reserva;

CREATE TABLE public.tb_reserva (
  id int8 NOT NULL,
  data_reserva date NULL,
  fim_reserva timestamp NULL,
  inicio_reserva timestamp NULL,
  id_area_comum int8 NULL,
  id_responsavel int8 NULL,
  CONSTRAINT tb_reserva_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tb_avisos ADD CONSTRAINT fk1fbc3o28g63m2khkpu3f4s1sy FOREIGN KEY (id_condominio) REFERENCES tb_condominio(id);
ALTER TABLE public.tb_condominio_avisos ADD CONSTRAINT fkcc5uorqjak6y8jswqf5m4fhae FOREIGN KEY (condominio_id) REFERENCES tb_condominio(id);
ALTER TABLE public.tb_condominio_avisos ADD CONSTRAINT fkoxxduxuotm6ak36anw85g6ih1 FOREIGN KEY (avisos_id) REFERENCES tb_avisos(id);
ALTER TABLE public.tb_endereco ADD CONSTRAINT fkqqv8dvm5lcqm8bdlcyjyf5e76 FOREIGN KEY (id_condominio) REFERENCES tb_condominio(id);
ALTER TABLE public.tb_responsavel ADD CONSTRAINT fkkpuu5n1vhg8ucpcvs6bsaiqnf FOREIGN KEY (id_responsavel) REFERENCES tb_responsavel(id);
ALTER TABLE public.tb_multas ADD CONSTRAINT fk4sv502dohgrsts396fdcjmxav FOREIGN KEY (id_unidade) REFERENCES tb_responsavel(id);
ALTER TABLE public.tb_multas ADD CONSTRAINT fkt4ksw5h1lki9eoo25taku31ad FOREIGN KEY (id_condominio) REFERENCES tb_condominio(id);
ALTER TABLE public.tb_reclamacao ADD CONSTRAINT fkp0twyugeraeesqaaphpp1jwe2 FOREIGN KEY (id_responsavel) REFERENCES tb_responsavel(id);
ALTER TABLE public.tb_reserva ADD CONSTRAINT fk590c0vnqss46ua8ws4mxq9pkk FOREIGN KEY (id_area_comum) REFERENCES tb_area_comum(id);
ALTER TABLE public.tb_reserva ADD CONSTRAINT fkiu1sf9nk93my36n23vix4lj4h FOREIGN KEY (id_responsavel) REFERENCES tb_responsavel(id);