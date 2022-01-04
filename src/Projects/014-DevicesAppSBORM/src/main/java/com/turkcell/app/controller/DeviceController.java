package com.turkcell.app.controller;

import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.service.DeviceAppService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/devices")
public class DeviceController {
    private final DeviceAppService m_deviceAppService;

    public DeviceController(DeviceAppService deviceAppService)
    {
        m_deviceAppService = deviceAppService;
    }

    @GetMapping("/all")
    public Iterable<DeviceDTO> findAllDevices()
    {
        return m_deviceAppService.findAllDevices();
    }

    @GetMapping("/contains")
    public Iterable<DeviceDTO> findDevicesByNameContains(String text)
    {
        return m_deviceAppService.findDevicesByNameContains(text);
    }

    @GetMapping("/ncontains")
    public Iterable<DeviceDTO> findDevicesByNameContainsNative(String text)
    {
        return m_deviceAppService.findDevicesByNameContainsNative(text);
    }
}
