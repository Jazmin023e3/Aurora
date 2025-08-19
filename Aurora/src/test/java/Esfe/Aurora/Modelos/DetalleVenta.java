package Esfe.Aurora.Modelos;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    private Venta venta; // Relación con la clase Venta

    @ManyToOne
    @JoinColumn(name = "idAnillo", referencedColumnName = "idAnillo")
    private Anillo anillo; // Relación con la clase Anillo

    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

}