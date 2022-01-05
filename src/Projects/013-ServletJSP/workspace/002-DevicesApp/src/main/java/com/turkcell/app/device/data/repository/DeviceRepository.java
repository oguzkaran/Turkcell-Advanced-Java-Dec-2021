package com.turkcell.app.device.data.repository;

import static com.turkcell.app.device.data.repository.Global.PASSWORD;
import static com.turkcell.app.device.data.repository.Global.URL;
import static com.turkcell.app.device.data.repository.Global.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.turkcell.app.device.data.entity.Device;
import com.turkcell.app.device.data.entity.PortInfo;

public class DeviceRepository implements IDeviceRepository {		
	private static final String FIND_ALL_SQL_CMD = "select * from devices";
	private static final String FIND_BY_NAME_CONTAINS_SQL_CMD = "select * from devices where name like ?";
	private static final String FIND_PORTS_BY_DEVICE_ID_SQL_CMD = "select * from ports where device_id = ?";	
	private static final String SAVE_SQL_CMD = "insert into devices (name, host) values (?, ?)";	
	
	
	private static Device getDevice(ResultSet rs) throws SQLException
	{
		return new Device(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	private <S extends Device> S saveProc(Connection con, S entity) throws SQLException
	{
		try (var stmt = con.prepareStatement(SAVE_SQL_CMD, Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false); 
			stmt.setString(1, entity.name);
			stmt.setString(2, entity.host);
			
			stmt.executeUpdate();
			
			var rs = stmt.getGeneratedKeys();
			
			rs.next();
			
			entity.id = rs.getInt(1);
			
			con.commit();
			
			return entity;
		}
		catch (Throwable ex) {
			con.rollback();
			throw ex;
		}
	}

	@Override
	public Iterable<Device> findAll() throws SQLException
	{
		List<Device> devices = new ArrayList<>();
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
				var stmt = conn.createStatement()) {		
			var rs = stmt.executeQuery(FIND_ALL_SQL_CMD);
			
			while (rs.next()) 
				devices.add(getDevice(rs));
			
			return devices;			
		}		
	}
	
	@Override
	public Iterable<Device> findByNameContains(String str) throws SQLException
	{
		List<Device> devices = new ArrayList<>();
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				var stmt = conn.prepareStatement(FIND_BY_NAME_CONTAINS_SQL_CMD)) {
			stmt.setString(1, "%" + str + "%");	
			
			var rs = stmt.executeQuery();
			
			while (rs.next()) 
				devices.add(getDevice(rs));
			
			return devices;
		}
	}
	
	
	@Override
	public <S extends Device> S save(S entity) throws SQLException
	{
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			saveProc(conn, entity);
			
			return entity;
		}
	}
	
	
	private void loadPorts(Connection con, Device device) throws SQLException
	{
		try (var stmt = con.prepareStatement(FIND_PORTS_BY_DEVICE_ID_SQL_CMD)) {
			stmt.setInt(1, device.id);
			var rs = stmt.executeQuery();
			
			while (rs.next())
				device.ports.add(new PortInfo(rs.getLong(1), rs.getInt(2), rs.getInt(3)));
		}		
	}
	
	@Override
	public Iterable<Device> findAll(boolean loadPorts) throws SQLException
	{
		var devices = findAll();
		
		if (!loadPorts)
			return devices;
		
		try (var conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {			
			for (var dev : devices)
				loadPorts(conn, dev);				
		}		
		
		return devices;		
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
	public <S extends Device> Iterable<S> save(Iterable<S> entities) 
	{
		throw new UnsupportedOperationException("save");
	}	
}
