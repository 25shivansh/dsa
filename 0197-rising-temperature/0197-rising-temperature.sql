# Write your MySQL query statement below
-- using simple join
select c.id from weather as c join weather as d on datediff(c.recordDate,d.recordDate)=1 where c.temperature>d.temperature ;