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

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "tbUsuario"))
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id_proveedor", unique = true, nullable = false)
    private Integer id_proveedor;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private TbUsuario tbUsuario;

    @Column(name = "nroDocumento", length = 11, nullable = false)
    private String nroDocumento;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 250, nullable = false)
    private String direccion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

}