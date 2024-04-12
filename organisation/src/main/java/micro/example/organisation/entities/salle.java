package entities;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class salle implements Serializable  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSalle;
    private Integer Salle;

}
