Desafio - Sistema de AutoAtendimento

Este é um sistema de autoatendimento para uma lanchonete Fast Food. Os clientes podem escolher entre lanches e bebidas, adicioná-los ao carrinho, editar itens no carrinho, efetuar o pagamento e finalizar o pedido.

Classes e Data Classes

No Data Class Item Lanche Foi atribuído variáveis 
Nome: String - Nome do lanche.
Quantidade: Int - Quantidade do lanche a ser adicionado ao carrinho.
Valor Unitário: Double - Valor unitário do lanche.

No Data Class Item Bebida 
Nome : String - Nome da bebida.
Quantidade : Int - Quantidade da bebida a ser adicionada ao carrinho.
Valor Unitário:: Double - Valor unitário da bebida.

AutoAtendimento
A classe AutoAtendimento é responsável por gerenciar o processo de autoatendimento, incluindo as funcionalidades de adicionar lanches e bebidas ao carrinho, editar itens do carrinho, efetuar o pagamento e finalizar o pedido.


Métodos:
Lanche: Permite ao cliente escolher lanches e adicioná-los ao carrinho.
Bebidas: Permite ao cliente escolher bebidas e adicioná-las ao carrinho.
Remover itens:  Permite ao cliente remover itens do carrinho.
Efetuar Pagamento Permite ao cliente efetuar o pagamento dos itens do carrinho.
Editar Item:  Permite ao cliente editar os itens do carrinho.
Ler Inteiro:  Função auxiliar para ler valores inteiros digitados pelo usuário.
Finalizar: Permite ao cliente finalizar o pedido e sair do sistema.

Menu
A classe Menu exibe o menu inicial para o cliente e gerencia o fluxo do programa.

Exibe o menu inicial e permite ao cliente escolher entre lanches e bebidas.

 Funcionamento

Ao iniciar o programa, o cliente é apresentado ao menu inicial, onde pode escolher entre lanches e bebidas. Dependendo da escolha, o cliente é redirecionado para as funcionalidades correspondentes no `AutoAtendimento`. Ele pode adicionar itens ao carrinho, editar os itens existentes, remover itens do carrinho e efetuar o pagamento.

Após finalizar o pedido e efetuar o pagamento, o cliente pode escolher se deseja retornar ao menu inicial para fazer um novo pedido ou sair do programa.
Observações

- Para utilizar o programa, o cliente deve digitar o número da opção desejada para escolher um item ou executar uma ação.
- Caso o cliente digite uma opção inválida, o programa exibirá uma mensagem de aviso e retornará ao menu correspondente.
- As listas “Xburguer”, “Xsalada”, “refrigerante”, “suco” e “pagar” são usadas para armazenar os itens selecionados e seus respectivos valores para o cálculo do pagamento.


