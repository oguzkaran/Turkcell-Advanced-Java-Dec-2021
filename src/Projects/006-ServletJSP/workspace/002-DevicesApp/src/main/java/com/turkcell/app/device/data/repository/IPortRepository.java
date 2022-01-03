package com.turkcell.app.device.data.repository;

import org.csystem.util.data.repository.ICrudRepository;

import com.turkcell.app.device.data.entity.PortInfo;

public interface IPortRepository extends ICrudRepository<PortInfo, Long> {
	Iterable<PortInfo> findByDeviceId(int id);
}
