package co.usa.ciclo4.retos.service;
/**
 * @Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Clone;
import co.usa.ciclo4.retos.repository.CloneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author IngSB
 */
/**
 * Clase Servicio 'CloneService'
 */
@Service
public class CloneService {
@Autowired
    private CloneRepository cloneRepository;

    /**
     * Metodo constructor de Clone
     * @param cloneRepository
     */
    public CloneService(CloneRepository cloneRepository) {
        this.cloneRepository = cloneRepository;
    }

    /**
     * Trae un producto por id
     * @param id
     * @return
     */
    public Optional getCloneById(int id){
        return cloneRepository.getCloneById(id);
    }

    /**
     * Metodo para traer la lista de productos en la clase Clone
     * @return cloneRepository.getAll()
    */
    public List<Clone> getAll(){
        return cloneRepository.getAll();
    }

    /**
     * Metodo para guardar un producto
     * @param clone
     * @return
    */
    public Clone save(Clone clone){

        List<Clone> clones = cloneRepository.getAll();
        Integer idAuto = clones.size();
        idAuto++;
        Optional<Clone> exist = cloneRepository.getCloneById(idAuto);
        if (exist.isPresent()){
            return clone;
        }
        if (clone.getId() == null){
            clone.setId(idAuto);
        }

        if (clones.size() == 0){
            return cloneRepository.save(clone);
        }else if (clones.isEmpty() == false) {
            return cloneRepository.save(clone);
        }
        return clone;
    }

    /**
     * Metodo para obtener un producto por Id
     * @param id
     * @return
     */
    public boolean getById(String id){

        List<Clone> clones = cloneRepository.getAll();
        boolean flag = false;

        for (Clone clone: clones) {
            if(id.equals(clone.getId())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Metodo para eliminar un producto
     * @param id
     */
    public void delete(int id){
        cloneRepository.deleteById(id);
    }


    /**
     * Metodo para listar Productos por descripcion
     * @param description
     * @return
     */
    public List<Clone> cloneByDesc(String description) {
        return cloneRepository.findByDesc("(?i)" + description );
    }

    /**
     * Listar Clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    public List<Clone> cloneByPrice(Double price) {
        return cloneRepository.findByPrice(price);
    }

}
