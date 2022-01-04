package com.turkcell.app.device.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.turkcell.app.device.data.entity.PortInfo;

import java.util.Set;

public class DeviceInfoDTO {
    private String m_deviceName;

    private String m_host;

    private Set<PortInfo> m_ports;

    public String getDeviceName()
    {
        return m_deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        m_deviceName = deviceName;
    }

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHost()
    {
        return m_host;
    }

    public void setHost(String host)
    {
        m_host = host;
    }

    public Set<PortInfo> getPorts()
    {
        return m_ports;
    }

    public void setPorts(Set<PortInfo> ports)
    {
        m_ports = ports;
    }
}
