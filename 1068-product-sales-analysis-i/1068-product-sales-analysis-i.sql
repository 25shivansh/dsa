# Write your MySQL query statement below
-- left join
-- select p.product_name , s.year,s.price from Sales as s left join product as p on s.product_id=p.product_id
-- right join 
select p.product_name , s.year ,s.price from Product as p right join Sales as s on p.product_id=s.product_id