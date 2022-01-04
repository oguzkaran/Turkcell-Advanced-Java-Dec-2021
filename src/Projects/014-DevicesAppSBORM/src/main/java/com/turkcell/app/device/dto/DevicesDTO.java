package com.turkcell.app.device.dto;

import com.turkcell.app.device.data.entity.Device;

import java.util.List;

public class DevicesDTO {
    private List<DeviceDTO> m_devices;

    public List<DeviceDTO> getDevices()
    {
        return m_devices;
    }

    public void setDevices(List<DeviceDTO> devices)
    {
        m_devices = devices;
    }
}
