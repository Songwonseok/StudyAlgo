SELECT tg.name,
       IFNULL(tc.c_all, 0)                  AS all_test_cases,
       IFNULL(tc.c_pass, 0)                 AS passed_test_cases,
       IFNULL(tc.c_pass, 0) * tg.test_value AS total_value
FROM test_groups AS tg
         LEFT JOIN (SELECT group_name, count(*) c_all, count(case when status = 'OK' then 1 end) c_pass
                    FROM test_cases
                    GROUP BY group_name) tc ON tg.name = tc.group_name
ORDER BY passed_test_cases DESC, tg.name ASC;



-- create table test_groups (
--      name varchar(40) not null,
--      test_value integer not null,
--      unique(name)
-- );
--
-- create table test_cases (
--     id integer not null,
--     group_name varchar(40) not null,
--     status varchar(5) not null,
--     unique(id)
-- );
--
-- insert into test_groups values ('performance', 15);
-- insert into test_groups values ('corner cases', 10);
-- insert into test_groups values ('numerical stability', 20);
-- insert into test_groups values ('memory usage', 10);
-- insert into test_cases values (13, 'memory usage', 'OK');
-- insert into test_cases values (14, 'numerical stability', 'OK');
-- insert into test_cases values (15, 'memory usage', 'ERROR');
-- insert into test_cases values (16, 'numerical stability', 'OK');
-- insert into test_cases values (17, 'numerical stability', 'OK');
-- insert into test_cases values (18, 'performance', 'ERROR');
-- insert into test_cases values (19, 'performance', 'ERROR');
-- insert into test_cases values (20, 'memory usage', 'OK');
-- insert into test_cases values (21, 'numerical stability', 'OK');