package com.pokeshop.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pokeshop.ecommerce.entity.entidad.TbUsuario;
import com.pokeshop.ecommerce.utils.EntityDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class TbUsuarioDto extends RepresentationModel<TbUsuarioDto> implements EntityDto<TbUsuario, TbUsuarioDto>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;
    @JsonIgnore
    @Builder.Default
    private boolean defIdUsuario = true;

    private String email;
    @JsonIgnore
    @Builder.Default
    private boolean defEmail = true;

    private String clave;
    @JsonIgnore
    @Builder.Default
    private boolean defClave = true;

    private Boolean estado;
    @JsonIgnore
    @Builder.Default
    private boolean defEstado = true;

    @ApiModelProperty(hidden = true)
    private TbPersonaDto tbPersonaForidPersona;
    @JsonIgnore
    @Builder.Default
    private TbPersonaDto defTbPersonaForidPersona = null;

    public static TbUsuarioDto build() {
        return TbUsuarioDto.builder().build();
    }

    @Override
    public TbUsuarioDto fromEntity(TbUsuario entity) {
        return fromEntity(this, entity);
    }

    @Override
    public TbUsuarioDto fromEntity(TbUsuarioDto template, TbUsuario entity) {
        if (entity != null) {
            TbUsuarioDto dto = TbUsuarioDto.builder().build();

            if (template.isDefIdUsuario()) {
                dto.setIdUsuario(entity.getIdUsuario());
            }
            if (template.isDefEmail()) {
                dto.setEmail(entity.getEmail());
            }
            if (template.isDefClave()) {
                dto.setClave(entity.getClave());
            }
            if (template.isDefEstado()) {
                dto.setEstado(entity.getEstado());
            }
            if (template.getDefTbPersonaForidPersona() != null) {
                dto.loadTbPersonaForidPersona(template, entity);
            }
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public TbUsuario toEntity() {
        return TbUsuario.builder()
                .idUsuario(this.getIdUsuario())
                .email(this.getEmail())
                .clave(this.getClave())
                .estado(this.getEstado())
                .tbPersonaForidPersona(this.getTbPersonaForidPersona() != null ? this.getTbPersonaForidPersona().toEntity() : null)
                .build();
    }

    private void loadTbPersonaForidPersona(TbUsuarioDto template, TbUsuario entity) {
        this.setTbPersonaForidPersona(TbPersonaDto.build().fromEntity(template.getDefTbPersonaForidPersona(), entity.getTbPersonaForidPersona()));
    }

}