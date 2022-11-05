package com.pokeshop.ecommerce.entity.entidad;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "clave", length = 80, nullable = false)
    private String clave;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @OneToOne(mappedBy = "tbUsuario")
    private TbPersona tbPersonaForidPersona;

    @OneToOne(mappedBy = "tbUsuario")
    private TbProveedor tbProveedorForidProveedor;

}