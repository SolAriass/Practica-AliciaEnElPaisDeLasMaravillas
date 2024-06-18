package ar.edu.unlam.alicia;

public class BocaditoDeChocolate extends Alimento implements Agrandador{

	public BocaditoDeChocolate(String nombre, Double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agrandar(Alicia alicia) {
		alicia.setAltura(alicia.getAltura() + 40.0);
	}

}
