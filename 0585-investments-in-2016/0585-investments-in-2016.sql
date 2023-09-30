select round(sum(
    case 
        when (select count(*) from Insurance where i.tiv_2015 = tiv_2015) > 1 and 
        (select count(*) from Insurance where i.lat = lat and i.lon = lon) = 1
        then tiv_2016
        else 0
    end
),2) as tiv_2016 from Insurance as i;