package com.pokeshop.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pokeshop.ecommerce.entity.entidad.TbPersona;
import com.pokeshop.ecommerce.entity.enumerado.EnumEstadoCivil;
import com.pokeshop.ecommerce.entity.enumerado.EnumGenero;
import com.pokeshop.ecommerce.util.EntityDto;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class TbPersonaDto extends RepresentationModel<TbPersonaDto> implements EntityDto<TbPersona, TbPersonaDto>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idPersona;
    @JsonIgnore
    @Builder.Default
    private boolean defIdPersona = true;

    private TbUsuarioDto tbUsuario;
    @JsonIgnore
    @Builder.Default
    private TbUsuarioDto defTbUsuario = null;

    private String nroDocumento;
    @JsonIgnore
    @Builder.Default
    private boolean defNroDocumento = true;

    private String nombre;
    @JsonIgnore
    @Builder.Default
    private boolean defNombre = true;

    private String apellido1;
    @JsonIgnore
    @Builder.Default
    private boolean defApellido1 = true;

    private String apellido2;
    @JsonIgnore
    @Builder.Default
    private boolean defApellido2 = true;

    private String direccion;
    @JsonIgnore
    @Builder.Default
    private boolean defDireccion = true;

    private String celular;
    @JsonIgnore
    @Builder.Default
    private boolean defCelular = true;

    private String email;
    @JsonIgnore
    @Builder.Default
    private boolean defEmail = true;

    private String genero;
    @JsonIgnore
    @Builder.Default
    private boolean defGenero = true;

    private String estadoCivil;
    @JsonIgnore
    @Builder.Default
    private boolean defEstadoCivil = true;

    private LocalDate fechaNacimiento;
    @JsonIgnore
    @Builder.Default
    private boolean defFechaNacimiento = true;

    private String redSocial;
    @JsonIgnore
    @Builder.Default
    private boolean defRedSocial = true;

    private TbTipoDocumentoDto tbTipoDocumento;
    @JsonIgnore
    @Builder.Default
    private TbTipoDocumentoDto defTbTipoDocumento = null;

    private TbDistritoDto tbDistrito;
    @JsonIgnore
    @Builder.Default
    private TbDistritoDto defTbDistrito = null;

    private Boolean estado;
    @JsonIgnore
    @Builder.Default
    private boolean defEstado = true;

    public static TbPersonaDto build() {
        return TbPersonaDto.builder().build();
    }

    @Override
    public TbPersonaDto fromEntity(TbPersona entity) {
        return fromEntity(this, entity);
    }

    @Override
    public TbPersonaDto fromEntity(TbPersonaDto template, TbPersona entity) {
        if (entity != null) {
            TbPersonaDto dto = TbPersonaDto.builder().build();

            if (template.isDefIdPersona()) {
                dto.setIdPersona(entity.getIdPersona());
            }
            if (template.getDefTbUsuario() != null) {
                dto.setTbUsuario(TbUsuarioDto.build().fromEntity(template.getDefTbUsuario(), entity.getTbUsuario()));
                dto.setDefTbUsuario(template.getDefTbUsuario());
            }
            if (template.isDefNroDocumento()) {
                dto.setNroDocumento(entity.getNroDocumento());
            }
            if (template.isDefNombre()) {
                dto.setNombre(entity.getNombre());
            }
            if (template.isDefApellido1()) {
                dto.setApellido1(entity.getApellido1());
            }
            if (template.isDefApellido2()) {
                dto.setApellido2(entity.getApellido2());
            }
            if (template.isDefDireccion()) {
                dto.setDireccion(entity.getDireccion());
            }
            if (template.isDefCelular()) {
                dto.setCelular(entity.getCelular());
            }
            if (template.isDefEmail()) {
                dto.setEmail(entity.getEmail());
            }
            if (template.isDefGenero()) {
                dto.setGenero(entity.getGenero().getValue());
            }
            if (template.isDefEstadoCivil()) {
                dto.setEstadoCivil(entity.getEstadoCivil().getValue());
            }
            if (template.isDefFechaNacimiento()) {
                dto.setFechaNacimiento(entity.getFechaNacimiento());
            }
            if (template.isDefRedSocial()) {
                dto.setRedSocial(entity.getRedSocial());
            }
            if (template.getDefTbTipoDocumento() != null) {
                dto.setTbTipoDocumento(TbTipoDocumentoDto.build().fromEntity(template.getDefTbTipoDocumento(), entity.getTbTipoDocumento()));
                dto.setDefTbTipoDocumento(template.getDefTbTipoDocumento());
            }
            if (template.getDefTbDistrito() != null) {
                dto.setTbDistrito(TbDistritoDto.build().fromEntity(template.getDefTbDistrito(), entity.getTbDistrito()));
                dto.setDefTbDistrito(template.getDefTbDistrito());
            }
            if (template.isDefEstado()) {
                dto.setEstado(entity.getEstado());
            }
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public TbPersona toEntity() {
        return TbPersona.builder()
                .idPersona(this.getIdPersona())
                .tbUsuario(this.getTbUsuario() != null ? this.getTbUsuario().toEntity() : null)
                .nroDocumento(this.getNroDocumento())
                .nombre(this.getNombre())
                .apellido1(this.getApellido1())
                .apellido2(this.getApellido2())
                .direccion(this.getDireccion())
                .celular(this.getCelular())
                .email(this.getEmail())
                .genero(EnumGenero.getEnumByValue(this.getGenero()))
                .estadoCivil(EnumEstadoCivil.getEnumByValue(this.getEstadoCivil()))
                .fechaNacimiento(this.getFechaNacimiento())
                .redSocial(this.getRedSocial())
                .tbTipoDocumento(this.getTbTipoDocumento() != null ? this.getTbTipoDocumento().toEntity() : null)
                .tbDistrito(this.getTbDistrito() != null ? this.getTbDistrito().toEntity() : null)
                .estado(this.getEstado())
                .build();
    }

}