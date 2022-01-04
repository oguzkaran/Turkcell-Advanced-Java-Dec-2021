package com.turkcell.app.device.mapper;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.dto.DeviceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(implementationName = "DeviceMapperImpl")
public interface IDeviceMapper {
    @Mappings(@Mapping(source = "name", target = "deviceName"))
    DeviceDTO toDeviceDTO(Device device);

    @Mappings(@Mapping(source = "deviceName", target = "name"))
    Device toDevice(DeviceDTO deviceDTO);
}
