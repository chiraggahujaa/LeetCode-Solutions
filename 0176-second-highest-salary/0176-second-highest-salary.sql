# Write your MySQL query statement below
select case 
  when (select count(distinct salary) from Employee) <= 1 then null
  else
  (
    select salary as SecondHighestSalary from Employee as e
    where 1 = (select count(distinct salary) from Employee where e.salary < salary)
    limit 1
  ) 
end
as SecondHighestSalary;