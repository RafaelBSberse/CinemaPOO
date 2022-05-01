package cinema;

public class Funcionario {
	private String cpf;
	private String nome;
	private String admissao;
	private float salario;
	
	Funcionario(String nome, String cpf, String admissao, float salario){
		this.nome = nome;
		this.cpf = cpf;
		this.admissao = admissao;
		this.salario = salario;
	}
	
	public void getFuncionario() {
		System.out.println("Nome: " + this.nome +
						   "\nCPF: " + this.cpf + 
						   "\nData de Admissão: " + this.admissao +
						   "\nSalário: R$" + this.salario);
	}
	
	public boolean comparaFuncionario(String nome) {
		if(this.nome.equals(nome)) {
			return true;
		} else {
			return false;
		}
	}
}
