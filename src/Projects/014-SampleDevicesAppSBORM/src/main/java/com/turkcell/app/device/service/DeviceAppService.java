package com.turkcell.app.device.service;

import com.turkcell.app.device.data.dal.DeviceServiceAppHelper;
import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.dto.DeviceInfoDTO;
import com.turkcell.app.device.dto.DevicesDTO;
import com.turkcell.app.device.mapper.IDeviceMapper;
import com.turkcell.app.device.mapper.IPortMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class DeviceAppService {
    private final DeviceServiceAppHelper m_helper;
    private final IDeviceMapper m_deviceMapper;
    private final IPortMapper m_portMapper;

    private DevicesDTO findAllDevicesCallback()
    {
        return m_deviceMapper.toDevicesDTO(StreamSupport.stream(m_helper.findAllDevices().spliterator(), false)
                        .map(m_deviceMapper::toDeviceDTO)
                        .collect(Collectors.toList()));
    }

    private DeviceInfoDTO findAllDevicesInfoMapCallback(Device d)
    {
        var dto = m_deviceMapper.toDeviceInfoDTO(d);
        dto.setPorts(m_portMapper.toPortInfoDTOs(d.ports));

        return dto;
    }

    private Iterable<DeviceInfoDTO> findAllDevicesInfoCallback()
    {
        return StreamSupport.stream(m_helper.findAllDevices().spliterator(), false)
                .map(this::findAllDevicesInfoMapCallback)
                .collect(Collectors.toList());
    }


    private Iterable<DeviceDTO> findDevicesByNameContainsCallback(String str)
    {
        return StreamSupport.stream(m_helper.findDeviceByNameContains(str).spliterator(), false)
                .map(m_deviceMapper::toDeviceDTO)
                .collect(Collectors.toList());
    }

    private Iterable<DeviceDTO> findDevicesByNameContainsNativeCallback(String str)
    {
        return StreamSupport.stream(m_helper.findDeviceByNameContainsNative(str).spliterator(), false)
                .map(m_deviceMapper::toDeviceDTO)
                .collect(Collectors.toList());
    }

    private DeviceDTO saveCallback(DeviceDTO deviceDTO)
    {
        m_helper.saveDevice(m_deviceMapper.toDevice(deviceDTO));

        return deviceDTO;
    }

    public DeviceAppService(DeviceServiceAppHelper helper, IDeviceMapper deviceMapper, IPortMapper portMapper)
    {
        m_helper = helper;
        m_deviceMapper = deviceMapper;
        m_portMapper = portMapper;
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
