package cl.ciisa.ee.evaluacion3.to;

import java.io.Serializable;

/**
 * @author psep
 *
 */
public class UsuarioTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String username;
	private String passwd;
	private PersonaTO persona;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public PersonaTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaTO persona) {
		this.persona = persona;
	}

}
