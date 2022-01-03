create table devices (
    device_id serial primary key,
    name varchar(100) not null,
    host char(15) not null
);

create table ports (
    port_id bigserial primary key,
    device_id int references devices(device_id),
    port_num int check(1023 < port_num and port_num < 65536) not null
);


