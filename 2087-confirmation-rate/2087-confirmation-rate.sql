# Write your MySQL query statement below
select s.user_id, 
round(sum(
  case when action is null then 0
        when action = 'Confirmed' then 1
        else 0 end)/count(*),2) as confirmation_rate
from Signups as s left join Confirmations as c
on s.user_id = c.user_id
group by s.user_id;