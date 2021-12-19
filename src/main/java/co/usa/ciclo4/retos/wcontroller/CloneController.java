package co.usa.ciclo4.retos.wcontroller;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Clone;
import co.usa.ciclo4.retos.dmodel.Order;
import co.usa.ciclo4.retos.service.CloneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
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
     * Metodo constructor para clone
     * @param cloneService
     */
    public CloneController(CloneService cloneService) {
        this.cloneService = cloneService;
    }
    /**
     * Metodo para obtener para obtener todos los productos
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Order> getOrderById(@PathVariable("id") int id){
        return cloneService.getCloneById(id);
    }
    @GetMapping("all")
    public List<Clone> getClones(){
        return cloneService.getAll();
    }
    /**
     * Metodo para guardar todos los productos
     * @param clone
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        return cloneService.save(clone);
    }
    /**
     * Metodo para actualizar un producto
     * @param clone
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone cloneUpdate(@RequestBody Clone clone){
        return cloneService.save(clone);
    }
    /**
     * metodo para eliminar un producto
     * @param cloneId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")int cloneId){
        cloneService.delete(cloneId);
    }
    /**
     * Listar clones por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */
    @GetMapping("description/{desc}")
    public List<Clone> cloneByDesc(@PathVariable("desc") String description) {
        return cloneService.cloneByDesc(description);
    }
    /**
     * Listar clones que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    @GetMapping("price/{price}")
    public List<Clone> cloneByPrice(@PathVariable("price") Double price) {
        return cloneService.cloneByPrice(price);
    }
}
