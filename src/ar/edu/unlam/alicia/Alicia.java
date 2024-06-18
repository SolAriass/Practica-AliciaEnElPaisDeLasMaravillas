package ar.edu.unlam.alicia;

import java.util.List;
import java.util.ArrayList;

public class Alicia {

	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dineroParaComprar;
	private List<Alimento> alimentosAdquiridos;

	public Alicia(String nombre, Integer edad, Double peso, Double dineroParaComprar) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = 180.0;
		this.dineroParaComprar = dineroParaComprar;
		this.alimentosAdquiridos = new ArrayList<>();
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDineroParaComprar() {
		return dineroParaComprar;
	}

	public void setDineroParaComprar(Double dineroParaComprar) {
		this.dineroParaComprar = dineroParaComprar;
	}

	public void comprarAlimentoEnElSuper(Supermercado supermercado, Alimento masita) throws DineroNoDisponibleExcepcion {

		if (supermercado != null) {
			Alimento disponible = supermercado.consultarPorAlimentoDisponible(masita);
			if (disponible != null) {
				if (this.getDineroParaComprar() >= disponible.getPrecio()) {
					alimentosAdquiridos.add(disponible);
					this.setDineroParaComprar(this.getDineroParaComprar() - masita.getPrecio());
				}else {
					throw new DineroNoDisponibleExcepcion();
				}

			}

		}
	}

	public void agregarAlimentosAlSuper(Supermercado supermercado, Alimento masita) {

		if (supermercado != null) {
			supermercado.agregarAlimentosAlSuper(masita);
		}

	}

	public void consumirAlimentoAgrandador(Alimento alimento) throws ExcesoDeAgrandamientoException {
		
		if(alimento != null && alimento instanceof Agrandador) {
			if(this.getAltura() + 40.0 <= 280.0) {
				((Agrandador) alimento).agrandar(this);
				alimentosAdquiridos.remove(alimento);
			}else {
				throw new ExcesoDeAgrandamientoException();
			}
		}
		
		
	}

	public void consumirAlimentoAchicador(Alimento alimento) throws ExcesoDeAchicamientoException {
		
		if(alimento != null && alimento instanceof Achicador) {
			if(this.getAltura() - 50 >= 50.0) {
				((Achicador) alimento).achicar(this);
				alimentosAdquiridos.remove(alimento);
			}else {
				throw new ExcesoDeAchicamientoException();
			}
		}
		
	}

	// objeto super, que adentro tiene alimentos de tipo achicador y agrandador
	// achicador -> encoje 50cms MASITAS - ALFAJORES - BAGELS
	// agrandador -> agranda 40cm BOCADITO DE CHOCOLATE - CARAMELO - GOMITA

	// a medida que se consumen, se eliminan de los alimentos disponibles para
	// consumir

	// altura inicio 180 cm
	// cuando consuma se debe modificar su altura
	// no puede crecer mas de 280 cm , si el alimento que va a consumir supera el
	// maximo NO se suma
	// no puede encojerse mas de 50 cm, en caso de querer consumir un alimento que
	// supere el minimo NO se suma
	// los alimentos que encogen deben ser ordenados de manera descendente

	/*
	 * 1) Que, al comprar un alimento, se descuente el dinero disponible
	 * 
	 * 2) Que no se exceda del dinero disponible
	 * 
	 * 3) Que, al consumir un alimento, verificar que se agrande
	 * 
	 * 4) Que al consumir un alimento verificar que se encoja
	 * 
	 * 5) Que al consumir alimentos verificar que no se pueda agrandar más de 280cm
	 * 
	 * 6) Que al consumir alimentos verificar que no se pueda achicar menos de 50cm
	 * 
	 * 7) Verificar que la colección de alimentos quede ordenada por nombre de
	 * manera descendente
	 * 
	 * 
	 * 
	 */

}
