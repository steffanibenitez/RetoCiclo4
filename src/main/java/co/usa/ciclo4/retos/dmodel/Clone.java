package co.usa.ciclo4.retos.dmodel;
/**
 * Importaciones
 */
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @author IngSB
 */
/**
 * Clase Modelo Documento Clone
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clone")
public class Clone {
    /**
     * Atributo 'id' del Documento
     */
    @Id
    private Integer id;
    /**
     * Atributo 'brand' del Documento
     */
    private String brand;
    /**
     * Atributo 'procesor' del Documento
     */    
    private String procesor;
    /**
     * Atributo 'os' del Documento
     */    
    private String os;
    /**
     * Atributo 'description' del Documento
     */    
    private String description;
    /**
     * Atributo 'memory' del Documento
     */    
    private String memory;
    /**
     * Atributo 'hardDrive' del Documento
     */    
    private String hardDrive;
    /**
     * Atributo 'availability' del Documento
     */    
    private boolean availability = true;
    /**
     * Atributo 'price' del Documento
     */    
    private double price;
    /**
     * Atributo 'quantity' del Documento
     */    
    private int quantity;
    /**
     * Atributo 'photography' del Documento
     */    
    private String photography;
}