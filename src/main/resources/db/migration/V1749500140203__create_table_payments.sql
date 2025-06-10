create table if not exists tb_payments (
        id uuid primary key default gen_random_uuid(),
        moment timestamp(6),
        total numeric(38,2),
        type varchar(255) check (type in ('PIX','DINHEIRO','DEBITO','CREDITO'))
);