--Part 1

-- int id
-- string employer
-- string name
-- string skills

--Part 2
select name from employer where location = "St. Louis City";

--Part 3

DROP TABLE job;

--Part 4
select * from skill
INNER JOIN job_skills on skill.id = job_skills.skills_id
where job_skills.jobs_id is NOT null
order by name ASC;
