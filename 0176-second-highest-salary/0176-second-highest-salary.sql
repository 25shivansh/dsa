# Write your MySQL query statement below
with old_cte as (select distinct salary from employee ), new_cte as (select max(salary) as secondHighestSalary from employee where salary <(select max(salary)from employee))select * from new_cte ;
