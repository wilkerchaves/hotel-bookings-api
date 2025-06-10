create table if not exists tb_rooms (
	id uuid primary key default gen_random_uuid(),
	room_number int not null,
	
	is_occupied boolean not null,
	is_actived boolean not null,
	room_type varchar(255) check (room_type in('VENTILADOR', 'AR_CONDICIONADO'))
);