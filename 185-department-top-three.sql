-- Write your PostgreSQL query statement below
with sals as (select salary, "departmentid" from (select salary, "departmentid", row_number() over (partition by departmentId order by salary desc) from (select salary, "departmentid" from employee group by salary, "departmentid") x) x where row_number <= 3)
select d.name as "Department", e.name as "Employee", salary
from sals inner join Employee e using ("departmentid", salary)
inner join Department d on d.id=departmentid
