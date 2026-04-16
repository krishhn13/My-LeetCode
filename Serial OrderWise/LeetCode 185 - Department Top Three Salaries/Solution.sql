
SELECT 
    d.name AS Department, 
    emp.name AS Employee, 
    emp.salary 
FROM (
    SELECT 
        employee.*, 
        DENSE_RANK() OVER (PARTITION BY departmentid ORDER BY salary DESC) AS rnk 
    FROM 
        employee
) AS emp
LEFT JOIN 
    department AS d 
    ON d.id = emp.departmentid
WHERE 
    emp.rnk <= 3;