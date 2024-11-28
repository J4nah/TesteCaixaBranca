# TesteCaixaBranca

<h2> Etapa 3 </h2>

<b> Grafo de Fluxo </b>
<br>
<img src="grafo de Fluxo.jpg" alt="Grafo de fluxo" style="max-width: 100%; height: auto;">

# Análise de Complexidade Ciclomática

A complexidade ciclomática do método `verificarUsuario` foi calculada para avaliar a complexidade estrutural do código. A fórmula utilizada foi:

\[
V(G) = E - N + 2P
\]

Onde:
- **E** é o número de arestas (transições entre blocos de código),
- **N** é o número de nós (blocos de código ou instruções),
- **P** é o número de componentes conexos (geralmente 1, caso o código seja um único bloco de execução).

#### Resultados:
- **Nós (N)**: 6
- **Arestas (E)**: 7
- **Componentes Conexos (P)**: 1

O cálculo da complexidade ciclomática resultou em **3**, o que significa que existem 3 caminhos independentes através do código do método `verificarUsuario`. Isso sugere que o código é relativamente simples e pode ser facilmente testado, mas é importante monitorar áreas de código com maior complexidade para garantir a qualidade e a manutenibilidade.

Este valor é útil para identificar possíveis pontos de refatoração ou áreas do código que podem precisar de mais testes de cobertura.

# Análise de Caminhos - Complexidade Ciclomática

A complexidade ciclomática do método `verificarUsuario` foi calculada como **3**, indicando que existem 3 caminhos independentes possíveis através do código. Abaixo, detalhamos cada um desses caminhos:

### Caminho 1: Nenhum resultado retornado
1. O código se conecta ao banco de dados com `conectarBD()`.
2. A consulta SQL é executada.
3. A condição `if(rs.next())` retorna `false`, indicando que não há resultados para o login e senha fornecidos.
4. O valor de `result` permanece `false`.
5. O método retorna `false`.

### Caminho 2: Login e senha válidos
1. O código se conecta ao banco de dados com `conectarBD()`.
2. A consulta SQL é executada.
3. A condição `if(rs.next())` retorna `true`, indicando que o login e senha são válidos.
4. O valor de `result` é alterado para `true`.
5. A variável `nome` recebe o valor da consulta SQL.
6. O método retorna `true`.

### Caminho 3: Exceção na execução
1. O código se conecta ao banco de dados com `conectarBD()`.
2. A consulta SQL é executada.
3. Se ocorrer uma exceção durante a execução (por exemplo, erro de conexão ou de consulta), o fluxo entra no bloco `catch`.
4. O valor de `result` permanece `false`, já que não houve sucesso na execução da consulta.
5. O método retorna `false`.

Esses caminhos representam as diferentes execuções do método `verificarUsuario`, com base nos resultados da consulta e na possível ocorrência de exceções.

Este detalhe é útil para o processo de testes e manutenção do código, permitindo um entendimento mais claro dos fluxos possíveis dentro do método.

