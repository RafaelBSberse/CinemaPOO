package Exceptions;

public class ExcecaoDeNomeJaExistenteFilme extends Exception {
	public ExcecaoDeNomeJaExistenteFilme() {
		super("J� existe um filme com este nome registrado.");
	}
}
