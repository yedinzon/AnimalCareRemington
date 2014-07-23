/**
 * 
 */
package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;
import co.org.animalcare.modelo.dto.AnimalDTO;

/**
 * 
 * @author Familiar
 *
 */
@Repository
public class AnimalDAO extends JpaDAO<AnimalDTO>{
	public AnimalDAO(){
		super.setClazz(AnimalDTO.class);
	}
}
