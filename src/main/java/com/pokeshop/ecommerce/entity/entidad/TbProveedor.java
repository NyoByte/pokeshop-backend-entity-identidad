package com.pokeshop.ecommerce.entity.entidad;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_proveedor", uniqueConstraints = {@UniqueConstraint(columnNames = {"nroDocumento"})})
public class TbProveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "tbUsuario"))
    @GeneratedValue(generator = "generator")
    @Column(name = "id_proveedor", unique = true, nullable = false)
    private Integer idProveedor;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private TbUsuario tbUsuario;

    @Column(name = "nroDocumento", length = 11, nullable = false)
    private String nroDocumento;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 250, nullable = false)
    private String direccion;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public void setTbUsuario(TbUsuario tbUsuario) {
        this.tbUsuario = tbUsuario;
        this.idProveedor = tbUsuario.getIdUsuario();
    }

}