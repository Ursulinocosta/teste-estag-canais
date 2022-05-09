package Banco;

public class Pessoa {
	
	private static int conta = 1;
	
	private String nome;
	private String cpf;
	private String email;
	
	public Pessoa(String nome, String cpf, String email) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		setConta(getConta() + 1);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	public String toString() {
		return "\nNome: "+ this.getNome() +
				"\nCPF: "+  this.getCpf() +
				"\nEmail" + this.getEmail();
		
	}
	public static int getConta() {
		return conta;
	}
	public static void setConta(int conta) {
		Pessoa.conta = conta;
	}

	}


