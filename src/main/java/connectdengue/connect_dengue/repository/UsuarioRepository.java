
package connectdengue.connect_dengue.repository;

import org.springframework.data.repository.CrudRepository;

import connectdengue.connect_dengue.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Usuario findByUsername(String username);

}