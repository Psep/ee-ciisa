package cl.ciisa.ee.ejercicio1.type;

/**
 * Enum para los tipos de capacidad de personas.
 * 
 * @author psep
 *
 */
public enum CapacidadType {
	
	DOS_PERSONAS(2, "2 personas"),
	CUATRO_PERSONAS(4, "4 personas"),
	SEIS_PERSONAS(6, "6 personas"),
	OCHO_PERSONAS(8, "8 personas"),
	DIEZ_PERSONAS(10, "10 personas");
	
	private int id;
	private String name;
	
	private CapacidadType(int id, String name) {
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
