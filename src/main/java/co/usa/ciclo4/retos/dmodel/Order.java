package co.usa.ciclo4.retos.dmodel;
/**
 * Importaciones
 */

import java.util.Map;
//import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author IngSB
 */
/**
 * Clase Modelo Documento User
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {
    /**
     * Atributo constante 'PENDING' del Documento
     */
    public static String PENDING = "Pendiente";
    /**
     * Atributo constante 'APROVED' del Documento
     */
    public static String APROVED = "Aprobada";
    /**
     * Atributo constante 'REJECTED' del Documento
     */
    public static String REJECTED = "Rechazada";
    /**
     * Atributo 'id' del Documento
     */
    @Id
    private Integer id;
    /**
     * Atributo 'registerDay' del Documento
     */
    private String registerDay;
    /**
     * Atributo 'status' del Documento
     */
    private String status;
    /**
     * Atributo 'salesMan' del Documento
     */
    private User salesMan;
    /**
     * Atributo 'products' del Documento
     */
    private Map<Integer, Clone> products;
    /**
     * Atributo 'qualities' del Documento
     */
    private Map<String, Integer> quantities;
}