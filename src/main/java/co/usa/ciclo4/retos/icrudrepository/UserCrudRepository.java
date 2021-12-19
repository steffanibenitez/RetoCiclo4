package co.usa.ciclo4.retos.icrudrepository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
     * Metodo para listar usuarios por Identificacion
     * @param identification
     * @return
     */
    @Query("{'identification': ?0}")
    Optional<User> findByIdentificacion(final String identification);
    /**
     * Método para listar usuarios cuyo mes de cumpleaños sea el ingresado
     *
     * @param month
     * @return
     */
    List<User> findByMonthBirthtDay(String month);
}