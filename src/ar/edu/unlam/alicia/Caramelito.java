package ar.edu.unlam.alicia;

public class Caramelito extends Alimento implements Agrandador{

	public Caramelito(String nombre, Double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void agrandar(Alicia alicia) {
		alicia.setAltura(alicia.getAltura() + 40.0);
	}

}
