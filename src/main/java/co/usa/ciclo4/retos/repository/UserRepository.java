package co.usa.ciclo4.retos.repository;
/**
 * Importaciones
 */
import co.usa.ciclo4.retos.dmodel.User;
import co.usa.ciclo4.retos.icrudrepository.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @author IngSB
 */
/**
 * Clase Repositorio 'UserRepository'
 */
@Repository
public class UserRepository {
 
    /**
     * atributo para user
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Metodo para obtener cada usuario por Id
     * @param idUser
     * @return
     */
    public Optional<User> getUserById(int idUser){
        return userCrudRepository.findById(idUser);
    }

    /**
     * Método para obtener a todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Método para guardar un usuario
     * @param user
     * @return userCrudRepository.save(user)
     */
    public User save(User user){
        return userCrudRepository.save(user);
    }

    /**
     * Metodo para borrar un usuario por Id
     * @param idUser
     */
    public void deleteById (Integer idUser){
        userCrudRepository.deleteById(idUser);
    }


    /**
     * Metodo para buscar por identificacion de usuario
     * @param identificacion
     * @return
     */
    public Optional<User> findByIdentificacion(String identificacion){
        return userCrudRepository.findByIdentificacion(identificacion);
    }

    /**
     * Metodo para listar usuarios por mes
     * @param month
     * @return
     */
    public List<User> findByMonth (String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }

}
