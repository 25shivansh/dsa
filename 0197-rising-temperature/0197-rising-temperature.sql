# Write your MySQL query statement below
select c.id as Id from Weather as c join weather as d on datediff(c.recordDate,d.recordDate)=1 where c.temperature>d.temperature;