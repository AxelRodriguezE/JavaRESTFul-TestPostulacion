package cl.axel.rodriguez.pruebaseleccion.domain;

import java.io.Serializable;

/**
 * @author Axel
 *
 */
public class FirstResponse implements Serializable{

	private static final long serialVersionUID = 4173389914440920150L;
	
	private String code;
	private String description;
	private String data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

}
