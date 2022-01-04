package com.turkcell.app.device.data.repository;

import com.turkcell.app.device.data.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IDeviceRepository extends CrudRepository<Device, Integer> {
    //@Query("select d from Device d where d.name like %:str%")
    Iterable<Device> findByNameContains(String str) throws Exception;

    @Query(value = "select * from devices where name like %:str%", nativeQuery = true)
    Iterable<Device> findByNameContainsNative(String str) throws Exception; //Örnek olarak yazıldı
}
