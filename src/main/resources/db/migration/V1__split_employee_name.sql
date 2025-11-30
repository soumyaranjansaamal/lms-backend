-- V1__split_employee_name.sql
-- Safe migration to add first_name/last_name and populate from employee_name

BEGIN;

-- 1) Add columns if not present (safe)
ALTER TABLE employee_primary_info
  ADD COLUMN IF NOT EXISTS first_name varchar(255),
  ADD COLUMN IF NOT EXISTS last_name  varchar(255);

-- 2) Populate first_name and last_name from employee_name (split on first space)
UPDATE employee_primary_info
SET
  first_name = COALESCE(NULLIF(split_part(employee_name, ' ', 1), ''), 'Unknown'),
  last_name  = CASE
                 WHEN strpos(employee_name, ' ') > 0
                   THEN substr(employee_name, strpos(employee_name, ' ')+1)
                 ELSE 'Unknown'
               END
WHERE employee_name IS NOT NULL;

-- 3) Fill any remaining NULLs (safety)
UPDATE employee_primary_info SET first_name = 'Unknown' WHERE first_name IS NULL;
UPDATE employee_primary_info SET last_name  = 'Unknown' WHERE last_name  IS NULL;

-- 4) (OPTIONAL) If you want to enforce NOT NULL (do after verifying)
-- ALTER TABLE employee_primary_info ALTER COLUMN first_name SET NOT NULL;
-- ALTER TABLE employee_primary_info ALTER COLUMN last_name  SET NOT NULL;

COMMIT;