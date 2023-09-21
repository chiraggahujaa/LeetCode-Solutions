# Write your MySQL query statement below
select concat(year(trans_date), "-", (case when month(trans_date) < 10 then '0' else '' end), month(trans_date)) as month, 
country, 
count(*) as trans_count, 
sum(case when state = 'approved' then 1 else 0 end) as approved_count,
sum(amount) as trans_total_amount, 
sum(case when state='approved' then amount else 0 end) as approved_total_amount
from Transactions 
group by country, month;