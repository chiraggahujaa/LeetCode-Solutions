# Write your MySQL query statement below
-- first login
-- they login after that too

select round(count(*)/(select count(*) from (select player_id from activity group by player_id) as t),2) as fraction from 
(select player_id, min(event_date) as event_date from Activity
group by player_id) as temp
inner join
Activity as a
on a.player_id = temp.player_id and datediff(a.event_date, temp.event_date) = 1;