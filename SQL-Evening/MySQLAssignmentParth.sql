-- SQL ASSIGNMENT:


-- 1)Design a system to store all the data with respect to Cricket World cup. Design should be scalable to store data for the world cup matches upcoming in the future. 

-- a) Create sample data in all the tables. 
-- b) Fetch the top 5 batsmen who scored the maximum runs.
-- c) Fetch the top 5 bowlers who has taken the maximum wickets.
-- d) Fetch the average score scored by each team considering the matches played. 
-- e) Increase the scores of each batsmen in the team, which has the least average computed in Step 6, by 10 runs.
-- f) Create a procedure which takes country as the input and gives the highest score of the country up to date, as output


-- Answers should be submitted in the form of a script file that could be directly imported and executed without any modifications.
-- (should include the sample data created as well)

-- ----------------------------------------------
drop database MySQLAssignmentParth;

create database MySQLAssignmentParth;
select 'created database' as '';
use MySQLAssignmentParth;

select "Preparing the dataset" as "";
create table batsman( ID int not null, Name varchar (255) not null, TeamName varchar(255) not null, MatchesPlayed int (4) , RunsScored int (6), primary key (ID) );
LOAD DATA INFILE '/var/lib/mysql-files/batsman.csv' 
INTO TABLE batsman 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;
select * from batsman;

create table bowler( ID int not null, Name varchar(255) not null, TeamName varchar(255) not null, MatchesPlayed int(4), WicketsTaken int (3), primary key (ID) );
LOAD DATA INFILE '/var/lib/mysql-files/bowler.csv' 
INTO TABLE bowler 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;
select * from bowler;

create table matchDetails( ID int not null, TeamName varchar(20), TeamId int , RunsScored int(6), primary key (ID));

insert into matchDetails
values
(1,"India", 1, 345),
(2,"England", 3,  234),
(3, "New Zealand", 4,   401),
(4,"Australia", 2, 182),
(5,"India", 1, 185),
(6,"England", 3,  298),
(7,"South Africa", 5,  299),
(8, "New Zealand", 4,   98),
(9,"Australia", 2, 36),
(10, "New Zealand", 4,   250),
(11,"India", 1, 234),
(12,"Australia", 2, 265),
(13,"South Africa", 5,  296),
(14,"England", 3,  130),
(15,"South Africa", 5,  145);
select * from matchDetails;

select 'created table for batsman, bowler and match details' as '';

select "top 5 batsman" as "";
select ID, Name, RunsScored, TeamName from batsman order by RunsScored desc limit 5;

select "top 5 bowlers " as "";
select ID, Name, WicketsTaken, TeamName from bowler order by WicketsTaken desc limit 5;

select "average score of each team" as "";
select TeamName, avg(RunsScored) from matchDetails group by teamName;

select "Increase the scores of each batsmen in the team, which has the least average computed , by 10 runs." as "";
set @leastAvgTeam = (select TeamName from matchDetails group by teamName order by avg(RunsScored) asc limit 1);
select concat("The country with the least average is " ,@leastAvgTeam) as "";

select * from batsman where TeamName=@leastAvgTeam;

update batsman 
set RunsScored = RunsScored + 10
where TeamName like @leastAvgTeam;

select * from batsman where TeamName=@leastAvgTeam;

select "Create a procedure which takes country as the input and gives the highest score of the country up to date, as output" as "";

DELIMITER $$
DROP PROCEDURE IF EXISTS getHighestScore$$
CREATE PROCEDURE getHighestScore(IN teamId int)
BEGIN
  select * from matchDetails as m where m.TeamId=teamId order by RunsScored desc limit 1;
END$$
DELIMITER ;

CALL getHighestScore(2);