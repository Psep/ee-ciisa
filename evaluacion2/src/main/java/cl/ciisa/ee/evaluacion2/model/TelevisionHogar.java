package cl.ciisa.ee.evaluacion2.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import cl.ciisa.ee.evaluacion2.exception.NotFoundException;
import cl.ciisa.ee.evaluacion2.type.TelevisionHogarType;

@Model
public class TelevisionHogar extends Hogar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer cantCanales;
	private Boolean esHD;
	private Boolean tienePremium;

	public Integer getCantCanales() {
		return cantCanales;
	}

	public void setCantCanales(Integer cantCanales) {
		this.cantCanales = cantCanales;
	}

	public Boolean getEsHD() {
		return esHD;
	}

	public void setEsHD(Boolean esHD) {
		this.esHD = esHD;
	}

	public Boolean getTienePremium() {
		return tienePremium;
	}

	public void setTienePremium(Boolean tienePremium) {
		this.tienePremium = tienePremium;
	}
	
	public TelevisionHogar findById(Long id) throws NotFoundException {
		TelevisionHogarType type = TelevisionHogarType.getById(id);
		TelevisionHogar plan = new TelevisionHogar();
		plan.setCantCanales(type.getCantCanales());
		plan.setId(type.getId());
		plan.setEsHD(type.getEsHD());
		plan.setNombre(type.getNombre());
		plan.setValor(type.getValor());
		plan.setTienePremium(type.getTienePremium());
		
		return plan;
	}
	
	public List<TelevisionHogar> getListTelevisionHogar() {
		List<TelevisionHogar> list = new ArrayList<>();
		
		for (TelevisionHogarType type : TelevisionHogarType.values()) {
			TelevisionHogar plan = new TelevisionHogar();
			plan.setCantCanales(type.getCantCanales());
			plan.setId(type.getId());
			plan.setEsHD(type.getEsHD());
			plan.setNombre(type.getNombre());
			plan.setValor(type.getValor());
			plan.setTienePremium(type.getTienePremium());
			
			list.add(plan);
		}
		
		return list;
	}

}
