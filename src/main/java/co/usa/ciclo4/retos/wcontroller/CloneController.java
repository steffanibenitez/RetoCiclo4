package co.usa.ciclo4.retos.wcontroller;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Clone;
import co.usa.ciclo4.retos.service.CloneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 * @author IngSB
 */
/**
 * Clase Controlador 'CloneController'
 */
@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CloneController {
    /**
     * Atributo objeto 'cloneService' instancia de la clase
     * 'CloneService'
     */    
    @Autowired
    private CloneService cloneService;
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * de documentos de productos hacia el metodo 'getAll' del CloneService
     * @return 
     */
    @GetMapping("/all")
    public List<Clone> getClones() {
        return cloneService.getAll();
    }
    /**
     * Metodo para obtener y retornar un registro de documento de producto 
     * por el valor de su atributo 'id', hacia el metodo 'getUserById' 
     * del CloneService
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Clone> getClone(@PathVariable("id") Integer id) {
        return cloneService.getCloneById(id);
    }
    /**
     * Metodo para guardar y retornar un registro de documento de producto 
     * hacia el metodo 'save' del CloneService
     * @param clone
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return cloneService.save(clone);
    }
    /**
     * Metodo para actualizar y retornar un registro de documento de producto 
     * hacia el metodo 'update' del CloneService
     * @param clone
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return cloneService.update(clone);
    }
    /**
     * Metodo para eliminar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'delete' del UserService
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cloneService.delete(id);
    }
}