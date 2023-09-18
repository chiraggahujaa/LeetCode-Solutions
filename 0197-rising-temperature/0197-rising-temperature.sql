# Write your MySQL query statement below
select w1.id from Weather as w1
where w1.temperature > (
  select w2.temperature from Weather as w2
  where DATEDIFF(w1.recordDate, w2.recordDate) = 1
)