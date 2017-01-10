package cl.axel.rodriguez.pruebaseleccion.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FirstRequest implements Serializable{
	
	private static final long serialVersionUID = -1677266501640476220L;
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}	

}
