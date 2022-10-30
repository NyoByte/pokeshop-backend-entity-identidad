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
@Table(name = "tb_tipo_documento", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})
public class TbTipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @Column(name = "codigo", length = 20, nullable = false)
    private String codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "longitud_minima", nullable = false)
    private Integer longitudMinima;

    @Column(name = "longitud_maxima", nullable = false)
    private Integer longitudMaxima;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "tbTipoDocumento")
    private List<TbPersona> tbPersonas = new ArrayList<>();

}