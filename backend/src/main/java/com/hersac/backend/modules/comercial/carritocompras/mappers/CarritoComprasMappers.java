package com.hersac.backend.modules.comercial.carritocompras.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.hersac.backend.modules.comercial.carritocompras.dto.CrearCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.dto.ResponseCarritoCompras;
import com.hersac.backend.modules.comercial.carritocompras.models.CarritoCompras;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CarritoComprasMappers {

	@Mapping(target = "carritoId", ignore = true)
	@Mapping(target = "usuarioId", ignore = true)
	CarritoCompras toEntity(CrearCarritoCompras dto);

	@Mapping(target = "id", source = "carritoId")
	ResponseCarritoCompras toDto(CarritoCompras entity);

	List<ResponseCarritoCompras> toDto(List<CarritoCompras> entities);

}
