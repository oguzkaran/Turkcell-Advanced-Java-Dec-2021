package com.turkcell.app.configuration;

import com.turkcell.app.device.mapper.IDeviceMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public IDeviceMapper getDeviceMapper()
    {
        return Mappers.getMapper(IDeviceMapper.class);
    }
}
