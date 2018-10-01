package cl.ciisa.ee.evaluacion2.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import cl.ciisa.ee.evaluacion2.exception.NotFoundException;
import cl.ciisa.ee.evaluacion2.type.TelefoniaHogarType;

@Model
public class TelefoniaHogar extends Hogar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer minutos;
	private Boolean esIlimitado;

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public Boolean getEsIlimitado() {
		return esIlimitado;
	}

	public void setEsIlimitado(Boolean esIlimitado) {
		this.esIlimitado = esIlimitado;
	}
	
	public TelefoniaHogar findById(Long id) throws NotFoundException {
		TelefoniaHogarType type = TelefoniaHogarType.getById(id);
		TelefoniaHogar plan = new TelefoniaHogar();
		plan.setEsIlimitado(type.getEsIlimitado());
		plan.setId(type.getId());
		plan.setMinutos(type.getMinutos());
		plan.setNombre(type.getNombre());
		plan.setValor(type.getValor());
		
		return plan;
	}
	
	public List<TelefoniaHogar> getListTelefoniaHogar() {
		List<TelefoniaHogar> list = new ArrayList<>();
		
		for (TelefoniaHogarType type : TelefoniaHogarType.values()) {
			TelefoniaHogar plan = new TelefoniaHogar();
			plan.setEsIlimitado(type.getEsIlimitado());
			plan.setId(type.getId());
			plan.setMinutos(type.getMinutos());
			plan.setNombre(type.getNombre());
			plan.setValor(type.getValor());
			
			list.add(plan);
		}
		
		return list;
	}

}
