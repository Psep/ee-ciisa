package cl.ciisa.ee.evaluacion2.type;

import cl.ciisa.ee.evaluacion2.exception.NotFoundException;

/**
 * @author psep
 *
 */
public enum TelevisionHogarType {

	PLAN1(1l, "Plan Normal", 12000l, 50, false, false), 
	PLAN2(2l, "Plan Deportivo", 18000l, 70, true, true),
	PLAN3(3l, "Plan Full HD", 22000l, 85, true, true);

	private Long id;
	private String nombre;
	private Long valor;
	private Integer cantCanales;
	private Boolean esHD;
	private Boolean tienePremium;

	private TelevisionHogarType(Long id, String nombre, Long valor, Integer cantCanales, Boolean esHD,
			Boolean tienePremium) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.cantCanales = cantCanales;
		this.esHD = esHD;
		this.tienePremium = tienePremium;
	}
	
	public static TelevisionHogarType getById(Long id) throws NotFoundException {
		for (TelevisionHogarType type : TelevisionHogarType.values()) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		
		throw new NotFoundException("No se encuentra el plan de Telefonía Hogar");
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getValor() {
		return valor;
	}

	public Integer getCantCanales() {
		return cantCanales;
	}

	public Boolean getEsHD() {
		return esHD;
	}

	public Boolean getTienePremium() {
		return tienePremium;
	}

}
