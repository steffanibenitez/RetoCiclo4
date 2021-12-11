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
     * Atributo objeto 'userRepository' instancia de la clase
     * 'UserRepository'
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Metodo para obtener y retornar una lista de todos los registros 
     * de documentos de cuentas de usuario hacia el metodo 'getAll' del 
     * UserRepository
     * @return 
     */
    public List<User> getAll(){
        return userRepository.getAll();
    }
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario por el valor de su atributo 'id', hacia el metodo 'getUserById' 
     * del UserRepository
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
    /**
     * Metodo para guardar y retornar una registro de documento de cuenta de 
     * usuario hacia el metodo 'save' del UserRepository
     * @param user
     * @return 
     */
    public User save(User user) {
        Optional<User> userWithLastId = userRepository.getUserWithLastId();
        if(user.getId() == null) {
            if(userWithLastId.isEmpty())
                user.setId(1);
            else
                user.setId(userWithLastId.get().getId() + 1);
        }
        if(user.getIdentification() == null || user.getName() == null || user.getEmail() == null || 
                user.getPassword() == null || user.getAddress() == null || user.getCellPhone() == null || 
                user.getZone() == null || user.getType() == null) {
            return user;
        }
        else {
            List<User> existUserByNameOrEmail = userRepository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            if(existUserByNameOrEmail.isEmpty()) {
                if(user.getId() == null) {
                    return userRepository.save(user);
                }
                else {
                    Optional<User> existUserById = userRepository.getUserById(user.getId());
                    if(existUserById.isEmpty()) {
                        return userRepository.save(user);
                    }
                    else {
                        return user;
                    }
                }
            }
            else {
                return user;
            }
        }
    }
    /**
     * Metodo para actualizar y retornar un registro de documento de cuenta 
     * de usuario hacia el metodo 'update' del UserRepository
     * @param user
     * @return 
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userOptional = userRepository.getUserById(user.getId());
            if (!userOptional.isEmpty()) {
                if (user.getIdentification() != null) {
                    userOptional.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userOptional.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null) {
                    userOptional.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null) {
                    userOptional.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userOptional.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userOptional.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userOptional.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userOptional.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userOptional.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userOptional.get().setType(user.getType());
                }                
                userRepository.update(userOptional.get());
                return userOptional.get();
            } 
            else {
                return user;
            }
        } 
        else {
            return user;
        }
    }
    /**
     * Metodo para eliminar y retornar un registro de documento de cuenta de 
     * usuario hacia el metodo 'delete' del UserRepository
     * @param id
     * @return 
     */
    public boolean delete(Integer id) {
        Optional<User> userOptional = userRepository.getUserById(id);
        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Metodo para validar y retornar un valor booleano que indica si un
     * registro de documento de cuenta de usuario existe, buscandolo a partir 
     * del atributo 'email' del registro, hacia el metodo 'emailExist' del
     * UserRepository
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }
    /**
     * Metodo para obtener y retornar un registro de documento de cuenta de 
     * usuario, buscandolo a partir de los atributos 'email' y 'password' del 
     * registro, hacia el metodo query 'authenticateUser' del UserRepository
     * @param email
     * @param password
     * @return 
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de su atributo 'email', hacia el metodo 'findByEmail' del 
     * UserRepository
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email) {
        return userRepository.getUserByEmail(email).isPresent();
    }
    /**
     * Metodo para obtener y retornar un registro de cuenta de usuario por
     * el valor de sus atributos 'email' y 'password', hacia el metodo 
     * 'findByEmailAndPassword' del UserRepository
     * @param email
     * @param password
     * @return 
     */
    public User getUserEmailAndPassword(String email, String password) {
        Optional<User> userExist = userRepository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()) {
            return userExist.get();
        }
        else {
            return new User();
        }
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean verifyEmail(String email) {
        boolean flag = false;
        List<User> users = userRepository.getAll();
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Metodo para verificar si un usuario existe en la base de datos
     *
     * @param email
     * @param pass
     * @return
     */
    public User verifyUser(String email, String pass) {
        List<User> users = userRepository.getAll();
        User notExit = User.builder().build();
        for (User user : users) {
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())) {
                return user;
            }
        }
        return notExit;
    }    
}