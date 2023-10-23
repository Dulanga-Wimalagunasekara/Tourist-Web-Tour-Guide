create table payment
(
    payment_id   int auto_increment
        primary key,
    payment_date datetime not null
);

create table staff
(
    staff_id   int auto_increment
        primary key,
    first_name varchar(50)  not null,
    last_name  varchar(50)  null,
    dob        date         not null,
    address    varchar(200) not null,
    email      varchar(100) not null,
    role       varchar(20)  not null,
    username   varchar(100) not null,
    password   varchar(100) not null
);

create table tour
(
    tour_id     int auto_increment
        primary key,
    location    varchar(100)  not null,
    price       int           not null,
    no_of_days  int           not null,
    description varchar(1000) not null,
    no_of_pax   int           not null
);

create table review_and_rating
(
    review_id   int auto_increment,
    no_of_stars int           not null,
    comment     varchar(1000) not null,
    tour_id     int           not null,
    primary key (review_id, tour_id),
    constraint review_and_rating_tour_tour_id_fk
        foreign key (tour_id) references tour (tour_id)
);

create table tour_guide
(
    tourguide_id int auto_increment
        primary key,
    first_name   varchar(50)  not null,
    last_name    varchar(50)  not null,
    address      varchar(200) not null,
    dob          date         not null,
    email        varchar(100) not null,
    username     varchar(100) not null,
    password     varchar(100) not null
);

create table tourist
(
    tourist_id int auto_increment
        primary key,
    first_name varchar(50)  not null,
    last_name  varchar(50)  not null,
    address    varchar(200) not null,
    dob        date         not null,
    email      varchar(100) not null,
    username   varchar(100) not null,
    password   varchar(100) not null
);

create table book_tour
(
    book_id       int auto_increment
        primary key,
    date          datetime not null,
    tourist_id    int      not null,
    payment_id    int      not null,
    tour_guide_id int      null,
    tour_id       int      not null,
    constraint book_tour_Tourist_tourist_id_fk
        foreign key (tourist_id) references tourist (tourist_id),
    constraint book_tour___fk
        foreign key (payment_id) references payment (payment_id),
    constraint book_tour_tour_guide_tourguide_id_fk
        foreign key (tour_guide_id) references tour_guide (tourguide_id),
    constraint book_tour_tour_tour_id_fk
        foreign key (tour_id) references tour (tour_id)
);

