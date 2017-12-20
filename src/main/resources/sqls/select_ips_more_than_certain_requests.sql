/** Write MySQL query to find IPs that mode more than a certain number of requests for a given time period.
 Ex: Write SQL to find IPs that made more than 100 requests starting from 2017-01-01.13:00:00 to 2017-01-01.14:00:00.**/
select log_.ip as col_0_0_,
            count(log_.ip) as col_1_0_
        from
            log log_
        where
            log_.date between '2017-01-01 13:00:00' and '2017-01-01 14:00:00'
        group by
            log_.ip
        having
            count(log_.ip)>=100
