# Write your MySQL query statement below
select m.employee_id, m.name, count(e.employee_id) as reports_count, round(avg(e.age),0) as average_age
from Employees as m inner join Employees as e
on m.employee_id = e.reports_to
group by m.employee_id
having count(e.employee_id) >= 1
order by m.employee_id;