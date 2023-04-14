insert into cozinha (id, nome) values (1, 'Brasileira');
insert into cozinha (id, nome) values (2, 'Quebècois');
insert into cozinha (id, nome) values (3, 'Americana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Flor da Goiabeira', '2.0', 1);

insert into cidade (id, nome) values (1, 'Sherbrooke');
insert into cidade (id, nome) values (2, 'East Angus');
insert into cidade (id, nome) values (3, 'Weedon');

insert into forma_de_pagamento (id, descricao) values (1, 'Cartão de crédito');
insert into forma_de_pagamento (id, descricao) values (2, 'Cartão de débito');
insert into forma_de_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'Desjardins', 'Pemitido');