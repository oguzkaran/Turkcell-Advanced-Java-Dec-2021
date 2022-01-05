package com.turkcell.app.device.mapper;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.dto.DeviceInfoDTO;
import com.turkcell.app.device.dto.DevicesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(implementationName = "DeviceMapperImpl")
public interface IDeviceMapper {
    @Mappings(@Mapping(source = "name", target = "deviceName"))
    DeviceDTO toDeviceDTO(Device device);

    @Mappings(@Mapping(source = "deviceName", target = "name"))
    Device toDevice(DeviceDTO deviceDTO);

    @Mappings({@Mapping(source = "name", target = "deviceName")})
    DeviceInfoDTO toDeviceInfoDTO(Device device);

    default DevicesDTO toDevicesDTO(List<DeviceDTO> devices)
    {
        var result = new DevicesDTO();

        result.setDevices(devices);

        return result;
    }
}
