CREATE TABLE EMPLOYEES (
    id SERIAL NOT NULL,
    full_name varchar(255),
    not_santa boolean,
    not_child boolean,
    primary key (id)
);

CREATE TABLE PAIRS (
                           id SERIAL NOT NULL,
                           santa_id int,
                           child_id int,
                           primary key (id),
                           foreign key (santa_id) references EMPLOYEES(id),
                           foreign key (child_id) references EMPLOYEES(id)
);
