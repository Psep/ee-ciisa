package cl.ciisa.ee.evaluacion1.type;

import cl.ciisa.ee.evaluacion1.to.VueloTO;

/**
 * Enum para los tipos de valores con sus respectivos vuelos.
 * 
 * @author psep
 */
public enum ValorType {
	
	VUELO1("Vuelo 1", 67000),
	VUELO2("Vuelo 2", 59000),
	VUELO3("Vuelo 3", 90000),
	VUELO4("Vuelo 4", 30000),
	VUELO5("Vuelo 5", 76000);
	
	private long value;
	private String id;
	
	/**
	 * Constructor del enum.
	 * 
	 * @param id
	 * @param value
	 */
	private ValorType(String id, long value) {
		this.value = value;
		this.id = id;
	}
	
	/**
	 * Método que retorna un VueloTO basado en el
	 * precio ingresado para el tipo de valor.
	 * En caso de no encontrar ningún type, retorna null.
	 * 
	 * @param value
	 * @return VueloTO
	 */
	public static VueloTO getVuelo(long value) {
		for (ValorType valor : ValorType.values()) {
			if (valor.getValue() == value) {
				VueloTO vuelo = new VueloTO();
				vuelo.setNombre(valor.getId());
				vuelo.setValor(value);
				
				return vuelo;
			}
		}
		
		return null;
	}

	public long getValue() {
		return value;
	}

	public String getId() {
		return id;
	}

}
