package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_ANIMALES, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_ANIMALES")
public class AnimalDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código de un animal
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde a un comentario que se desee agregar sobre el animal
	@Column(name = "NV_COMENTARIO")
	private String comentario;
	
	//Corresponde a la edad del animal. Se espera que sea específicado a partir del ingreso de una fecha apróximada de nacimiento
	@Column(name = "DA_EDAD")
	private String edad;
	
	//Corresponde al código de la entidad a la que pertece el animal	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NM_CODIGO_ENTIDAD")	
	private EntidadDTO entidad;
	
	//Corresponde al estado que tendrá asociado un animal en un momento determinado, como habilitado o deshabilitado.
	@Column(name = "NV_ESTADO")
	private String estado;
	
	//Corresponde al estado fértil o no de un animal.
	@Column(name = "BO_FERTILIDAD")
	private boolean fertilidad;
	
	//Corresponde al nombre del animal
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al codigo de la raza a la que pertenece el animal
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NM_CODIGO_RAZA")
	private RazaDTO raza;
	
	//Corresponde al sexo del animal.
	@Column(name = "BO_SEXO")
	private boolean sexo;
	
	//Corresponde al tamaño del animal, entre valores de grande, mediano y pequeño.
	@Column(name = "NV_TAMANO")
	private String tamano;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public EntidadDTO getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isFertilidad() {
		return fertilidad;
	}
	public void setFertilidad(boolean fertilidad) {
		this.fertilidad = fertilidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public RazaDTO getRaza() {
		return raza;
	}
	public void setRaza(RazaDTO raza) {
		this.raza = raza;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	
	
}
