create table cinema (
  cinema_id integer not null,
  address varchar(255),
  name varchar(255),
  primary key (cinema_id)
);

create table session (
  session_id integer not null,
  begin timestamp(255),
  end_session timestamp(255),
  fk_film integer,
  fk_cinema INTEGER,
  primary key (session_id)
);

create table film (
  film_id integer not null,
  duration integer not null,
  name varchar(255),
  primary key (film_id)
);

CREATE table ticket (
  ticket_id integer not null,
  client varchar(255),
  price integer not null,
  fk_session INTEGER,
  primary key (ticket_id)
);

alter table session
  add constraint FK7lopu8ddkvxay44n9wd4b29arj
foreign key (fk_cinema)
references cinema;

alter table session
  add constraint FK4kpkrk0fm1ja6b6swvrfkr2aa
foreign key (fk_film)
references film;

alter table ticket
  add constraint FK4kpkrfk0fm1ja6b6swvrfkr2aa
foreign key (fk_session)
references session;