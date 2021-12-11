package co.usa.ciclo4.retos.wcontroller;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Order;
import co.usa.ciclo4.retos.service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 * @author IngSB
 */
/**
 * Clase Controlador 'OrderController'
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class OrderController {
    /**
     * Atributo objeto 'orderService' instancia de la clase
     * 'OrderService'
     */  
    @Autowired
    private OrderService orderService;
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * de documentos de productos hacia el metodo 'getAll' del OrderService
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getOrders() {
        return orderService.getAll();
    }    
    /**
     * Metodo para obtener y retornar un registro de documento de producto 
     * por el valor de su atributo 'id', hacia el metodo 'getUserById' 
     * del OrderService
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrderById(id);
    }
    /**
     * Metodo para guardar y retornar un registro de documento de producto 
     * hacia el metodo 'save' del OrderService
     * @param order
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }
    /**
     * Metodo para actualizar y retornar un registro de documento de producto 
     * hacia el metodo 'update' del OrderService
     * @param order
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }
    /**
     * Metodo para eliminar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'delete' del OrderService
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return orderService.delete(id);
    }
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * documentos de ordenes, por el valor del atributo 'zone' 
     * hacia el metodo 'getOrderByZone' del OrderService
     * @param zone
     * @return 
     */
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }
    /**
     * Metodo para obtener y retornar una lista de todos los registros de
     * documentos de ordenes, por el valor del atributo 'zone' 
     * hacia el metodo 'getOrderByZone' del OrderService
     * @param status
     * @return 
     */
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return orderService.getOrderByStatus(status);
    }
}