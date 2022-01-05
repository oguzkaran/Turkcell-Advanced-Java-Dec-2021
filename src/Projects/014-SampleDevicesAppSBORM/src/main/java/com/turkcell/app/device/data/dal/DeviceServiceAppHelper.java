package com.turkcell.app.device.data.dal;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.data.repository.IDeviceRepository;
import com.turkcell.app.device.data.repository.IPortRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

@Component
public class DeviceServiceAppHelper {
	private final IDeviceRepository m_deviceRepository;
	private final IPortRepository m_portRepository;

	public DeviceServiceAppHelper(IDeviceRepository deviceRepository, IPortRepository portRepository)
	{
		m_deviceRepository = deviceRepository;
		m_portRepository = portRepository;
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

	public Device saveDevice(Device device)
	{
		return doWorkForRepository(() -> m_deviceRepository.save(device), "DeviceServiceAppHelper.saveDevice");
	}
	
	//...
}
