package co.org.animalcare.modelo.dao;

public interface UsuarioDao {

	public Usuario findByUsuario(Usuario usuario);
	public Usuario login(Usuario usuario);
	
}
