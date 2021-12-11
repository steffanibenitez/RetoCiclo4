package co.usa.ciclo4.retos.repository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.icrudrepository.CloneCrudRepository;
import co.usa.ciclo4.retos.dmodel.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @author IngSB
 */
/**
 * Clase Repositorio 'CloneRepository'
 */
@Repository
public class CloneRepository {
    /**
     * Atributo objeto 'cloneCrudRepository' instancia de la interface
     * 'CloneCrudRepository'
     */
    @Autowired
    private CloneCrudRepository cloneCrudRepository;
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * documentos de productos hacia el metodo 'findAll' del 
     * MongoRepository
     * @return 
     */
    public List<Clone> getAll() {
        return cloneCrudRepository.findAll();
    }
    /**
     * Metodo para obtener y retornar un registro de documento de producto por
     * el valor de su atributo 'id', hacia el metodo 'findById' del 
     * MongoRepository
     * @param id
     * @return 
     */
    public Optional<Clone> getCloneById(Integer id) {
        return cloneCrudRepository.findById(id);
    }
    /**
     * Metodo para guardar y retornar un registro de documento de producto 
     * hacia el metodo 'save' del MongoRepository
     * @param clone
     * @return 
     */
    public Clone save(Clone clone) {
        return cloneCrudRepository.save(clone);
    }
    /**
     * Metodo para actualizar y retornar un registro de documento de producto 
     * hacia el metodo 'update' del MongoRepository
     * @param clone 
     */
    public void update(Clone clone) {
        cloneCrudRepository.save(clone);
    }
    /**
     * Metodo para eliminar y retornar un registro de documento de producto
     * hacia el metodo 'delete' del MongoRepository
     * @param clone 
     */
    public void delete(Clone clone) {
        cloneCrudRepository.delete(clone);
    }
    /**
     * Metodo para obtener y retornar un registro de documento de producto
     * cuyo valor de atributo 'id' sea el mayor, devuelto hacia el metodo 
     * 'findTopByOrderByIdDesc' del CloneCrudRepository
     * @return 
     */
    public Optional<Clone> getCloneWithLastId(){
        return cloneCrudRepository.findTopByOrderByIdDesc();
    }
}