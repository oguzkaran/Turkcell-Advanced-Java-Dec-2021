package com.turkcell.app.device.data.dal;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.data.repository.IDeviceRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

@Component
public class DeviceServiceAppHelper {
	private final IDeviceRepository m_deviceRepository;


	public DeviceServiceAppHelper(IDeviceRepository deviceRepository)
	{
		m_deviceRepository = deviceRepository;
	}

	public Iterable<Device> findAllDevices()
	{
		return doWorkForRepository(m_deviceRepository::findAll, "DeviceServiceAppHelper.findAll");				
	}
	
	public Iterable<Device> findDeviceByNameContains(String str)
	{
		return doWorkForRepository(() -> m_deviceRepository.findByNameContains(str), "DeviceServiceAppHelper.findDeviceByNameContains");
	}

	public Iterable<Device> findDeviceByNameContainsNative(String str)
	{
		return doWorkForRepository(() -> m_deviceRepository.findByNameContainsNative(str), "DeviceServiceAppHelper.findDeviceByNameContainsNative");
	}
	
	//...
}
