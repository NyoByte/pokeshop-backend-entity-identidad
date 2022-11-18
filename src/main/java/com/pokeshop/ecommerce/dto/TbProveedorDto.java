package com.pokeshop.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pokeshop.ecommerce.entity.entidad.TbProveedor;
import com.pokeshop.ecommerce.util.EntityDto;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class TbProveedorDto extends RepresentationModel<TbProveedorDto> implements EntityDto<TbProveedor, TbProveedorDto>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProveedor;
    @JsonIgnore
    @Builder.Default
    private boolean defIdProveedor = true;

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

    private String direccion;
    @JsonIgnore
    @Builder.Default
    private boolean defDireccion = true;

    private String email;
    @JsonIgnore
    @Builder.Default
    private boolean defEmail = true;

    private Boolean estado;
    @JsonIgnore
    @Builder.Default
    private boolean defEstado = true;

    public static TbProveedorDto build() {
        return TbProveedorDto.builder().build();
    }

    @Override
    public TbProveedorDto fromEntity(TbProveedor entity) {
        return fromEntity(this, entity);
    }

    @Override
    public TbProveedorDto fromEntity(TbProveedorDto template, TbProveedor entity) {
        if (entity != null) {
            TbProveedorDto dto = TbProveedorDto.builder().build();

            if (template.isDefIdProveedor()) {
                dto.setIdProveedor(entity.getIdProveedor());
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
            if (template.isDefDireccion()) {
                dto.setDireccion(entity.getDireccion());
            }
            if (template.isDefEmail()) {
                dto.setEmail(entity.getEmail());
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
    public TbProveedor toEntity() {
        return TbProveedor.builder()
                .idProveedor(this.getIdProveedor())
                .tbUsuario(this.getTbUsuario() != null ? this.getTbUsuario().toEntity() : null)
                .nroDocumento(this.getNroDocumento())
                .nombre(this.getNombre())
                .direccion(this.getDireccion())
                .email(this.getEmail())
                .estado(this.getEstado())
                .build();
    }

}