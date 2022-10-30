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
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @OneToOne(mappedBy = "tbUsuario")
    private TbProveedor tbProveedorForidProveedor;
}