package com.turkcell.app.device.mapper;

import com.turkcell.app.device.data.entity.PortInfo;
import com.turkcell.app.device.dto.PortInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(implementationName = "PortMapperImpl", componentModel = "spring")
public interface IPortMapper {
    @Mappings(@Mapping(source = "num", target = "portNo"))
    PortInfoDTO toPortInfoDTO(PortInfo portInfo);

    @Mappings(@Mapping(source = "portNo", target = "num"))
    PortInfo toPortInfo(PortInfoDTO portInfoDTO);

    @Mappings(@Mapping(source = "portNo", target = "num"))
    Set<PortInfoDTO> toPortInfoDTOs(Set<PortInfo> portInfoDTO);
}
