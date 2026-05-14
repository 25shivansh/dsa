# Write your MySQL query statement below
-- with old_cte as (select distinct salary from employee ), new_cte as (select max(salary) as secondHighestSalary from employee where salary <(select max(salary)from employee))select * from new_cte ;
select distinct (select distinct  salary as SecondHighestSalary from(select salary , dense_rank() over(order by salary desc) as rnk from employee )as e where e.rnk=2) as secondHighestSalary ;
