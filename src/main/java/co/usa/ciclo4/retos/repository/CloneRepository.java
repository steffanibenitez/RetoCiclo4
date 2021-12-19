package co.usa.ciclo4.retos.repository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.icrudrepository.CloneCrudRepository;
import co.usa.ciclo4.retos.dmodel.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
/**
 * @author IngSB
 */
/**
 * Clase Repositorio 'CloneRepository'
 */
@Repository
public class CloneRepository {
private CloneCrudRepository cloneCrudRepository;
    /**
     * Metodo constructor
     * @param cloneCrudRepository
     */
    public CloneRepository(CloneCrudRepository cloneCrudRepository) {
        this.cloneCrudRepository = cloneCrudRepository;
    }
    /**
     * metodo para obtener cada producto por Id
     * @param id
     * @return
     */
    public Optional<Clone> getCloneById(int id){
        return cloneCrudRepository.findById(id);
    }
    /**
     * Metodo para obtener a todos los productos
     * @return
     */
    public List<Clone> getAll(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }
    /**
     * Metodo para guardar cada producto
     * @param clone
     * @return
     */
    public Clone save(Clone clone){
        return cloneCrudRepository.save(clone);
    }
    /**
     * Metodo para borrar un producto por Id
     * @param id
     */
    public void deleteById (Integer id){
        cloneCrudRepository.deleteById(id);
    }
    /**
     * Meetodo para listar productos por precio maximo
     * @param price
     * @return
     */
    public List<Clone> findByPrice (Double price){
        return cloneCrudRepository.findCloneByPriceIsLessThanEqual(price);
    }
    /**
     * Metodo para listar productos por descripcion
     * @param description
     * @return
     */
    public List<Clone> findByDesc (String description){
        return cloneCrudRepository.findCloneByDescriptionRegex(description);
    }
}