package Esfe.Aurora.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String telefono;
    private String email;

    

    public Cliente() {
    }

    public Cliente(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters
    public Integer getIdCliente() {
        return idCliente;
    }
    // Setters
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}