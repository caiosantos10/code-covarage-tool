# Code-Coverage-Tool
 Protótipo de ferramenta que mede cobertura de comando

### Pacotes
code- Classes de código a ser analisado  
code/test - Testes de unidade  
Coverage - Contém classe MAIN que executa a analise

### Tutorial
1 - Execute a classe Main.
2 - Classes instrumentadas serão criadas no pacote "target"
3 - Essas classes novas serão utilizadas no TriangleTest.
4 - Execute a classe de teste TriangleTest.

### Bugs
As classes criadas dentro de "target" são referenciadas com nome de pacote errado, 
é necessário corrigir manualmente após a execução da classe Main.
