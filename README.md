
# Tech Challenge - FIAP
Projeto da Pós Tech da FIAP em Software Architecture

## Autoras

✨ [@leonaraqm](https://github.com/leonara) | [@alinedonatoc](https://github.com/alinedonatoc) | [@assouza19](https://github.com/assouza19) ✨

## Descrição do Projeto
Este módulo é responsável pela aplicação de Pedido do nosso sistema de lanchonete.

## Funcionalidades

- CRUD Produto;
- CRUD Cliente;
- CRUD Pedido;
- Listagem de pedidos - visão cliente;
- Listagem de pedidos em produção;

## Arquitetura

### Padrão SAGA - Orquestração
Padrão Escolhido: Orquestração

- Necessidade de Controle Centralizado:
Gestão de Fluxo de Trabalho: O processo de realizar um pedido, efetuar pagamento, acompanhar o status e atualizar o status do pedido envolve várias etapas interligadas que precisam ser coordenadas de forma sequencial. A orquestração fornece um controle centralizado, garantindo que cada etapa seja executada na ordem correta.
Notificações ao Cliente: A orquestração permite um ponto centralizado para enviar notificações ao cliente sobre o status do pedido, assegurando que as notificações sejam enviadas de forma consistente e oportuna.
Facilidade de Implementação e Manutenção:

- Simplicidade no Desenvolvimento: 
A orquestração reduz a complexidade nos serviços individuais, uma vez que cada serviço não precisa conhecer o fluxo completo da transação. Isso facilita o desenvolvimento e a manutenção do sistema.
Depuração e Monitoramento: A orquestração centraliza o fluxo de transação, facilitando a depuração e o monitoramento do sistema. Isso é crucial para garantir uma experiência de usuário consistente e resolver problemas rapidamente.
Coordenação de Tarefas Complexas:

- Pagamento e Verificação de Pedido: 
A realização de um pedido envolve a verificação do pagamento, que deve ser coordenada centralmente. A orquestração garante que o pagamento seja processado antes de confirmar o pedido e iniciar a preparação.
Status do Pedido: A atualização do status do pedido e a comunicação dessa atualização ao cliente são processos que beneficiam de uma coordenação centralizada para garantir a precisão e a consistência das informações.
Conformidade e Segurança:

- Cadastro de Clientes:
A coleta de dados pessoais (CPF e email) requer medidas rigorosas de conformidade com a LGPD. A orquestração pode centralizar a verificação e o armazenamento seguro desses dados, garantindo a conformidade com as regulamentações de proteção de dados.

  
![Diagrama](https://iili.io/JiJntae.md.png)

## Code Coverage
![Diagrama](https://iili.io/JiHOW7t.md.png)
