package com.turkcell.app.device.data.dal;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.data.entity.PortInfo;
import com.turkcell.app.device.data.repository.IDeviceRepository;
import com.turkcell.app.device.data.repository.IPortRepository;

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
	
	public Iterable<PortInfo> findPortsByDeviceId(int id)
	{
		return doWorkForRepository(() -> m_portRepository.findByDeviceId(id), "DeviceServiceAppHelper.findPortsByDeviceId");
	}
	
	//...
}
