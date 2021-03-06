package pe.gob.edu.ugel.resoluciones.core.domain;

import java.io.Serializable;
import java.util.Date;

public class ResolEmitida extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2L;

	private String codresolucion;
	private Date fechaemitida;
	private String fechaemitidaS;

	private Detalle detalle;

	public String getCodresolucion() {
		return codresolucion;
	}

	public void setCodresolucion(String codresolucion) {
		this.codresolucion = codresolucion;
	}

	public Date getFechaemitida() {
		return fechaemitida;
	}

	public void setFechaemitida(Date fechaemitida) {
		this.fechaemitida = fechaemitida;
	}

	private Resolucion resolucion;
	private Docente docente;

	public Resolucion getResolucion() {
		return resolucion;
	}

	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getFechaemitidaS() {
		return fechaemitidaS;
	}

	public void setFechaemitidaS(String fechaemitidaS) {
		this.fechaemitidaS = fechaemitidaS;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

}
