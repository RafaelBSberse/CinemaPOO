package Exceptions;

public class ExcecaoDeNomeJaExistenteSala extends Exception {
	public ExcecaoDeNomeJaExistenteSala() {
		super("J� existe uma sala com este nome registrado.");
	}
}
