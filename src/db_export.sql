create table questions
(
    id    numeric      not null
        constraint questions_pkey
            primary key,
    title varchar(255) not null
);

alter table questions
    owner to postgres;

create sequence questions_id_seq;

alter sequence questions_id_seq owner to postgres;
