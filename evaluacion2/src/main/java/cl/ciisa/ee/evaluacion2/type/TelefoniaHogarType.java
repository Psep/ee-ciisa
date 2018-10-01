package cl.ciisa.ee.evaluacion2.type;

import cl.ciisa.ee.evaluacion2.exception.NotFoundException;

/**
 * @author psep
 *
 */
public enum TelefoniaHogarType {
	
	PLAN1(1l, "Plan Ilimitado", 15000l, null, true),
	PLAN2(2l, "Plan 300 Minutos", 5000l, 300, false),
	PLAN3(3l, "Plan 500 Minutos", 8000l, 500, false),
	PLAN4(4l, "Plan 1000 Minutos", 12000l, 1000, false);
	
	private TelefoniaHogarType(Long id, String nombre, Long valor, Integer minutos, Boolean esIlimitado) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.minutos = minutos;
		this.esIlimitado = esIlimitado;
	}
	
	private Long id;
	private String nombre;
	private Long valor;
	private Integer minutos;
	private Boolean esIlimitado;
	
	public static TelefoniaHogarType getById(Long id) throws NotFoundException {
		for (TelefoniaHogarType type : TelefoniaHogarType.values()) {
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
	
	public Integer getMinutos() {
		return minutos;
	}
	
	public Boolean getEsIlimitado() {
		return esIlimitado;
	}
}
