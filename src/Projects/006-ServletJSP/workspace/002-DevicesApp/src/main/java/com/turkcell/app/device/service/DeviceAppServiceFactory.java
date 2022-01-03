package com.turkcell.app.device.service;

import com.turkcell.app.device.data.dal.DeviceServiceAppHelper;
import com.turkcell.app.device.data.repository.DeviceRepository;
import com.turkcell.app.device.data.repository.PortRepository;

public class DeviceAppServiceFactory {
	private static final DeviceAppService SERVICE = new DeviceAppService(new DeviceServiceAppHelper(new DeviceRepository(), new PortRepository()));
	
	public static DeviceAppService getService()
	{
		return SERVICE;
	}
}
