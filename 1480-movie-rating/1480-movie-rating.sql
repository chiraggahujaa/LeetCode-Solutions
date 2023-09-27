select * from (
  select u.name as results from Users as u inner join MovieRating as mr
  on u.user_id = mr.user_id
  group by u.user_id
  order by count(*) desc, u.name
  limit 1
) as temp

union all

select * from (
  select m.title as results from Movies as m inner join MovieRating as mr
  on m.movie_id = mr.movie_id
  where month(created_at) = 2 and year(created_at) = 2020
  group by m.movie_id
  order by avg(mr.rating) desc, m.title
  limit 1
) as temp2;