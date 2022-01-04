package com.turkcell.app.device.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ports")
public class PortInfo { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "port_id")
    public long id;

    @Column(name = "port_num", nullable = false)
    public int num;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    public Device device;

    @Transient
    public int deviceId;
}
