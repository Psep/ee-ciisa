package cl.ciisa.ee.ejercicio1.type;

/**
 * Enum para los tipos de pago.
 * 
 * @author psep
 *
 */
public enum PagoType {
	
	CREDITO(1, "Tarjeta de Crédito"),
	DEBITO(2, "Tarjeta de Débito");
	
	private int id;
	private String name;
	
	private PagoType(int id, String name) {
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
