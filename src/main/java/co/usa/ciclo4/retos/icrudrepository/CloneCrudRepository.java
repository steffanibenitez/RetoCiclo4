package co.usa.ciclo4.retos.icrudrepository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 * @author IngSB
 */
/**
 * Interface CloneCrudRepository hereda los metodos y atributos de la clase
 * MongoRepository
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    /**
     * Listar Clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    List<Clone> findCloneByPriceIsLessThanEqual(Double price);

    /**
     * Listar Clones por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    List<Clone> findCloneByDescriptionRegex(String description);

}