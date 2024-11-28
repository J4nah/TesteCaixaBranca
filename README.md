# TesteCaixaBranca

## Análise do Código e Identificação dos Nodos

### Pontos de Entrada e Saída
- **Entrada:** O ponto de entrada é quando o método `verificarUsuario` é chamado.
- **Saída:** O método retorna um valor booleano, indicando se o usuário foi encontrado ou não.

### Nodos de Execução e Decisão
1. **Início do método `verificarUsuario`** – ponto de entrada.
2. **Chamada ao método `conectarBD()`** – tenta se conectar ao banco de dados.
3. **Verificação de sucesso da conexão** (conexão bem-sucedida ou não).
4. **Construção da consulta SQL** – construção dinâmica da string SQL.
5. **Execução da consulta SQL** – tentativa de execução da consulta no banco.
6. **Verificação do resultado da consulta** – se a consulta retorna um valor (se existe um registro).
7. **Atribuição de valores a `result` e `nome`** – se o usuário for encontrado.
8. **Finalização do método** – retorno do valor de `result`.

## Identificação das Arestas (Conexões entre os Nodos)

Agora, vamos identificar como os pontos se conectam (arestas):

- **Entrada → Chamada `conectarBD()`** (executa a tentativa de conexão).
- **Chamada `conectarBD()` → Verificar conexão ao banco** (verifica se a conexão foi bem-sucedida).
  - **Se a conexão falhar → Finaliza o método e retorna `false`.**
  - **Se a conexão for bem-sucedida → Continua para a construção da consulta SQL.**
- **Construção da consulta SQL → Execução da consulta SQL** (constrói a query e a executa).
- **Execução da consulta SQL → Verificação do resultado** (checa se a consulta retorna algum resultado).
  - **Se não houver resultados → Finaliza o método e retorna `false`.**
  - **Se houver resultados → Atribui valores a `result` e `nome`.**
- **Atribuição de valores → Finaliza o método e retorna `result`.**

## Grafo de Fluxo

Agora, com base nos pontos e conexões, o grafo de fluxo seria representado assim:


<img src="grafo de fluxo.drawio.png" alt="Grafo de fluxo" style="max-width: 100%; height: auto;">

## Cálculo da Complexidade Ciclomática

A complexidade ciclomática (M) é dada pela fórmula:

$$
M = E - N + 2P
$$

Onde:
- **E** = número de arestas.
- **N** = número de nodos.
- **P** = número de componentes conectados (geralmente 1 para grafos conectados).

### Contagem de Nodos e Arestas
- **Nodos (N):** Temos 9 nodos.
- **Arestas (E):** Temos 10 arestas.
- **Componentes (P):** 1 (grafo conectado).

### Aplicando a Fórmula

Aplicamos a fórmula para calcular a complexidade ciclomática:

$$
M = 10 - 9 + 2(1) = 3
$$

Portanto, a complexidade ciclomática do código é **3**.

## Identificação dos Caminhos e Sequências

Com a complexidade ciclomática sendo 3, significa que o código possui 3 caminhos independentes. Vamos identificar e descrever esses caminhos:

### Caminho 1: Conexão bem-sucedida e resultado encontrado
1. A conexão ao banco de dados é bem-sucedida.
2. A consulta SQL é executada.
3. A consulta retorna resultados.
4. Os valores de `result` e `nome` são atribuídos.
5. O método retorna `true`.

### Caminho 2: Conexão bem-sucedida, mas sem resultados
1. A conexão ao banco de dados é bem-sucedida.
2. A consulta SQL é executada.
3. A consulta não retorna resultados.
4. O método retorna `false`.

### Caminho 3: Falha na conexão
1. A conexão ao banco de dados falha.
2. O método retorna `false`.