package com.turkcell.app.device.service;

import com.turkcell.app.device.data.dal.DeviceServiceAppHelper;
import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.mapper.DeviceMapper;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DeviceAppService {
	private final DeviceServiceAppHelper m_helper;
	
	private Iterable<DeviceDTO> findAllDevicesCallback()
	{
		return StreamSupport.stream(m_helper.findAllDevices().spliterator(), false)
					.map(d -> DeviceMapper.toDeviceDTO(d))
					.collect(Collectors.toList());
	}
	
	private Iterable<DeviceDTO> findDevicesByNameContainsCallback(String str)
	{
		return StreamSupport.stream(m_helper.findDeviceByNameContains(str).spliterator(), false)
					.map(d -> DeviceMapper.toDeviceDTO(d))
					.collect(Collectors.toList());
	}
	
	public DeviceAppService(DeviceServiceAppHelper helper)
	{
		m_helper = helper;
	}
	
	public Iterable<DeviceDTO> findAllDevices()
	{
		return doWorkForService(this::findAllDevicesCallback, "DeviceAppService.findAllDevices");
	}
	
	public Iterable<DeviceDTO> findDevicesByNameContains(String str)
	{
		return doWorkForService(() -> findDevicesByNameContainsCallback(str), "DeviceAppService.findDevicesByNameContains");				
	}
}
