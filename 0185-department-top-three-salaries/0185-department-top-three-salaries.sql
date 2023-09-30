# Write your MySQL query statement below
select d.name Department, e1.name Employee, e1.salary Salary
from Employee as e1 inner join Department as d
on d.id = e1.departmentId
where 3 > (select count(distinct salary) from Employee as e2 where e1.departmentId = e2.departmentId and e2.salary > e1.salary);