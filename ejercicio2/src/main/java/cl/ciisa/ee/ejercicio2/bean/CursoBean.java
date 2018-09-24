package cl.ciisa.ee.ejercicio2.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import cl.ciisa.ee.ejercicio2.to.CursoTO;
import cl.ciisa.ee.ejercicio2.type.CursoType;

/**
 * Clase que permite mediante CDI la incorporación
 * de listas para curso.
 * 
 * @author psep
 */
@Model
public class CursoBean {
	
	/**
	 * Lista los cursos disponibles.
	 * 
	 * @return list
	 */
	public List<CursoTO> getCursos() {
		List<CursoTO> list = new ArrayList<>();
		
		for (CursoType type : CursoType.values()) {
			list.add(new CursoTO(type.getNombre(), type.getValor()));
		}
		
		return list;
	}

}
