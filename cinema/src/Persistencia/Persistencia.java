package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
				String tempValue = "";
				for ( Map.Entry<String, ArrayList<Funcionario>> entry : horariosFuncionarios.entrySet()) {
					tempValue = entry.getKey() + "@";
					for(Funcionario n : entry.getValue()) {
						tempValue = tempValue.concat(n.getNome() + ",");
			        }
					tempValue = tempValue.substring(0, tempValue.length() - 1);
					escreveHorarios.write(tempValue);
					escreveHorarios.newLine();
				}
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
	
	public ArrayList<Filme> recuperaFilmes() {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("filme.txt"));
			String[] tempArrayString = new String[4];
			
			String linha = leitor.readLine();
			
			while (linha != null) {
				tempArrayString = linha.split("@");
				filmes.add(new Filme(tempArrayString[0], tempArrayString[1], tempArrayString[2], Integer.parseInt(tempArrayString[3])));
				linha = leitor.readLine();
			}
			
			leitor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return filmes;
	}
	
	public ArrayList<Funcionario> recuperaFuncionarios() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("funcionario.txt"));
			String[] tempArrayString = new String[4];
			
			String linha = leitor.readLine();
			
			while (linha != null) {
				tempArrayString = linha.split("@");
				funcionarios.add(new Funcionario(tempArrayString[0], tempArrayString[1], tempArrayString[2], Float.parseFloat(tempArrayString[3])));
				linha = leitor.readLine();
			}
			
			leitor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	public ArrayList<Sala> recuperaSalas(ArrayList<Filme> filmes) {
		ArrayList<Sala> salas = new ArrayList<Sala>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("sala.txt"));
			String[] tempArrayString = new String[3];
			
			String linha = leitor.readLine();
			
			while (linha != null) {
				tempArrayString = linha.split("@");
				if(tempArrayString.length > 2) {
					Map<String, Filme> filmesHorarios = new HashMap<>();
					for(String s: tempArrayString[2].split(",")) {
						String tempValue = s.substring(1, s.length() - 1);;
						for(Filme f: filmes) {
							if(f.comparaFilme(tempValue.split(":")[1])) {
								filmesHorarios.put(tempValue.split(":")[0], f);
							}
						}
					}
					salas.add(new Sala(tempArrayString[0], Integer.parseInt(tempArrayString[1]), filmesHorarios));
				} else {
					salas.add(new Sala(tempArrayString[0], Integer.parseInt(tempArrayString[1])));
				}
				linha = leitor.readLine();
			}
			
			leitor.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return salas;
	}

	public Map<String, ArrayList<Funcionario>> recuperaHorarioFuncionarios(ArrayList<Funcionario> funcionarios) {
		Map<String, ArrayList<Funcionario>> horariosFuncionarios = new HashMap<String, ArrayList<Funcionario>>();
		try {
			BufferedReader leitor = new BufferedReader(new FileReader("horarios.txt"));
			String[] tempArrayString = new String[2];
			
			String linha = leitor.readLine();
			
			while (linha != null) {
				tempArrayString = linha.split("@");
				ArrayList<Funcionario> tempFuncionarios = new ArrayList<Funcionario>();
				for(String s: tempArrayString[1].split(",")) {
					for(Funcionario f: funcionarios) {
						if(f.comparaFuncionario(s)) {
							tempFuncionarios.add(f);
						}
					}
				}
				horariosFuncionarios.put(tempArrayString[0], tempFuncionarios);
				linha = leitor.readLine();
			}
			
			leitor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return horariosFuncionarios;
	}
	
}
