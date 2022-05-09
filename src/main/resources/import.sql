insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');


insert into restaurante (nome, taxa_frete, cozinha_id) values ('Capixaba', 1.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Le vieux Quebec', 4.50, 1);

insert into forma_pagamento (descricao) values ('Cartão de crédito');
insert into forma_pagamento (descricao) values ('Transferência Bancária');

insert into permissao (nome, descricao) values ('Permitido', 'Cartão de crédito');
insert into permissao (nome, descricao) values ('Não autorizado','Transferência' );

insert into estado (nome) values ('Québec');
insert into estado (nome) values ('Ottawa');

insert into cidade (nome, estado_id) values ('Sherbrooke', 1);
insert into cidade (nome, estado_id) values ('Québec', 1);



