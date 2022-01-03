package com.turkcell.app.device.data.repository;

import com.turkcell.app.device.data.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface IDeviceRepository extends CrudRepository<Device, Integer> {
    Iterable<Device> findByNameContains(String str) throws Exception;
}
