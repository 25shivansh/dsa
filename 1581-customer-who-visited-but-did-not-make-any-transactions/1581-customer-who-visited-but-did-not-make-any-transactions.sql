# Write your MySQL query statement below
-- select v.customer_id ,count(*) as count_no_trans from Visits as v left join transactions as t on v.visit_id = t.visit_id where t.visit_id is null group by(v.customer_id);
SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM Visits v
WHERE NOT EXISTS (
    SELECT 1 
    FROM Transactions t 
    WHERE t.visit_id = v.visit_id
)
GROUP BY v.customer_id;