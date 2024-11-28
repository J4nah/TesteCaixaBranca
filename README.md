# Teste de Caixa Branca - Projeto de Análise e Testes

Este repositório contém um projeto focado na realização de testes de caixa branca em um sistema de login implementado com Java, com conexão a um banco de dados MySQL. O objetivo principal é realizar uma análise estática do código, calcular a complexidade ciclomática e gerar a documentação do código utilizando a ferramenta Javadoc.

## Objetivo do Projeto

O objetivo deste repositório é realizar as seguintes atividades:

- **Análise Estática do Código**: Examinar o código-fonte para identificar problemas potenciais como falta de documentação, mau uso de estruturas, ou erros de lógica.
- **Cálculo da Complexidade Ciclomática**: Avaliar a complexidade do código com base nas decisões e caminhos possíveis no fluxo do programa.
- **Documentação com Javadoc**: Gerar uma documentação técnica utilizando Javadoc, com foco na clareza e compreensão do código, descrevendo as classes, métodos e variáveis utilizadas no sistema.
- **Testes de Caixa Branca**: Realizar testes com foco em garantir a cobertura de código, análise de loops, condições de parada e tratamento de exceções.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

### Código

O código consiste em uma classe Java que realiza a verificação de usuários em um banco de dados MySQL. Ele se conecta ao banco e verifica se o login e senha fornecidos são válidos, retornando o nome do usuário caso a autenticação seja bem-sucedida.

### Testes

O projeto inclui os seguintes tipos de testes:

- **Testes de Verificação de Erros**: Análise de falhas e problemas no código, como falta de tratamento de exceções e erros lógicos.
- **Cálculo da Complexidade Ciclomática**: Cálculo realizado para avaliar o número de decisões e caminhos possíveis no código, com o objetivo de identificar a complexidade do fluxo de execução.
- **Testes de Caixa Branca**: Testes realizados para validar a cobertura de código, condição de loops e a integridade do tratamento de exceções.

## Etapas Realizadas

### 1. Análise Estática do Código

Foi realizada uma análise estática do código, onde se verificaram possíveis problemas como:

- Falta de documentação no código.
- Uso inadequado de estruturas de controle (por exemplo, loops infinitos ou condições sem verificação).
- Arquitetura do código, identificando problemas relacionados à abertura de conexões com o banco de dados fora da camada apropriada.

### 2. Cálculo da Complexidade Ciclomática

Foi realizada a análise de complexidade ciclomática do código, identificando o número de caminhos possíveis através das decisões condicionais e laços de repetição no código. O objetivo é avaliar a complexidade do sistema e melhorar a manutenção futura.

A complexidade foi calculada utilizando as métricas de número de decisões e o grafo de fluxo, que visualiza todos os caminhos possíveis que o código pode seguir durante sua execução.

### 3. Geração da Documentação Javadoc

O código foi documentado utilizando Javadoc para fornecer uma descrição clara das classes, métodos e variáveis. O Javadoc é uma ferramenta que permite gerar documentação técnica automaticamente, facilitando a compreensão do código e a manutenção do sistema.

### 4. Testes de Caixa Branca

Foram realizados testes para verificar a cobertura de código e as possíveis falhas no sistema. A análise focou em:

- **Cobertura de Código**: Garantir que todas as partes do código sejam executadas durante os testes.
- **Condições de Loop**: Verificar se todos os loops têm uma condição de parada adequada.
- **Tratamento de Exceções**: Certificar-se de que todas as exceções possíveis sejam tratadas corretamente.
