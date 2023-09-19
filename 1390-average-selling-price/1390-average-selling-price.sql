# Write your MySQL query statement below

select p1.product_id, 
case when u.product_id is null then 0 else round(sum(p1.price * u.units)/sum(u.units),2) end as average_price 
from Prices as p1 left join UnitsSold as u on p1.product_id = u.product_id
where u.product_id is null or datediff(u.purchase_date, p1.start_date) >= 0 and datediff(u.purchase_date, p1.end_date) <= 0
group by p1.product_id;