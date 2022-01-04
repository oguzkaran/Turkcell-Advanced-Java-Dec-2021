package com.turkcell.app.device.data.repository;

import com.turkcell.app.device.data.entity.PortInfo;
import org.springframework.data.repository.CrudRepository;

public interface IPortRepository extends CrudRepository<PortInfo, Long> {

}
