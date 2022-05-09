package Banco;
public class Conta {
    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = Conta.contadorDeContas;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.contadorDeContas += 1;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public Pessoa getClient() {
        return pessoa;
    }
    public void setClient(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {

        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getNome() + // Nome do Cliente
                "\nCPF: " + this.pessoa.getCpf() + // CPF
                "\nEmail: " + this.pessoa.getEmail() + // Email
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) + // saldo iniciará com 0
                "\n" ;
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("--------------------------------------------------");
            System.out.println("         DEPÓSITO REALIZADO COM SUCESSO!!!        ");
            System.out.println("--------------------------------------------------");
        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("     NÃO FOI POSSÍVEL REALIZAR O DEPÓSITO!!!      ");
            System.out.println("--------------------------------------------------");
        }
    }
    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("--------------------------------------------------");
            System.out.println("          SAQUE REALIZADO COM SUCESSO!!!          ");
            System.out.println("--------------------------------------------------");
        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("       NÃO FOI POSSÍVELL REALIZAR O SAQUE!!!      ");
            System.out.println("--------------------------------------------------");
        }
    }
    	public void transferencia(Conta contaParaDeposito, Double valor) {
            if(valor > 0 && this.getSaldo() >= valor) {
                setSaldo(getSaldo() - valor);

                contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
                System.out.println("");
            }else {
                System.out.println("Não foi possível realizar a tranferência");
            }

        }
    
    }
