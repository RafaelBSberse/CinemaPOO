package Model;

public class Funcionario implements Comparable<Funcionario> {
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
	
	public float getSalario() {
		return this.salario;
	}
	
	public String toString() {
		return nome + "@" + cpf + "@" + admissao + "@" + salario;
	}

	@Override
	public int compareTo(Funcionario o) {
		return this.salario > o.getSalario() ? 1 : -1;
	}
}
