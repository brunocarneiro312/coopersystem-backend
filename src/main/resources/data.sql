-- CADASTRANDO ROLES
INSERT INTO AUTHORITY (ID, NAME) VALUES (1, 'ROLE_COMUM');
INSERT INTO AUTHORITY (ID, NAME) VALUES (2, 'ROLE_ADMIN');

-- CADASTRANDO USUÁRIOS
INSERT INTO USER(ID, USERNAME, PASSWORD, NOME, CPF, ATIVO) VALUES (1, 'admin', '$2a$10$txX1nALCGpXut8MjHKpOAOqh9HsFHoc/ViTRQL.p.pyMooq6iM9C2', 'Fulano De Tal', '00825346169', true);
INSERT INTO USER(ID, USERNAME, PASSWORD, NOME, CPF, ATIVO) VALUES (2, 'comum', '$2a$10$F340vLyEPt/SotNkVt.w5uNJtUXZp5ukT8BtffOgjXrH.k3qv32p.', 'Ciclano De Tal', '00825347130', true);

-- CADASTRANDO ENDEREÇOS
INSERT INTO ENDERECO(ID, BAIRRO, CEP, CIDADE, COMPLEMENTO, LOGRADOURO, UF) VALUES (1, 'Asa Norte', '70765110', 'Brasília', '102', 'sqn 312 bl k', 'df');
INSERT INTO ENDERECO(ID, BAIRRO, CEP, CIDADE, COMPLEMENTO, LOGRADOURO, UF) VALUES (2, 'Asa Norte', '70765080', 'Brasília', '109', 'sqn 312 bl h', 'df');

-- CADASTRANDO TELEFONES
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(1, '6120022020', 2);
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(2, '6133471304', 1);
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(3, '61985770401', 0);
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(4, '6120027777', 2);
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(5, '6133478829', 1);
INSERT INTO TELEFONE(ID, NUMERO, TIPO_TELEFONE) VALUES(6, '61984185234', 0);

-- CADASTRANDO EMAILS
INSERT INTO EMAIL(ID, EMAIL) VALUES(1, 'fulano.tal@email.com');
INSERT INTO EMAIL(ID, EMAIL) VALUES(2, 'fulano.tal2@email.com');
INSERT INTO EMAIL(ID, EMAIL) VALUES(3, 'ciclano.tal@email.com');
INSERT INTO EMAIL(ID, EMAIL) VALUES(4, 'ciclano.tal2@email.com');

-- ATRIBUINDO ROLES AO USUÁRIOS
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);

-- ATRIBUINDO ENDERECOS AOS USUARIOS
INSERT INTO USER_ENDERECO(ENDERECO_ID, USER_ID) VALUES(1, 1);
INSERT INTO USER_ENDERECO(ENDERECO_ID, USER_ID) VALUES(2, 2);

-- ATRIBUINDO TELEFONES AOS USUÁRIOS
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(1, 1);
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(1, 2);
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(1, 3);
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(2, 4);
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(2, 5);
INSERT INTO USER_TELEFONE(USER_ID, TELEFONE_ID) VALUES(2, 6);

-- ATRIBUINDO EMAILS AOS USUÁRIOS
INSERT INTO USER_EMAIL(USER_ID, EMAIL_ID) VALUES (1, 1);
INSERT INTO USER_EMAIL(USER_ID, EMAIL_ID) VALUES (1, 2);
INSERT INTO USER_EMAIL(USER_ID, EMAIL_ID) VALUES (2, 3);
INSERT INTO USER_EMAIL(USER_ID, EMAIL_ID) VALUES (2, 4);
