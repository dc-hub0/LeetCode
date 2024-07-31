WITH RankedSalaries AS (
    SELECT 
        e.id, 
        e.name, 
        e.salary, 
        e.departmentId, 
        d.name AS Department,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS salary_rank
    FROM Employee e
    JOIN Department d ON e.departmentId = d.id
)
SELECT 
    Department,
    name AS Employee,
    salary AS Salary
FROM RankedSalaries
WHERE salary_rank <= 3
ORDER BY Department, Salary DESC;
