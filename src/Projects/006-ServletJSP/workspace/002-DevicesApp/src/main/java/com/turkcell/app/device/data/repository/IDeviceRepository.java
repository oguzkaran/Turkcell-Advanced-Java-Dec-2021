package com.turkcell.app.device.data.repository;

import org.csystem.util.data.repository.ICrudRepository;

import com.turkcell.app.device.data.entity.Device;

public interface IDeviceRepository extends ICrudRepository<Device, Integer> {
	Iterable<Device> findByNameContains(String str) throws Exception;
}
