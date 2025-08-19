package Esfe.Aurora.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "anillos")
public class Anillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnillo;

    private String nombre;
    private String material;
    private String piedra;
    private String talla;
    private BigDecimal peso;
    private BigDecimal precio;
    private Integer stock;

    
    public Anillo() {
    }

    
    public Anillo(String nombre, String material, String piedra, String talla, BigDecimal peso, BigDecimal precio, Integer stock) {
        this.nombre = nombre;
        this.material = material;
        this.piedra = piedra;
        this.talla = talla;
        this.peso = peso;
        this.precio = precio;
        this.stock = stock;
    }

  
    public Integer getIdAnillo() {
        return idAnillo;
    }
 
    public void setIdAnillo(Integer idAnillo) {
        this.idAnillo = idAnillo;
    }

    
}

