create table authors(
    id bigint not null auto_increment,
    name varchar(255),
    day_of_birth datetime,
    primary key (id)
) engine=InnoDB

GO
