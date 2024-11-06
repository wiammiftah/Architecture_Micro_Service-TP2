package ma.enset.billingservice.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.billingservice.model.Customer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy="bill")
    private List<ProductItem> productItems;
    //ceci n'est pas une entite JPA
    @Transient
    //l'attribut est dans la classe ms n'est pas represente dans la base de donnees,cad ignore par jpa
    private Customer customer;
}