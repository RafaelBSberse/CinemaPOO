package Exceptions;

public class ExcecaoDeNomeJaExistenteSala extends Exception {
	public ExcecaoDeNomeJaExistenteSala() {
		super("Já existe uma sala com este nome registrado.");
	}
}
