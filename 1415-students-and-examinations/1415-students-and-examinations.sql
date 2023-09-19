# Write your MySQL query statement below
select s1.student_id, s1.student_name, s2.subject_name,
sum(case when e.subject_name is null then 0 else 1 end) as attended_exams
from Students as s1 cross join Subjects as s2 left join Examinations as e
on s1.student_id = e.student_id and s2.subject_name = e.subject_name
group by s1.student_id, s2.subject_name
order by s1.student_id, s2.subject_name;