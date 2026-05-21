CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      -- select distinct salary from (select salary , dense_rank() over(order by salary desc) as rnk from Employee) as e where e.rnk=n
      with cte as (select distinct salary from(select salary , dense_rank()over(order by salary desc)as rnk from employee) as e where e.rnk = n)
      select * from cte

  );
END