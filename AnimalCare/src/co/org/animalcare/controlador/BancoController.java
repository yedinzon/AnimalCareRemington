package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.BancoService;
import co.org.animalcare.modelo.dto.BancoDTO;

@Controller
@ManagedBean(name="bancoController")
public class BancoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{bancoService}")
    private BancoService bancoService;
  
    private List<BancoDTO> listaBancos;
    private BancoDTO banco =new BancoDTO();    
    private int codigo;
    private String nombre;

	public BancoService getBancoService() {
		return bancoService;
	}

	public void setBancoService(BancoService bancoService) {
		this.bancoService = bancoService;
	}

	public List<BancoDTO> getListaBancos() {
		listaBancos = new ArrayList<BancoDTO>();
		listaBancos.addAll(bancoService.listBanco());
		return listaBancos;
	}

	public void setListaBancos(List<BancoDTO> listaBancos) {
		this.listaBancos = listaBancos;
	}

	public BancoDTO getBanco() {
		return banco;
	}

	public void setBanco(BancoDTO banco) {
		this.banco = banco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void eliminarBanco(ActionEvent event) {
		int idBanco = (int)event.getComponent().getAttributes().get("idBanco");
		bancoService.eliminar(idBanco);
	}

	public void guardarBanco(ActionEvent event) {
		
		BancoDTO b = new BancoDTO();
		b.setCodigo(codigo);
		b.setNombre(nombre);
		bancoService.guardar(b);
	}	

}
