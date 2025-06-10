alter table if exists tb_bookings 
       add constraint payment_id_constraint unique (payment_id);
alter table if exists tb_bookings add constraint payment_fk 
       foreign key (payment_id) 
       references tb_payments;
alter table if exists tb_bookings add constraint room_fk 
       foreign key (room_id) 
       references tb_rooms;