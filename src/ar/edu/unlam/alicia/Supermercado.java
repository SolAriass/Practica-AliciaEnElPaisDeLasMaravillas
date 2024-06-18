package ar.edu.unlam.alicia;

import java.util.List;
import java.util.ArrayList;

public class Supermercado {
	
	private String nombreSuper;
	private List<Alimento> alimentosDisponibles;
	
	public Supermercado(String nombreSuper) {
		this.setNombreSuper(nombreSuper);
		this.alimentosDisponibles = new ArrayList<>();
	}
	
	public void agregarAlimentosAlSuper(Alimento alimento) {
		alimentosDisponibles.add(alimento);
	}
	
	public Alimento consultarPorAlimentoDisponible(Alimento alimento) {
		Alimento alimentoBuscado = null;
		
		for(Alimento a : this.alimentosDisponibles) {
			if(a.equals(alimento)) {
				alimentoBuscado = a;
			}
		}
		
		return alimentoBuscado;
	}

	public String getNombreSuper() {
		return nombreSuper;
	}

	public void setNombreSuper(String nombreSuper) {
		this.nombreSuper = nombreSuper;
	}
	
	

}
