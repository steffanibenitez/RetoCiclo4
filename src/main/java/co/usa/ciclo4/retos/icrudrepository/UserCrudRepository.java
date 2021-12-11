package co.usa.ciclo4.retos.icrudrepository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author IngSB
 */
/**
 * 
 * Interface UserCrudRepository hereda los metodos y atributos de la clase
 * MongoRepository
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor 
     * de su atributo 'name'
     * @param name
     * @return 
     */
    public Optional<User> findByName(String name);
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'email'
     * @param email
     * @return 
     */
    public Optional<User> findByEmail(String email);
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por el valor
     * de su atributo 'name' o por su atributo 'email'
     * @param name
     * @param email
     * @return 
     */
    public List<User> findByNameOrEmail(String name, String email);
    /**
     * Metodo Query para encontrar registro de cuenta de usuario por los valores
     * de sus atributos 'email' y 'password'
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    /**
     * Metodo Query para seleccionar el registro de documento de cuenta de
     * usuario, con el valor mayor en el atributo 'id'
     * @return 
     */
    public Optional<User> findTopByOrderByIdDesc();
}