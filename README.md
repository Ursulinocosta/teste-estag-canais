---------------------------------------------------------------------------------------------------------------------------------------

## Instruções (dicas) para testar a aplicação 

### Interagindo com a inteface:
- Executar o código fonte (AgenciaBancaria).
- Primeiro crie duas contas. Com nome, CPF e e-mail, elas serão inumeradas de acordo com a ordem de criação, exemplo: conta 1, conta 2 conta 3...
- Deposite um valor alto em uma das contas para facilitar na hora dos testes.
- Faça as transferências e valide os valores desejados. (os valores passam de uma conta para outra).
- Para acompanhar cada teste é possível validar as ações realizadas com a OPÇÃO 7 - LISTAR AÇÕES.


-------------------------------------------------------------------------------------------------------------------------------------

1. Toda transferência deverá ser feita entre um emissor e um receptor;
2. Operador e receptor iniciam a operação com um saldo de R$ 0,00;
3. As transferências deverão ser executadas de acordo com o seu tipo, sendo 3 os seus tipos: PIX, TED e DOC;
4. O limite de valor máximo permitido para uma transferência via PIX é de R$ 5 mil; 
5. Transferências via TED só são permitidas para valores acima de R$ 5 mil e até R$ 10 mil; 
6. Transferências via DOC só são permitidas para valores acima de R$ 10 mil; 
7. Não serão permitidas transferências para a mesma conta, mas um emissor pode transferir para ele mesmo se for uma conta diferente;
8. As entradas deverão estar sempre com todos os dados preenchidos.

Ao final da operação, uma mensagem deverá ser exibida: 

1. Se a transferência for bem sucedida, exibir mensagem de sucesso com o saldo do emissor e do receptor após a transferência, de acordo com o modelo:

**Sua transferência foi realizada com sucesso!<br> 
Saldo do emissor: R$ X,XX<br>
Saldo do receptor: R$X,XX**<br>

4. Se a transferência não for completada, exibir mensagem de erro explicando o motivo, vide exemplo: 

**Sua transferência não foi completada pois (escrever o motivo)**
