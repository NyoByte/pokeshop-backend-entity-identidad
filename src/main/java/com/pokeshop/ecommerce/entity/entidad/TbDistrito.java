package com.pokeshop.ecommerce.entity.entidad;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_distrito", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})
public class TbDistrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito")
    private Integer idDistrito;

    @Column(name = "codigo", length = 20, nullable = false)
    private String codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "tbDistrito")
    private List<TbPersona> tbPersonas = new ArrayList<>();

}