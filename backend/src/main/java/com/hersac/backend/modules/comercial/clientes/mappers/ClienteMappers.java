package com.hersac.backend.modules.comercial.clientes.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Repository;

import com.hersac.backend.modules.comercial.clientes.dto.CrearClienteDTO;
import com.hersac.backend.modules.comercial.clientes.dto.ResponseClienteDTO;
import com.hersac.backend.modules.comercial.clientes.models.Cliente;

@Repository
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMappers {

	@Mapping(target = "clienteId", ignore = true)
	Cliente toEntity(CrearClienteDTO dto);

	@Mapping(target = "id", source = "clienteId")
	ResponseClienteDTO toDto(Cliente entity);

	List<ResponseClienteDTO> toDto(List<Cliente> entities);

}
