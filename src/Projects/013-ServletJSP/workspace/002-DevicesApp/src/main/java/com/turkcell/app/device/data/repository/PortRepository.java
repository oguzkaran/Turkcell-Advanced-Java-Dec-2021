package com.turkcell.app.device.data.repository;

import java.util.Optional;

import com.turkcell.app.device.data.entity.PortInfo;

public class PortRepository implements IPortRepository {
	
	@Override
	public Iterable<PortInfo> findByDeviceId(int id) 
	{
		throw new UnsupportedOperationException("findByDeviceId");
	}
	
	@Override
	public long count() throws Exception 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(PortInfo entity) throws Exception 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void deleteAll() throws Exception 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void deleteAll(Iterable<? extends PortInfo> entities) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Long id) throws Exception
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<PortInfo> findAll() throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PortInfo> findAllById(Iterable<Long> ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PortInfo> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PortInfo> S save(S entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PortInfo> Iterable<S> save(Iterable<S> entities) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
