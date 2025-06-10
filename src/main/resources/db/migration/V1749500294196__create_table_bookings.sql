create table tb_bookings (
        id uuid primary key default gen_random_uuid(),
        check_in timestamp(6),
        check_out timestamp(6),
        client varchar(255),
        created_at timestamp(6),
        payment_id uuid,
        booking_status varchar(255) check(booking_status in('FINALIZADA', 'ABERTA', 'CANCELADA')),
        room_id uuid
    );