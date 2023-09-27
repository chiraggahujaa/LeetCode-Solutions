# Write your MySQL query statement below
select (case when count(*) = 1 then num else null end) as num from 
(select num as num from MyNumbers
group by num having count(num)=1
order by num desc
limit 1) as temp;