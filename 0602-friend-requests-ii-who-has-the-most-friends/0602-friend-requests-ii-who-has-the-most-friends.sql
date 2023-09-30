select id, sum(count) as num from 
(
    select accepter_id as id, count(*) as count from RequestAccepted
    group by accepter_id
    union all
    select requester_id as id, count(*) as count from RequestAccepted
    group by requester_id
) as temp
group by id
order by num desc limit 1;