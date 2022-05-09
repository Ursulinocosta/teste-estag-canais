package Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        //System.out.println("\n--------------------------------------------------");
        System.out.println("\n\n                  BEM VINDO AO ITA�             ");
        System.out.println("--------------------------------------------------");
        System.out.println("      SELECIONE A OP��O QUE DESEJA REALIZAR       ");
        System.out.println("--------------------------------------------------\n");
        System.out.println("| ******** |OP��O 1 - CRIAR CONTA     | ******** |");
        System.out.println("| ******** |OP��O 2 - DEPOSITAR       | ******** |");
        System.out.println("| ******** |OP��O 3 - SACAR           | ******** |");
        System.out.println("| ******** |OP��O 4 - TRANSFERIR TED  | ******** |");
        System.out.println("| ******** |OP��O 5 - TRANSFERIR DOC  | ******** |");
        System.out.println("| ******** |OP��O 6 - TRANSFERIR PIX  | ******** |");
        System.out.println("| ******** |OP��O 7 - LISTAR A��ES    | ******** |");
        System.out.println("| ******** |OP��O 8 - SAIR            | ******** |");

        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar1();
                break;

            /*case 4:
                transferir();
                break;*/
                
            case 4:
            	transferirTed();
            	break;
            case 5:
            	transferirDoc();
            	break;
            case 6:
            	transferirPix();
            	break;

            case 7:
                listarContas();
                break;

            case 8:
            	System.out.println("--------------------------------------------------");
            	System.out.println("**************************************************");
                System.out.println("         OBRIGADO POR ESCOLHER O ITA�!!!          ");
                System.out.println("              UM ITA� DE VANTAGENS!!!             ");
                System.out.println("**************************************************");
                System.out.println("--------------------------------------------------");
                System.exit(0); 

            default:
            	System.out.println("**************************************************");
            	System.out.println("--------------------------------------------------");
                System.out.println("                OP��O INV�LIDA!!!                 ");
                System.out.println("--------------------------------------------------");
                System.out.println("**************************************************");
                operacoes();
                break;
        }
    }

	public static void criarConta() { //  Criar conta para movimenta��o
    	
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("Email: ");
        String email = input.next();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--------------------------------------------------");
        System.out.println("          CONTA CRIADA COM SUCESSO!!!             ");
        System.out.println("--------------------------------------------------");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("                  N�MERO DA CONTA:                   ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("          QUAL VALOR DESEJA DEPOSITAR?            ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("              CONTA N�O LOCALIZADA!!!             ");
            System.out.println("--------------------------------------------------");
        }

        operacoes();

    }

    public static void sacar1() {
        System.out.println("                 N�MERO DA CONTA:                 ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("            QUAL VALOR DESEJA SACAR?              ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            
        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("             CONTA N�O LOCALIZADA!!!              ");
            System.out.println("--------------------------------------------------");
        }

        operacoes();

    }
    
    public static void transferirTed() {
    	System.out.println("");
        System.out.println("        N�MERO DA CONTA QUE VAI ENVIAR O TED:         ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("          N�MERO DA CONTA DO DESTINAT�RIO:       ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("            VALOR DA TRANSFER�NCIA:           ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);
                if(valor < 5000) {
                	
                	System.out.println("--------------------------------------------------");
                    System.out.println("N�O � POSS�VEL REALIZAR A TRANSFER�NCIA DESSE VALOR,");
                    System.out.println("      SELECIONE UM VALOR ENTRE 5.000 - 10.000!!!      ");
                    System.out.println("--------------------------------------------------");
                }
                if (valor > 10000) {
                	
                	System.out.println("--------------------------------------------------");
                	System.out.println("N�O � POSS�VEL REALIZAR A TRANSFER�NCIA DESSE VALOR,");
                    System.out.println("      SELECIONE UM VALOR ENTRE 5.000 - 10.000      ");
                    System.out.println("--------------------------------------------------");
                }
                if (valor >= 5000 && valor <= 10000)  {
                	System.out.println("--------------------------------------------------");
                	System.out.println("      TRANFER�NCIA TED REALIZADA COM SUCESSO!!!   ");
                	System.out.println("--------------------------------------------------");
                }
                

            }else {
            	System.out.println("--------------------------------------------------");
                System.out.println("       CONTA PARA DEPOSITO N�O LOCALIZADA!!!      ");
                System.out.println("--------------------------------------------------");
            }

        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("   CONTA PARA TRANSFER�NCIA N�O  LOCALIZADA!!!    ");
            System.out.println("--------------------------------------------------"); 
        }
        operacoes();
    }
    public static void transferirDoc() {
    	System.out.println("");
        System.out.println("          N�MERO DA CONTA QUE VAI ENVIAR O DOC:        ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("          N�MERO DA CONTA DO DESTINAT�RIO:         ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("           VALOR DA TRANSFER�NCIA:             ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);
                
             if(valor < 10000) {
                	
                	System.out.println("--------------------------------------------------");
                	System.out.println("N�O � POSS�VEL REALIZAR A TRANSFER�NCIA DESSE VALOR,");
                    System.out.println("      SELECIONE UM VALOR ACIMA DE 10.000!!!      ");
                    System.out.println("--------------------------------------------------");
                } 
             if (valor >= 10000)  {
                    System.out.println("--------------------------------------------------");	
             	    System.out.println("       TRANFER�NCIA REALIZADA COM SUCESSO!!!      ");
             	    System.out.println("--------------------------------------------------");
             }

            }else {
            	    System.out.println("--------------------------------------------------");
                    System.out.println("       CONTA PARA DEPOSITO N�O LOCALIZADA!!!      ");
                    System.out.println("--------------------------------------------------");
            }

        }else {
        	        System.out.println("--------------------------------------------------");
                    System.out.println("   CONTA PARA TRANSFER�NCIA N�O  LOCALIZADA!!!    ");
                    System.out.println("--------------------------------------------------"); 
        }
        operacoes();
    }
    public static void transferirPix() {
    	System.out.println("");
        System.out.println("   N�MERO DA CONTA QUE VAI ENVIAR A TRANSFER�NCIA:    ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("          N�MERO DA CONTA DO DESTINAT�RIO:       ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("           VALOR DA TRANSFER�NCIA:           ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);
                
              if(valor > 5000) {
                	
                	System.out.println("--------------------------------------------------");
                	System.out.println("N�O � POSS�VEL REALIZAR A TRANSFER�NCIA DESSE VALOR,");
                    System.out.println("      SELECIONE UM VALOR DE AT� 5.000!!!     ");
                    System.out.println("--------------------------------------------------");
                }
              if (valor <= 5000)  {
            	System.out.println("--------------------------------------------------");
               	System.out.println("        TRANFER�NCIA REALIZADA COM SUCESSO!!!          ");
               	System.out.println("--------------------------------------------------");
               }

            }else {
            	System.out.println("--------------------------------------------------");
                System.out.println("       CONTA PARA DEPOSITO N�O LOCALIZADA!!!      ");
                System.out.println("--------------------------------------------------");
            }

        }else {
        	System.out.println("--------------------------------------------------");
            System.out.println("   CONTA PARA TRANSFER�NCIA N�O  LOCALIZADA!!!    ");
            System.out.println("--------------------------------------------------"); 
        }
        operacoes();
    }


    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("--------------------------------------------------");
            System.out.println("                    N�O H� CONTAS                 ");
            System.out.println("--------------------------------------------------");
        }

        operacoes();
    }
}
