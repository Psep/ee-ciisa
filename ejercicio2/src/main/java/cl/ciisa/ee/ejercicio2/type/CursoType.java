package cl.ciisa.ee.ejercicio2.type;

import cl.ciisa.ee.ejercicio2.to.CursoTO;

/**
 * Enum para los tipos de cursos disponibles
 * con sus respectivos valores.
 * 
 * @author psep
 */
public enum CursoType {
	
	EXCEL_BASICO("Excel Básico", 120000l),
	EXCEL_MEDIO("Excel Medio", 150000l),
	EXCEL_AVANZADO("Excel Avanzado", 200000l);
	
	private String nombre;
	private Long valor;
	
	/**
	 * Constructor del enum.
	 * 
	 * @param nombre
	 * @param valor
	 */
	private CursoType(String nombre, Long valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	/**
	 * Realiza la búsqueda del curso seleccionado
	 * en la lista del enum para retornar el objeto
	 * cursoTO.
	 * 
	 * @param valor
	 * @return cursoTO
	 */
	public static CursoTO getCurso(Long valor) {
		for (CursoType type : CursoType.values()) {
			if (type.getValor().equals(valor)) {
				CursoTO curso = new CursoTO();
				curso.setNombre(type.getNombre());
				curso.setValor(type.getValor());
				
				return curso;
			}
		}
		
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getValor() {
		return valor;
	}

}
