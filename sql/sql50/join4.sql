select 
    o.id
from Weather w 
inner join Weather o 
on datediff(day, w.recordDate , o.recordDate) = 1
where o.temperature > w.temperature;
