package Model;

public class Funcionario {
	private String nome;
	private String cpf;
	private String admissao;
	private float salario;
	
	public Funcionario(String nome, String cpf, String admissao, float salario){
		this.nome = nome;
		this.cpf = cpf;
		this.admissao = admissao;
		this.salario = salario;
	}
	
	public void getFuncionario() {
		System.out.println("Nome: " + this.nome +
						   "\nCPF: " + this.cpf + 
						   "\nData de Admiss�o: " + this.admissao +
						   "\nSal�rio: R$" + this.salario);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public boolean comparaFuncionario(String nome) {
		if(this.nome.equals(nome)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return nome + "@" + cpf + "@" + admissao + "@" + salario;
	}
}
