package Persistencia;

import java.util.ArrayList;
import java.util.Map;

import Model.Filme;
import Model.Funcionario;
import Model.Sala;

public interface IPersistencia {
	
	public void salvaDados(ArrayList<Filme> filmes, ArrayList<Funcionario> funcionarios, ArrayList<Sala> salas, Map<String, ArrayList<Funcionario>> horariosFuncionarios); 

}
