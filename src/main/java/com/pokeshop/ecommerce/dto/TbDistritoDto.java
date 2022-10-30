package com.pokeshop.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyobyte.util.EntityDto;
import com.pokeshop.ecommerce.entity.entidad.TbDistrito;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class TbDistritoDto extends RepresentationModel<TbDistritoDto> implements EntityDto<TbDistrito, TbDistritoDto>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDistrito;
    @JsonIgnore
    @Builder.Default
    private boolean defIdDistrito = true;

    private String codigo;
    @JsonIgnore
    @Builder.Default
    private boolean defCodigo = true;

    private String nombre;
    @JsonIgnore
    @Builder.Default
    private boolean defNombre = true;

    private Boolean estado;
    @JsonIgnore
    @Builder.Default
    private boolean defEstado = true;

    public static TbDistritoDto build() {
        return TbDistritoDto.builder().build();
    }

    @Override
    public TbDistritoDto fromEntity(TbDistrito entity) {
        return fromEntity(this, entity);
    }

    @Override
    public TbDistritoDto fromEntity(TbDistritoDto template, TbDistrito entity) {
        if (entity != null) {
            TbDistritoDto dto = TbDistritoDto.builder().build();

            if (template.isDefIdDistrito()) {
                dto.setIdDistrito(entity.getIdDistrito());
            }
            if (template.isDefCodigo()) {
                dto.setCodigo(entity.getCodigo());
            }
            if (template.isDefNombre()) {
                dto.setNombre(entity.getNombre());
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
    public TbDistrito toEntity() {
        return TbDistrito.builder()
                .idDistrito(this.getIdDistrito())
                .codigo(this.getCodigo())
                .nombre(this.getNombre())
                .estado(this.getEstado())
                .build();
    }

}