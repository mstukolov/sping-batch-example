DROP TABLE batch_job_execution IF EXISTS;
DROP TABLE batch_job_execution_context IF EXISTS;
DROP TABLE batch_job_execution_params IF EXISTS;
DROP TABLE batch_job_instance IF EXISTS;
DROP TABLE batch_step_execution IF EXISTS;
DROP TABLE batch_step_execution_context IF EXISTS;

DROP TABLE products IF EXISTS;

CREATE TABLE products  (
    product_id IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    price FLOAT
);