# Teste Caixa Branca

---

## Erros encontrados

**- Erro na classe do Driver:** A linha `Class.forName("com.mysql.Driver.Manager").newInstance();` está incorreta. O nome correto é `"com.mysql.cj.jdbc.Driver"`.

**- Falha no tratamento de exceções:** Os blocos `catch (Exception e)` não possuem uma instrução de tratamento ou log, o que dificulta a depuração de erros. É importante logar ou relatar as exceções para facilitar o diagnóstico e evitar falhas silenciosas.

**- Concatenação de strings para SQL:** O uso direto de variáveis no SQL, como em `where login = '" + login + "'`, é vulnerável a SQL Injection. O uso de `PreparedStatement` é mais seguro, pois trata automaticamente os parâmetros inseridos pelo usuário como dados e não como parte da consulta SQL.

**- Fechamento de recursos:** O `Connection`, `Statement` e `ResultSet` não são fechados após o uso, causando potenciais vazamentos de recursos. Para evitar isso, é importante garantir que todos os recursos sejam fechados após a execução das operações de banco de dados, geralmente utilizando o bloco `finally`.

**- Atributos de classe mal definidos:** A variável `public String nome = "";` deve ser `private` ou protegida com `getters` e `setters`. A exposição direta de dados sensíveis viola o princípio de encapsulamento. Além disso, `public boolean result = false;` também deveria ser privado, pois não há necessidade de ser acessível fora da classe. Essas variáveis devem ser usadas apenas dentro do método ou tornadas privadas para proteger a integridade dos dados.

**- Uso inadequado de variáveis públicas:** A variável `nome` está sendo definida como pública, o que permite que ela seja alterada diretamente de qualquer lugar no código. De acordo com as boas práticas de programação orientada a objetos, as variáveis de instância devem ser privadas e protegidas com métodos `getter` e `setter` apropriados.

**- Código não modularizado:** O método `verificarUsuario` está realizando muitas operações, como a construção da consulta SQL e a execução da lógica de verificação, o que viola o princípio da responsabilidade única. É importante modularizar o código para manter a manutenção e a legibilidade mais fáceis.

---

## Correções sugeridas

- **Classe do Driver:** Altere o nome da classe para o driver correto do MySQL: `"com.mysql.cj.jdbc.Driver"`. Isso garante que o driver será carregado corretamente.

- **Tratamento de Exceções:** Adicione uma instrução de log ou rethrow da exceção para garantir que os erros sejam tratados adequadamente. Uma boa prática é usar `e.printStackTrace()` ou logar a exceção em um arquivo de log.

- **SQL Injection:** Substitua a concatenação de strings para construção de consultas SQL por `PreparedStatement`, que ajuda a prevenir SQL Injection.

- **Fechamento de Recursos:** Feche sempre as conexões e recursos após o uso, utilizando o bloco `finally` para garantir que esses recursos sejam liberados corretamente. Exemplo:

  ```java
  finally {
      try {
          if (conn != null) conn.close();
          if (st != null) st.close();
          if (rs != null) rs.close();
      } catch (SQLException e) {
          e.printStackTrace();  // Caso ocorra erro ao fechar os recursos
      }
  }

  ```

- **Atributos de Classe:** Torne as variáveis de instância privadas e forneça getters e setters para permitir um controle mais seguro e eficaz sobre o acesso e modificação dessas variáveis. Exemplo:

  ```java
    private String nome;
    public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
  this.nome = nome;
  }
  ```

- **Uso inadequado de variáveis públicas:** Torne as variáveis de instância privadas e evite acessos diretos. Utilize métodos `getter` e `setter` para fornecer acesso controlado às informações. Além disso, transforme as variáveis que são usadas somente dentro do método `verificarUsuario` em variáveis locais, não sendo necessárias como variáveis de instância.

- **Código não modularizado:** Separe as responsabilidades dentro do código criando métodos específicos para diferentes partes da lógica. Por exemplo, crie métodos separados para conectar ao banco de dados, construir a consulta SQL e verificar o usuário, garantindo que cada método tenha uma responsabilidade única.