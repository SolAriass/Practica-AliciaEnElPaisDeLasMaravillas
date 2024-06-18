package ar.edu.unlam.alicia;

public class Masita extends Alimento implements Achicador{

	public Masita(String nombre, Double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void achicar(Alicia alicia) {
		alicia.setAltura(alicia.getAltura() - 50.0);
	}

}
