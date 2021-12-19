package co.usa.ciclo4.retos.wcontroller;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.User;
import co.usa.ciclo4.retos.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/**
 * @author IngSB
 */
/**
 * Clase Controlador 'UserController'
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {    
 /**
     * atributo autowired para usuario
     */
    @Autowired
    private UserService userService;

    /**
     * Método para obtener a todos los usuarios de la base de datos
     * @return getAll retorna a todos los usuarios
     */
    @GetMapping("all")
    public List<User> getUsers() {
        return userService.getAll();
    }

    /**
     * Obtiene al usuario por id
     * @param idUser
     * @return
     */
    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") int idUser){
        return userService.getUserById(idUser);
    }

    /**
     * Método para guardar un usuario en base de datos
     * @param user
     * @return user Retorna al usuario actualizado
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * Obtiene al usuario por su correo.
     * @param email
     * @return Boolean Retorna un valor booleano, si existe o no el correo.
     */
    @GetMapping("emailexist/{email}")
    public boolean getEmail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }

    /**
     * Obtiene una respuesta con su email y pass, de si existe en la base de datos
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User userEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userService.getByEmailPass(email, pass);
    }

    /**
     * Actualiza a un usuario en la base de datos
     * @param user
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public User userUpdate(@RequestBody User user){
        return userService.userUpdate(user);
    }

    /**
     * Eliminar un usuario de la base de datos por Id
     * @param userId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")int userId){
        userService.delete(userId);
    }

    /**
     * Obtiene usuarios por identificacion
     * @param identificacion
     * @return
     */
    @GetMapping("identificacion/{identificacion}")
    public Optional<User> getByIdentificacion(@PathVariable("identificacion") String identificacion) {
        return userService.getbyidentificacion(identificacion);
    }
    /**
     * Método para listar usuarios cuyo mes de cumpleaños sea el ingresado
     *
     * @param month
     * @return
     */
    @GetMapping("birthday/{month}")
    public List<User> userByMonth(@PathVariable("month") String month) {
        return userService.userByMonth(month);
    }
}