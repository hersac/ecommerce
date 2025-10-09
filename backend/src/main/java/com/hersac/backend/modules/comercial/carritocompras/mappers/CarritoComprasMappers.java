package com.hersac.backend.modules.comercial.carritocompras.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoComprasDTO;
import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;

@Repository
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarritoComprasMappers {

	@Mapping(target = "carritoId", ignore = true)
	@Mapping(target = "usuarioId", ignore = true)
	CarritoCompras toEntity(CrearCarritoComprasDTO dto);

	@Mapping(target = "id", source = "carritoId")
	ResponseCarritoComprasDTO toDto(CarritoCompras entity);

	List<ResponseCarritoComprasDTO> toDto(List<CarritoCompras> entities);

}
