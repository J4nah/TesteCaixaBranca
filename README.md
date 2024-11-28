# TesteCaixaBranca
<hr>
<h2> Erros encontrados</h2>
<b> - Erro na classe do Driver: </b> A linha <code>Class.forName("com.mysql.Driver.Manager").newInstance();</code>está incorreta. O nome correto é <code>"com.mysql.cj.jdbc.Driver"</code>.<br>
<b> - Falha no tratamento de exceções:</b> Os blocos <code>catch (Exception e)</code> não possuem uma instrução de tratamento ou log, o que dificulta a depuração de erros.<br>
<b> - Concatenação de strings para SQL: </b>: O uso direto de variáveis no SQL <code>(where login = '" + login + "')</code> é vulnerável a SQL Injection. O uso de <code>PreparedStatement</code> é mais seguro.<br>
<b>Fechamento de recursos:</b> O <code>Connection</code>, <code>Statement</code> e <code>ResultSet</code> não são fechados, causando potenciais vazamentos de recursos.<br>
<b> - Atributos de classe mal definidos: </b> <code>public String nome = "";</code> deve ser <code>private</code> ou protegido com <code>getters</code> e <code>setters</code>.<br>
<code>public boolean result = false;</code> também deveria ser privado.<br>
<b> - Erros de organização:</b> Faltam comentários explicativos e JavaDocs para os métodos e atributos.