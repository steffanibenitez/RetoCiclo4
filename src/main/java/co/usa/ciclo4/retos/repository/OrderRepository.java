package co.usa.ciclo4.retos.repository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.Order;
import co.usa.ciclo4.retos.icrudrepository.OrderCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
/**
 * @author IngSB
 */
/**
 *clase Repositorio 'OrderRepository'
 */
@Repository
public class OrderRepository {

    public OrderCrudRepository orderCrudRepository;

    /**
     * Metodo constructor para Order
     * @param orderCrudRepository
     */
    public OrderRepository(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }

    /**
     * Metodo para obtener una orden por id
     * @param id
     * @return
     */
    public Optional<Order> getOrderById(int id){
        return orderCrudRepository.findById(id);
    }

    /**
     * Metodo para traer todas las ordenes
     * @return
     */
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }

    /**
     * Metodo para obtener la zona de cada orden
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }

    /**
     * Metodo para obtener el estado de la orden
     * @param status
     * @return
     */
    public List<Order> getOrderByStatus(String status){
        return orderCrudRepository.findByStatus(status);
    }


    /**
     * Metodo para guardar una orden
     * @param order
     * @return
     */
    public Order save(Order order){
        return orderCrudRepository.save(order);
    }

    /**
     * Metodo para eliminar una orden por id
     * @param id
     */
    public void deleteById (Integer id){
        orderCrudRepository.deleteById(id);
    }

    /**
     * Obtiene un usuario por identificacion
     * @param identification
     * @return
     */
    public List<Order> findByIdentification(String identification) {
        return orderCrudRepository.findByIdentification(identification);
    }

    /**
     * Metodo para listar ordenes por estado
     * @param idUser
     * @param status
     * @return
     */
    public List<Order> findByStatus (Integer idUser, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(idUser, status);
    }

    /**
     * Metodo para listar ordenes por fecha
     * @param date
     * @param idUser
     * @return
     */
    public List<Order> findByRegisterDay(String date, Integer idUser){
        return orderCrudRepository.findByRegisterDayContainsAndSalesManId(date, idUser);
    }

    /**
     * Metodo para traer una orden por id de asesor
     * @param id
     * @return
     */
    public List<Order> findBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }
}