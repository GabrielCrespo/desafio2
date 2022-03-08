INSERT INTO public.pessoas (cpf, data_nascimento, nome) VALUES('93714079050', '1996-04-26', 'Super-Homem');
INSERT INTO public.pessoas (cpf, data_nascimento, nome) VALUES('16955904060', '1990-10-12', 'Homem-Aranha');
INSERT INTO public.pessoas (cpf, data_nascimento, nome) VALUES('50817262067', '1988-09-01', 'Mulher-Maravilha');
INSERT INTO public.pessoas (cpf, data_nascimento, nome) VALUES('88775300060', '1970-10-22', 'Capitão América');
INSERT INTO public.pessoas (cpf, data_nascimento, nome) VALUES('78366446000', '1985-05-03', 'Capitã Marvel');

INSERT INTO public.contas (data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta, id_pessoa) VALUES('2021-03-14', true, 500, 0, 0, 1);
INSERT INTO public.contas (data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta, id_pessoa) VALUES('2022-02-03', false, 400, 0, 0, 2);
INSERT INTO public.contas (data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta, id_pessoa) VALUES('2021-10-19', true, 200, 0, 1, 3);
INSERT INTO public.contas (data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta, id_pessoa) VALUES('2022-01-29', false, 1000, 0, 2, 4);
INSERT INTO public.contas (data_criacao, flag_ativo, limite_saque_diario, saldo, tipo_conta, id_pessoa) VALUES('2021-07-05', true, 300, 0, 2, 5);

INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-11', 'Consulta', 0, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-12', 'Saque', 10, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-13', 'Saque', 50, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-14', 'Depósito', 100, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-15', 'Consulta', 0, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-16', 'Saque', 10.50, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-17', 'Consulta', 0, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-18', 'Saque', 100, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-19', 'Depósito', 25, 1);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-20', 'Depósito', 76, 1);


INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-03-11', 'Consulta', 0, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-03-12', 'Saque', 10, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-03-13', 'Saque', 50, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-03-14', 'Depósito', 100, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-03-15', 'Consulta', 0, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-04-16', 'Saque', 10.50, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-04-17', 'Consulta', 0, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-04-18', 'Saque', 100, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-04-19', 'Depósito', 25, 2);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-05-20', 'Depósito', 76, 2);

INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-10-11', 'Consulta', 0, 3);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-10-12', 'Saque', 10, 3);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-10-13', 'Saque', 50, 3);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-10-14', 'Depósito', 100, 3);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-10-15', 'Consulta', 0, 3);

INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-07-01', 'Consulta', 0, 4);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-07-02', 'Saque', 10, 4);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-07-03', 'Saque', 50, 4);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-07-04', 'Depósito', 100, 4);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-07-05', 'Consulta', 0, 4);

INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-12-01', 'Consulta', 0, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-12-02', 'Saque', 10, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-12-03', 'Saque', 50, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-12-04', 'Depósito', 100, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2021-12-05', 'Consulta', 0, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-11', 'Consulta', 0, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-12', 'Saque', 10, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-13', 'Saque', 50, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-14', 'Depósito', 100, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-01-15', 'Consulta', 0, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-16', 'Saque', 10.50, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-17', 'Consulta', 0, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-18', 'Saque', 100, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-19', 'Depósito', 25, 5);
INSERT INTO public.transacoes ("data", descricao, valor, id_conta) VALUES('2022-02-20', 'Depósito', 76, 5);