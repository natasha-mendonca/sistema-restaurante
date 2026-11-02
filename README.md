# Sistema de Restaurante

Sistema de console em Java para registrar pedidos de lanches de uma lanchonete, com personalização de ingredientes,
adicionais, modificação de pedidos e fechamento do dia.

Projeto 1 do curso de Java + IA - ElasTech.

## Tecnologias

- Java 17
- Maven
- JUnit 5

## Como executar

1. Abra o projeto no IntelliJ IDEA.
2. Execute a classe `Main`, em `src/main/java/br/com/natasha/restaurante/app/Main.java`.
3. Use o menu no console digitando o número da opção desejada.

Para rodar os testes, clique com o botão direito na pasta `src/test/java` e escolha **Run 'All Tests'**.

## Funcionalidades

| Item | Funcionalidade                                                                              |
|------|---------------------------------------------------------------------------------------------|
| 1.1  | Cadastro de lanches com nome e preço, com validação (nome não vazio, preço não negativo)    |
| 1.2  | Pedido com número, nome do cliente, lista de itens e cálculo do total                       |
| 1.3  | Gerenciamento dos pedidos do dia com `HashMap`, com número gerado automaticamente           |
| 1.4  | Menu no console para registrar pedidos, listar pedidos e fechar o dia                       |
| 1.5  | `Main` usando o sistema pela Facade                                                         |
| 2.1  | Facade entre o menu e as regras de negócio                                                  |
| 2.2  | Factory para criar os lanches do cardápio                                                   |
| 2.3  | Adicionais (cheddar e bacon extra) com Decorator                                            |
| 2.4  | Testes automatizados com JUnit                                                              |
| 3.1  | Retirar ingredientes do lanche (queijo, alface, tomate, cebola), sem alterar o preço        |
| 3.2  | Modificar pedido: acrescentar item, remover item ou cancelar o pedido inteiro               |
| 3.3  | Fechamento do dia com a quantidade e a lista de combinações diferentes vendidas (`HashSet`) |
| 3.4  | Tratamento de entrada inválida: digitar letras onde se espera número não encerra o sistema  |

## Cardápio

| Lanche                 | Preço     |
|------------------------|-----------|
| X-Burger               | R$ 16,00  |
| X-Salada               | R$ 18,00  |
| X-Bacon                | R$ 22,00  |
| Adicional: cheddar     | + R$ 4,00 |
| Adicional: bacon extra | + R$ 6,00 |

## Organização dos pacotes

```
br.com.natasha.restaurante
├── app        → interação com o usuário e ponto de entrada (Main, MenuConsole, RestauranteFacade)
├── cardapio   → itens vendidos (ItemCardapio, Lanche, LancheFactory, ComCheddar, ComBaconExtra)
└── pedido     → regras dos pedidos (Pedido, GerenciadorPedidos)
```

Cada pacote tem uma responsabilidade: o `app` cuida da tela, o `cardapio` cuida do que é vendido e o `pedido` cuida dos
pedidos e do total do dia. As classes de negócio não leem nem imprimem nada no console.

## Padrões de projeto

- **Facade** (`RestauranteFacade`): o `Main` conversa só com a Facade, que repassa o trabalho para o
  `GerenciadorPedidos` e para o cardápio. Assim, o `Main` não precisa conhecer todas as classes do sistema.
- **Factory** (`LancheFactory`): centraliza a criação dos lanches do cardápio. Nome e preço ficam em um único lugar.
- **Decorator** (`ComCheddar`, `ComBaconExtra`): cada adicional "embrulha" um item e acrescenta preço e descrição,
  permitindo combinar adicionais sem criar uma classe para cada combinação.

## Testes

- `LancheTest`: verifica que criar um lanche com preço negativo lança `IllegalArgumentException`.
- `ComCheddarTest`: verifica que um X-Bacon com cheddar custa R$ 26,00.

## Observação sobre as combinações

No fechamento, `X-Bacon + cheddar + bacon extra` e `X-Bacon + bacon extra + cheddar` seriam contados como combinações
diferentes, porque o `HashSet` compara os textos das descrições. No sistema atual isso não acontece, porque o menu
sempre pergunta o cheddar antes do bacon extra, e a ordem é sempre a mesma.

## Vídeo

[Assistir ao vídeo](https://drive.google.com/file/d/1129dcwplqigYTbgYprRL0orPu9hgcJik/view?usp=sharing)