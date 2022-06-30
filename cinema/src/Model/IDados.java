package Model;

import java.util.ArrayList;
import java.util.Map;

import Exceptions.ExcecaoDeNomeJaExistenteFilme;
import Exceptions.ExcecaoDeNomeJaExistenteFuncionario;
import Exceptions.ExcecaoDeNomeJaExistenteSala;

public interface IDados {
	public void setFilmes() throws ExcecaoDeNomeJaExistenteFilme;
	public void getFilmes();
	public void setFuncionarios() throws ExcecaoDeNomeJaExistenteFuncionario;
	public void getFuncionarios();
	public void setSalas() throws ExcecaoDeNomeJaExistenteSala;
	public void getSalas();
	public void setHorarios();
	public void addFilmeNaSala();
	public void getFilmeHorarioSala();
	public void salvarDados();
}
