package com.turkcell.app.device.mapper;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.dto.DeviceDTO;

public final class DeviceMapper {
	private DeviceMapper()
	{		
	}
	
	public static DeviceDTO toDeviceDTO(Device device)
	{
		return new DeviceDTO(device.name, device.host);				
	}
	
	public static Device toDevice(DeviceDTO deviceDTO)
	{
		return new Device(deviceDTO.name, deviceDTO.host);
	}
}
