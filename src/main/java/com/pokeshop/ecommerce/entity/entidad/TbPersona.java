package com.pokeshop.ecommerce.entity.entidad;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.pokeshop.ecommerce.entity.enumerado.EnumEstadoCivil;
import com.pokeshop.ecommerce.entity.enumerado.EnumGenero;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"nro_documento", "celular", "email"})})
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class TbPersona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "tbUsuario"))
    @GeneratedValue(generator = "generator")
    @Column(name = "id_persona", unique = true, nullable = false)
    private Integer idPersona;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private TbUsuario tbUsuario;

    @Column(name = "nro_documento", length = 20, nullable = false)
    private String nroDocumento;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_1", length = 100, nullable = false)
    private String apellido1;

    @Column(name = "apelllido_2", length = 100)
    private String apellido2;

    @Column(name = "direccion", length = 250, nullable = false)
    private String direccion;

    @Column(name = "celular", length = 9, nullable = false)
    private String celular;

    @Column(name = "email", length = 80)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", columnDefinition = "genero", nullable = false)
    @Type(type = "pgsql_enum")
    private EnumGenero genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil", columnDefinition = "estado_civil", nullable = false)
    @Type(type = "pgsql_enum")
    private EnumEstadoCivil estadoCivil;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "red_social", length = 100)
    private String redSocial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private TbTipoDocumento tbTipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_distrito", nullable = false)
    private TbDistrito tbDistrito;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public void setTbUsuario(TbUsuario tbUsuario) {
        this.tbUsuario = tbUsuario;
        this.idPersona = tbUsuario.getIdUsuario();
    }

}