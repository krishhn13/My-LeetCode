# Write your MySQL query statement below
SELECT A1.machine_id,
    ROUND(
        Avg(
            A1.timestamp - A2.timestamp
        ),3
    ) as processing_time
FROM Activity A1, Activity A2
WHERE A1.activity_type = 'end' and A2.activity_type = 'start' and A1.machine_id = A2.machine_id
GROUP BY A1.machine_id