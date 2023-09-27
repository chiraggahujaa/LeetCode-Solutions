# Write your MySQL query statement below
select product_id ,(
  case when min(change_date) <= '2019-08-16' then 
  (select new_price from Products as p2
    where change_date <= '2019-08-16' and p1.product_id = p2.product_id
    order by change_date desc
    limit 1
  )
  else 10
  end
) as price from Products as p1
group by product_id;