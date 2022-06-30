package Exceptions;

public class ExcecaoDeNomeJaExistenteFilme extends Exception {
	public ExcecaoDeNomeJaExistenteFilme() {
		super("Já existe um filme com este nome registrado.");
	}
}
