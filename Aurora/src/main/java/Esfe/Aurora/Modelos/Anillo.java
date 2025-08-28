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

    
    public Integer getIdAnillo() {
        return idAnillo;
    }
    public void setIdAnillo(Integer idAnillo) {
        this.idAnillo = idAnillo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getPiedra() {
        return piedra;
    }
    public void setPiedra(String piedra) {
        this.piedra = piedra;
    }
    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public BigDecimal getPeso() {
        return peso;
    }
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}