package com.turkcell.app.device.service;

import com.turkcell.app.device.data.dal.DeviceServiceAppHelper;
import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.dto.DeviceInfoDTO;
import com.turkcell.app.device.dto.DevicesDTO;
import com.turkcell.app.device.mapper.IDeviceMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class DeviceAppService {
    private final DeviceServiceAppHelper m_helper;
    private final IDeviceMapper m_mapper;

    private DevicesDTO findAllDevicesCallback()
    {
        return m_mapper.toDevicesDTO(StreamSupport.stream(m_helper.findAllDevices().spliterator(), false)
                        .map(m_mapper::toDeviceDTO)
                        .collect(Collectors.toList()));
    }

    private Iterable<DeviceInfoDTO> findAllDevicesInfoCallback()
    {
        return StreamSupport.stream(m_helper.findAllDevices().spliterator(), false)
                .map(m_mapper::toDeviceInfoDTO)
                .collect(Collectors.toList());
    }




    private Iterable<DeviceDTO> findDevicesByNameContainsCallback(String str)
    {
        return StreamSupport.stream(m_helper.findDeviceByNameContains(str).spliterator(), false)
                .map(m_mapper::toDeviceDTO)
                .collect(Collectors.toList());
    }

    private Iterable<DeviceDTO> findDevicesByNameContainsNativeCallback(String str)
    {
        return StreamSupport.stream(m_helper.findDeviceByNameContainsNative(str).spliterator(), false)
                .map(m_mapper::toDeviceDTO)
                .collect(Collectors.toList());
    }

    private DeviceDTO saveCallback(DeviceDTO deviceDTO)
    {
        m_helper.saveDevice(m_mapper.toDevice(deviceDTO));

        return deviceDTO;
    }


    public DeviceAppService(DeviceServiceAppHelper helper, IDeviceMapper mapper)
    {
        m_helper = helper;
        m_mapper = mapper;
    }

    public DevicesDTO findAllDevices()
    {
        return doWorkForService(this::findAllDevicesCallback, "DeviceAppService.findAllDevices");
    }

    public Iterable<DeviceInfoDTO> findAllDevicesInfo()
    {
        return doWorkForService(this::findAllDevicesInfoCallback, "DeviceAppService.findAllDevices");
    }

    public Iterable<DeviceDTO> findDevicesByNameContains(String str)
    {
        return doWorkForService(() -> findDevicesByNameContainsCallback(str), "DeviceAppService.findDevicesByNameContains");
    }

    public Iterable<DeviceDTO> findDevicesByNameContainsNative(String str)
    {
        return doWorkForService(() -> findDevicesByNameContainsNativeCallback(str), "DeviceAppService.findDevicesByNameContainsNative");
    }

    public DeviceDTO saveDevice(DeviceDTO deviceDTO)
    {
        return doWorkForService(() -> saveCallback(deviceDTO), "DeviceAppService.saveDevice");
    }
}
