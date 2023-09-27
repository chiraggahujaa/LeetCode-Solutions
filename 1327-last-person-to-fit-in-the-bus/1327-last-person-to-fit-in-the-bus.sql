# Write your MySQL query statement below

select q1.person_name from Queue as q1
where
(
  select sum(q2.weight) from Queue as q2
  where turn <= q1.turn
) <= 1000
order by q1.turn desc
limit 1;