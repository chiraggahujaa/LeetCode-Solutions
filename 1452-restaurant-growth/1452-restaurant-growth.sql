select distinct c1.visited_on, sum(c2.day_sum) amount, round(sum(c2.day_sum)/7,2) average_amount
from 
  (select visited_on, sum(amount) as day_sum from Customer group by visited_on) c1,
  (select visited_on, sum(amount) as day_sum from Customer group by visited_on) c2
where datediff(c1.visited_on, c2.visited_on) between 0 and 6
group by c1.visited_on
HAVING c1.visited_on >= (SELECT MIN(visited_on) FROM Customer) + 6
order by c1.visited_on;