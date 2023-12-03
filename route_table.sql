create table route(
    id_route int not null auto_increment, 
    time_traveled time not null, 
    starting_station varchar(30) not null,
	ending_station varchar(30) not null, 
	distance_traveled int not null,
    constraint route_pk primary key(id_route)
);