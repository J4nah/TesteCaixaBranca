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
