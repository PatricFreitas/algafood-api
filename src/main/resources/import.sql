insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
insert into permissao (id, nome, descricao) values (3, 'CONSULTAR_PRODUTOS', 'Permite consultar produtos');
insert into permissao (id, nome, descricao) values (4, 'EDITAR_PRODUTOS', 'Permite editar produtos');
insert into permissao (id, nome, descricao) values (5, 'CONSULTAR_RESTAURANTES', 'Permite consultar restaurantes');
insert into permissao (id, nome, descricao) values (6, 'EDITAR_RESTAURANTES', 'Permite editar restaurantes');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);


insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (1, 'Pão Suiço', 'Pão Suiço na chapa quente', 1.45, true, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (2, 'Pão de Queijo', 'Pão de queijo mineiro', 3.00, true, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (3, 'Pão Francês', 'Pão francês feito no Brasil', 1.00, true, 2);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (4, 'Pão de Forma', 'Pão de forma para misto quente', 4.99, true, 2);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (5, 'Pão Sovado', 'Pão sovado 250g', 3.70, true, 3);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (6, 'Pão de Mel', 'Pão de mel freso', 2.25, true, 3);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (7, 'Pão de Milho', "Pão com pedaços de milho", 1.80, true, 3);

insert into grupo (id, nome) values (1, 'Administrador');
insert into grupo (id, nome) values (2, 'Usuário');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1);
insert into grupo_permissao (grupo_id, permissao_id) values (1, 2);
insert into grupo_permissao (grupo_id, permissao_id) values (1, 3);
insert into grupo_permissao (grupo_id, permissao_id) values (1, 4);
insert into grupo_permissao (grupo_id, permissao_id) values (1, 5);
insert into grupo_permissao (grupo_id, permissao_id) values (1, 6);
insert into grupo_permissao (grupo_id, permissao_id) values (2, 1);
insert into grupo_permissao (grupo_id, permissao_id) values (2, 3);
insert into grupo_permissao (grupo_id, permissao_id) values (2, 5);

insert into usuario(id, data_cadastro, nome, email, senha) values (1, now(), 'Patric Freitas', 'patrifreitas@algafood.com', '123');
insert into usuario(id, data_cadastro, nome, email, senha) values (2, now(), 'José das Couves', 'josecouves@algafood.com', '123');

insert into usuario_grupo(usuario_id, grupo_id) values (1, 1);
insert into usuario_grupo(usuario_id, grupo_id) values (2, 2);
