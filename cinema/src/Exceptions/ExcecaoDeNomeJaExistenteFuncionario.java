package Exceptions;

public class ExcecaoDeNomeJaExistenteFuncionario extends Exception {
	public ExcecaoDeNomeJaExistenteFuncionario() {
		super("J� existe um funcionario com este nome registrado.");
	}
}
