INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
  (1, 'Maria', '3221', 'Pediatra', 'Rua Teste, 401')
  ON CONFLICT DO NOTHING;
INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
  (2, 'Luiz', '3222', 'Pediatra', 'Rua Teste, 402')
  ON CONFLICT DO NOTHING;
INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
  (3, 'José', '3223', 'Pediatra', 'Rua Teste, 403')
  ON CONFLICT DO NOTHING;
INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
  (4, 'Augusto', '3224', 'Pediatra', 'Rua Teste, 404')
  ON CONFLICT DO NOTHING;
INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
   (5, 'Efigenia', '3225', 'Pediatra', 'Rua Teste, 405')
   ON CONFLICT DO NOTHING;
INSERT INTO medico(id, nome, crm, especialidade, endereco)
VALUES
   (6, 'Josué', '3226', 'Cardiologista', 'Rua Teste, 406')
   ON CONFLICT DO NOTHING;
----------------------- PACIENTE
INSERT INTO paciente(id, nome, email, cpf, endereco)
VALUES
  (1, 'Maria', 'maria@gmail.com', '11111111111', 'Rua Teste, 401')
  ON CONFLICT DO NOTHING;
INSERT INTO paciente(id, nome, email, cpf, endereco)
VALUES
  (2, 'Jonas', 'jonas@gmail.com', '2222222222', 'Rua Teste, 402')
  ON CONFLICT DO NOTHING;
INSERT INTO paciente(id, nome, email, cpf, endereco)
VALUES
  (3, 'Eliomar', 'eliomar@gmail.com', '3333333333', 'Rua Teste, 403')
  ON CONFLICT DO NOTHING;
INSERT INTO paciente(id, nome, email, cpf, endereco)
VALUES
  (4, 'Joice', 'joice@gmail.com', '4444444444', 'Rua Teste, 404')
  ON CONFLICT DO NOTHING;
INSERT INTO paciente(id, nome, email, cpf, endereco)
VALUES
  (5, 'Alana', 'alana@gmail.com', '5555555555', 'Rua Teste, 405')
  ON CONFLICT DO NOTHING;