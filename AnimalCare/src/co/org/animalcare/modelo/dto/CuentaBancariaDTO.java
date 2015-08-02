/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_CUENTAS_BANCARIAS, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_CUENTAS_BANCARIAS")
public class CuentaBancariaDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código para la cuenta bancaria de la entidad
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al código de la entidad al que se asocia la cuenta
	@Column(name = "NM_CODIGO_ENTIDAD")
	private EntidadDTO entidad;
	
	//Corresponde al código del banco donde la entidad tenga la cuenta
	@Column(name = "NM_CODIGO_BANCO")
	private BancoDTO banco;
	
	//Corresponde al tipo de cuenta. Como ahorros o corriente
	@Column(name = "NV_TIPO")
	private String tipo;
	
	//Corresponde al nombre del titular de la cuenta
	@Column(name = "NV_NOMBRE_TITULAR")
	private String nombreTitular;
	
	//Corresponde al número de la cuenta bancaria
	@Column(name = "NM_NUMERO_CUENTA")
	private Long numeroCuenta;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public EntidadDTO getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}
	public BancoDTO getBanco() {
		return banco;
	}
	public void setBanco(BancoDTO banco) {
		this.banco = banco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
}
