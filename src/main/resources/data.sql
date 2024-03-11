insert into games(name ,type, code, release_year) values ('counter-strike','fps','cs','2023');
insert into games(name ,type, code, release_year) values ('Fortnite','fps','ft','2021');
insert into games(name ,type, code, release_year) values ('World Of Warcraft','mmorpg','wow','2020');
insert into games(name ,type, code, release_year) values ('Dota','rpg','dt','2021');
insert into games(name ,type, code, release_year) values ('Valhalla','rpg','vh','2022');


insert into levels(name) values ('noob');
insert into levels(name) values ('pro');
insert into levels(name) values ('invincible');


insert into country(country_code, country_name, geography) values ('DK','denmark','Europe');
insert into country(country_code, country_name, geography) values ('US','United States','NA');
insert into country(country_code, country_name, geography) values ('IN','India','Asia');


insert into players(name, email, country_id, age, gender, gamer_tag) values ('Ankush Bhan', 'bhankush@gmail.com', 1L, '32', 'M', 'carax');
insert into players(name, email, country_id, age, gender, gamer_tag) values ('ShruB', 'shrub@gmail.com', 1L, '31', 'F', 'basashru');



insert into gameswithplayer(game_id, player_id, level_id, credits) values (1L, 1L, 2L, 50);
insert into gameswithplayer(game_id, player_id, level_id, credits) values (2L, 1L, 1L, 20);
insert into gameswithplayer(game_id, player_id, level_id, credits) values (2L, 2L, 1L, 30);
insert into gameswithplayer(game_id, player_id, level_id, credits) values (1L, 2L, 2L, 20);


