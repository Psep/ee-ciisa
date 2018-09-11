package cl.ciisa.ee.ejercicio1.type;

public enum AdicionalType {

	NO(1, "No"),
	TRASLADO(2, "Traslado al terminal"),
	TOUR(3, "Tour por la zona"),
	GASTRONOMIA(4, "Gastronomía completa");
	
	private int id;
	private String name;
	
	private AdicionalType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
