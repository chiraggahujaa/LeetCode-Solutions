# Write your MySQL query statement below
select * from (select employee_id, 
(case 
  when count(department_id) = 1 then department_id 
  else (select department_id from Employee as e2 where e1.employee_id = e2.employee_id and primary_flag = 'Y')
  end
) as department_id 
from Employee as e1 
group by employee_id
having count(department_id) >= 1) as temp
where department_id is not null;