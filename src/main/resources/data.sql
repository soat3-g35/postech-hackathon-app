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