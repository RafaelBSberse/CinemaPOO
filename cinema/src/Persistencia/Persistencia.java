package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import Model.Filme;
import Model.Funcionario;
import Model.Sala;

public class Persistencia implements IPersistencia {
	public void salvaDados(ArrayList<Filme> filmes, ArrayList<Funcionario> funcionarios, ArrayList<Sala> salas, Map<String, ArrayList<Funcionario>> horariosFuncionarios) {
		try {
			BufferedWriter escreveFilme = new BufferedWriter(new FileWriter("filme.txt"));
			BufferedWriter escreveFuncionario = new BufferedWriter(new FileWriter("funcionario.txt"));
			BufferedWriter escreveSala = new BufferedWriter(new FileWriter("sala.txt"));
			BufferedWriter escreveHorarios = new BufferedWriter(new FileWriter("horarios.txt"));
			
			if (filmes.size() != 0) {
				for(Filme n: filmes) {
					escreveFilme.write(n.toString());
					escreveFilme.newLine();
				}
				escreveFilme.flush();
			}
			
			if (funcionarios.size() != 0) {
				for(Funcionario n: funcionarios) {
					escreveFuncionario.write(n.toString());
					escreveFuncionario.newLine();
				}
				escreveFuncionario.flush();
			}
			
			if (salas.size() != 0) {
				for(Sala n: salas) {
					escreveSala.write(n.toString());
					escreveSala.newLine();
				}
				escreveSala.flush();
			}
			
			if (horariosFuncionarios.size() != 0) {
				escreveHorarios.write(horariosFuncionarios.toString());
				escreveHorarios.newLine();
				escreveHorarios.flush();
			}
			
			escreveFilme.close();
			escreveFuncionario.close();
			escreveSala.close();
			escreveHorarios.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recuperaDados() {
		
	}
}
