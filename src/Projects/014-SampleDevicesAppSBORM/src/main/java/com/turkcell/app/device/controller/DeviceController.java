package com.turkcell.app.device.controller;

import com.turkcell.app.device.dto.DeviceDTO;
import com.turkcell.app.device.dto.DeviceInfoDTO;
import com.turkcell.app.device.dto.DevicesDTO;
import com.turkcell.app.device.error.ErrorInfo;
import com.turkcell.app.device.service.DeviceAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.csystem.util.exception.ExceptionUtil.subscribe;

@RestController
@RequestMapping("api/devices")
public class DeviceController {
    private final DeviceAppService m_deviceAppService;

    public DeviceController(DeviceAppService deviceAppService)
    {
        m_deviceAppService = deviceAppService;
    }

    @GetMapping("/all")
    public DevicesDTO findAllDevices()
    {
        return m_deviceAppService.findAllDevices();
    }

    @GetMapping("/info/all")
    public Iterable<DeviceInfoDTO> findAllDevicesInfo()
    {
        return m_deviceAppService.findAllDevicesInfo();
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

    @PostMapping("/device/save")
    public DeviceDTO saveDevice(@RequestBody DeviceDTO deviceDTO)
    {
        return m_deviceAppService.saveDevice(deviceDTO);
    }

    @PostMapping("/device/resave")
    public ResponseEntity<Object> saveDeviceRE(@RequestBody DeviceDTO deviceDTO)
    {
        return subscribe(() -> ResponseEntity.ok(m_deviceAppService.saveDevice(deviceDTO)),
                ex -> new ResponseEntity<>(new ErrorInfo(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST));
    }
}
