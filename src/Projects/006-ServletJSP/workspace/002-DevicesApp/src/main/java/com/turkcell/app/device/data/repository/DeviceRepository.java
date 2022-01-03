package com.turkcell.app.device.data.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.csystem.util.data.repository.RepositoryException;

import com.turkcell.app.device.data.entity.Device;

import static com.turkcell.app.device.data.repository.Global.*;

public class DeviceRepository implements IDeviceRepository {	
	private static final String FIND_ALL_SQL_CMD = "select * from devices";
	
	private static Device getDevice(ResultSet rs) throws SQLException
	{
		return new Device(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	@Override
	public Iterable<Device> findAll()
	{
		List<Device> devices = new ArrayList<>();
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				Statement stmt = conn.createStatement()) {
			var rs = stmt.executeQuery(FIND_ALL_SQL_CMD);
			
			while (rs.next()) 
				devices.add(getDevice(rs));
			
			return devices;			
			
		}			
		catch (Throwable ex) {
			throw new RepositoryException("findAll", ex);
		}
	}
	
	///////////////////////////////////////////////////////////////////////
	@Override
	public long count() 
	{
		throw new UnsupportedOperationException("count");
	}

	@Override
	public void delete(Device entity) 
	{
		throw new UnsupportedOperationException("delete");		
	}

	@Override
	public void deleteAll()
	{
		throw new UnsupportedOperationException("deleteAll");		
	}

	@Override
	public void deleteAll(Iterable<? extends Device> entities) 
	{
		throw new UnsupportedOperationException("deleteAll");		
	}

	@Override
	public void deleteById(Integer id) 
	{
		throw new UnsupportedOperationException("deleteById");		
	}

	@Override
	public boolean existsById(Integer id)
	{
		throw new UnsupportedOperationException("existsById");
	}

	

	@Override
	public Iterable<Device> findAllById(Iterable<Integer> ids) 
	{
		throw new UnsupportedOperationException("findAllById");
	}

	@Override
	public Optional<Device> findById(Integer id) 
	{
		throw new UnsupportedOperationException("findById");
	}

	@Override
	public <S extends Device> S save(S entity) 
	{
		throw new UnsupportedOperationException("save");
	}

	@Override
	public <S extends Device> Iterable<S> save(Iterable<S> entities) 
	{
		throw new UnsupportedOperationException("save");
	}

	@Override
	public Iterable<Device> findDeviceByNameContains(String str) 
	{
		throw new UnsupportedOperationException("findDeviceByNameContains");
	}
	
}
