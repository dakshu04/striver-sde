# Write your MySQL query statement below
SELECT w1.id
FROM Weather w1 /*present day*/
JOIN Weather w2 /*day after yesterday*/
ON w1.recordDate = w2.recordDate + INTERVAL 1 DAY
WHERE w1.temperature > w2.temperature;

