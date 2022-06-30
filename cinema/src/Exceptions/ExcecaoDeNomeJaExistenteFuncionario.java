package Exceptions;

public class ExcecaoDeNomeJaExistenteFuncionario extends Exception {
	public ExcecaoDeNomeJaExistenteFuncionario() {
		super("Já existe um funcionario com este nome registrado.");
	}
}
