package Model;

public class Filme {
	private String tituloPT;
	private String tituloOriginal;
	private String diretor;
	private int lancamento;
	
	public Filme(String tituloPT, String tituloOriginal, String diretor, int lancamento){
		this.tituloPT = tituloPT;
		this.tituloOriginal = tituloOriginal;
		this.diretor = diretor;
		this.lancamento = lancamento;
	}
	
	public void getFilme() {
		System.out.println("Titulo PT-BR: " + this.tituloPT +
						   "\nTitulo Original: " + this.tituloOriginal + 
						   "\nDiretor: " + this.diretor +
						   "\nAno de Lançamento: " + this.lancamento);
	}
	
	public boolean comparaFilme(String nome) {
		if(this.tituloOriginal.equals(nome)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return tituloPT + "@" + tituloOriginal + "@" + diretor + "@" + lancamento;
	}
}
