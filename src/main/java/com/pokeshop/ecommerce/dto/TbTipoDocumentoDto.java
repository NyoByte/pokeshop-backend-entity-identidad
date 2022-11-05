package com.pokeshop.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyobyte.util.EntityDto;
import com.pokeshop.ecommerce.entity.entidad.TbTipoDocumento;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public class TbTipoDocumentoDto extends RepresentationModel<TbTipoDocumentoDto> implements EntityDto<TbTipoDocumento, TbTipoDocumentoDto>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idTipoDocumento;
    @JsonIgnore
    @Builder.Default
    private boolean defIdTipoDocumento = true;

    private String codigo;
    @JsonIgnore
    @Builder.Default
    private boolean defCodigo = true;

    private String nombre;
    @JsonIgnore
    @Builder.Default
    private boolean defNombre = true;

    private String descripcion;
    @JsonIgnore
    @Builder.Default
    private boolean defDescripcion = true;

    private Integer longitudMinima;
    @JsonIgnore
    @Builder.Default
    private boolean defLongitudMinima = true;

    private Integer longitudMaxima;
    @JsonIgnore
    @Builder.Default
    private boolean defLongitudMaxima = true;

    private Boolean estado;
    @JsonIgnore
    @Builder.Default
    private boolean defEstado = true;

    public TbTipoDocumentoDto(Integer idTipoDocumento, String codigo, String nombre, String descripcion, Integer longitudMinima, Integer longitudMaxima, Boolean estado) {
        this.idTipoDocumento = idTipoDocumento;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.longitudMinima = longitudMinima;
        this.longitudMaxima = longitudMaxima;
        this.estado = estado;
    }

    public static TbTipoDocumentoDto build() {
        return TbTipoDocumentoDto.builder().build();
    }

    @Override
    public TbTipoDocumentoDto fromEntity(TbTipoDocumento entity) {
        return fromEntity(this, entity);
    }

    @Override
    public TbTipoDocumentoDto fromEntity(TbTipoDocumentoDto template, TbTipoDocumento entity) {
        if (entity != null) {
            TbTipoDocumentoDto dto = TbTipoDocumentoDto.builder().build();

            if (template.isDefIdTipoDocumento()) {
                dto.setIdTipoDocumento(entity.getIdTipoDocumento());
            }
            if (template.isDefCodigo()) {
                dto.setCodigo(entity.getCodigo());
            }
            if (template.isDefNombre()) {
                dto.setNombre(entity.getNombre());
            }
            if (template.isDefDescripcion()) {
                dto.setDescripcion(entity.getDescripcion());
            }
            if (template.isDefLongitudMinima()) {
                dto.setLongitudMinima(entity.getLongitudMinima());
            }
            if (template.isDefLongitudMaxima()) {
                dto.setLongitudMaxima(entity.getLongitudMaxima());
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
    public TbTipoDocumento toEntity() {
        return TbTipoDocumento.builder()
                .idTipoDocumento(this.getIdTipoDocumento())
                .codigo(this.getCodigo())
                .nombre(this.getNombre())
                .descripcion(this.getDescripcion())
                .longitudMinima(this.getLongitudMinima())
                .longitudMaxima(this.getLongitudMaxima())
                .estado(this.getEstado())
                .build();
    }

}