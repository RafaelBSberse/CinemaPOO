package Model;

import java.util.Map;
import java.util.HashMap;

public class Sala {
	private String nome;
	private int capacidade;
	private Map<String, Filme> filmesHorarios = new HashMap<>();
			
	public Sala(String nome, int capacidade){
		this.nome = nome;
		this.capacidade = capacidade;
	}
	
	public Sala(String nome, int capacidade, Map<String, Filme> filmesHorarios){
		this.nome = nome;
		this.capacidade = capacidade;
		this.filmesHorarios = filmesHorarios;
	}
	
	public void getSala() {
		System.out.println("Nome: " + this.nome +
						   "\nCapacidade: " + this.capacidade
						   );
	}
	
	public void setFilmesHorarios(String horario, Filme filme) {
		this.filmesHorarios.put(horario, filme);
	}
	
	public boolean comparaSala(String nome) {
		if(this.nome.equals(nome)) {
			return true;
		} else {
			return false;
		}
	}

	public void getFilmeHorarios(String filme) {
		for ( Map.Entry<String, Filme> entry : filmesHorarios.entrySet()) {
		    if(entry.getValue().comparaFilme(filme)) {
		    	System.out.println(this.nome + " - " + entry.getKey());
		    }
		}
	}
	
	public String toString() {
		String filmesHorariosToString = "";
		for ( Map.Entry<String, Filme> entry : filmesHorarios.entrySet()) {
			filmesHorariosToString = filmesHorariosToString.concat("[" + entry.getKey() + ":" + entry.getValue().getTituloOriginal() + "],");
		}
		if(filmesHorariosToString != "") {
			filmesHorariosToString = filmesHorariosToString.substring(0, filmesHorariosToString.length() - 1);
			return nome + "@" + capacidade + "@" + filmesHorariosToString;
		} else {
			return nome + "@" + capacidade;		
		}
	}
}
