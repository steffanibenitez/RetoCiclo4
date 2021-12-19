package co.usa.ciclo4.retos.wcontroller;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Clone;
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
     * Metodo COnstructor para Ordenes
     * @param orderService
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Método para obtener todas las ordenes de la bd
     * @return
     */
    @GetMapping("all")
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    /**
     * Obtiene una orden por id
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Optional<Order> getOrderById(@PathVariable("id") int id){
        return orderService.getOrderById(id);
    }

    /**
     * Método para guardar una orden en bd
     * @param order
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    /**
     * Trae la zona de una orden
     * @param zone
     * @return
     */
    @GetMapping("/zone/{zone}")
    public List<Order> getOrderByzone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }

    /**
     *
     * @param status
     * @return
     */
    @GetMapping("/state/{estado}")
    public List<Order> getOrderBystatus(@PathVariable("estado") String status){
        return orderService.getOrderByStatus(status);
    }

    /**
     * Actualiza a un usuario en la base de datos
     * @param order
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order orderUpdate(@RequestBody Order order){
        return orderService.orderUpdate(order);
    }

    /**
     * Eliminar una orden por id
     * @param orderId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id")int orderId){
        orderService.deleteById(orderId);
    }

    /**
     * Obtiene usuarios por identificacion
     * @param identification
     * @return
     */
    @GetMapping("/identificacion/{identification}")
    public List<Order> getOrderByIdentification(@PathVariable("identification") String identification) {
        return orderService.findByIdentification(identification);
    }

    /**
     * Metodo para agregar un producto
     * @param idOrder
     * @param clone
     * @return
     */
    @PutMapping("/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addProduct(@PathVariable("id") Integer idOrder, @RequestBody Optional<Clone> clone) {
        return orderService.addProduct(clone, idOrder);
    }

    /**
     * Metodo para agregar cantidad
     *
     * @param idOrder
     * @param cantidad
     * @return
     */
    @PutMapping("/cantidad/{id}/{cantidad}/{idQuantity}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order addCantidad(@PathVariable("id") Integer idOrder, @PathVariable("cantidad") Integer cantidad, @PathVariable("idQuantity") String idQuantity) {
        return orderService.addCantidad(cantidad, idOrder, idQuantity);
    }

    /**
     * Metodo para buscar el id y el estado de un Asesor
     *
     * @param status
     * @param id
     * @return
     */
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusId(@PathVariable("status") String status, @PathVariable("id") Integer id) {
        return orderService.orderBySalesManStatusAndId(status, id);
    }

    /**
     * Mmetodo para buscar id y fecha del Asesor
     *
     * @param date
     * @param id
     * @return
     */
    @GetMapping("/date/{date}/{id}")
    public List<Order> getByDateId(@PathVariable("date") String date, @PathVariable("id") Integer id) {
        return orderService.getByRegisterDayAndSalesManId(date, id);
    }

    /**
     * Metodo para buscar una order por id de asesor
     * @param id
     * @return
     */
    @GetMapping("/salesman/{id}")
    public List<Order> getsalesmanById(@PathVariable("id") Integer id){
        return orderService.orderById(id);
    }

}