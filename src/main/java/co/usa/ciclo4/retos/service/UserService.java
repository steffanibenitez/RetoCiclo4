package co.usa.ciclo4.retos.service;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.User;
import co.usa.ciclo4.retos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author IngSB
 */
/**
 * Clase Servicio 'UserService'
 */
@Service
public class UserService {
     /**
     * Atributo autowired para usuario
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Metodo para obtener todos los usuarios
     * @return userRepository
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }

    /**
     * Metodo para traer un usuario por id
     * @param id
     * @return
     */
    public Optional getUserById(int id){
        return userRepository.getUserById(id);
    }

    /**
     * Guardar un usuario en la base de datos
     * @param user
     * @return user Devuelve el usuario actualizado.
     */
    public User save(User user){

        List<User> users = userRepository.getAll();
        Integer idAuto = users.size();
        idAuto++;
        Optional<User> exist = userRepository.getUserById(idAuto);
        if (exist.isPresent()){
            return user;
        }
        if (user.getId() == null){
            user.setId(idAuto);
        }
        if (users.size() == 0){
            return userRepository.save(user);
        }else if (getByEmail(user.getEmail()) == false) {
            return userRepository.save(user);
        }
        return user;
    }

    /**
     * Validar si un usuario existe en la base de datos
     * @param email
     * @return flag Devuelve el valor booleano actualizado
     */
    public boolean getByEmail(String email){

        List<User> users = userRepository.getAll();
        boolean flag = false;

        for (User user: users) {
            if(email.equals(user.getEmail())){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Autentificar si un usuario existe en la base de datos
     * @param email
     * @param pass
     * @return noExiste Devuelve el valor indefinido cuando el usuario no existe en la base de datos
     */
    public User getByEmailPass(String email, String pass){
        List<User> users = userRepository.getAll();
        User noExiste = new User();

        for (User user: users) {
            if(email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return noExiste;
    }

    /**
     * Borrar un usuario por id en la base de datos
     * @param idUser
     */
    public void delete (Integer idUser){
        Optional<User> user = userRepository.getUserById(idUser);
        if(user.isPresent()){
            userRepository.deleteById(idUser);
        }
    }

    /**
     * Actualizar un usuario de la base de datos
     * @param user
     * @return
     */

    public User userUpdate(User user){
        Optional<User> exist = userRepository.getUserById(user.getId());
        if(exist.isPresent()) {
            if (user.getIdentification() != null) {
                exist.get().setIdentification(user.getIdentification());
            }
            if(user.getName() != null){
                exist.get().setName(user.getName());
            }
            if(user.getAddress() != null){
                exist.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone() != null){
                exist.get().setCellPhone(user.getCellPhone());
            }
            if(user.getEmail() != null){
                exist.get().setEmail(user.getEmail());
            }
            if(user.getPassword() != null){
                exist.get().setPassword(user.getPassword());
            }
            if(user.getZone() != null){
                exist.get().setZone(user.getZone());
            }
            if(user.getType() != null){
                exist.get().setType(user.getType());
            }
            return userRepository.save(exist.get());
        }
        return user;
    }

    /**
     * metodo para buscar por identificacion del usuario
     * @param identificacion
     * @return
     */
    public Optional<User> getbyidentificacion(String identificacion) {

        return userRepository.findByIdentificacion(identificacion);
    }

    /**
     * Método para listar usuarios por mes de cumpleaños
     *
     * @param month
     * @return
     */
    public List<User> userByMonth(String month) {
        return userRepository.findByMonth(month);
    }
}