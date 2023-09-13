SET SCHEMA 'users_schema';

INSERT INTO users (username, first_name, last_name, email, title, password, is_enabled, created_by, created_date, modified_by, modified_date)
    VALUES ('vaibhav.gulati', 'Vaibhav', 'Gulati', 'vaibhav.gulati@incedoinc.com', 'Software Engineer', 'password', 'True');
INSERT INTO users (username, first_name, last_name, email, title, password, is_enabled, created_by, created_date, modified_by, modified_date)
    VALUES ('utkarsh.rathore', 'Utkarsh', 'Rathore', 'utkarsh.rathore@incedoinc.com', 'SSE', 'password', 'True');
INSERT INTO users (username, first_name, last_name, email, title, password, is_enabled, created_by, created_date, modified_by, modified_date)
    VALUES ('ujjwal.ratnakar', 'Ujjwal', 'Ratnakar', 'ujjwal.ratnakar@incedoinc.com', 'Software Engineer Trainee', 'password', 'True');


INSERT INTO roles (id, name, description, created_by, created_date, modified_by, modified_date)
    VALUES (1, 'admin', 'Vaibhav', 'Gulati', 'vaibhav.gulati@incedoinc.com', 'Software Engineer', 'password', 'True');
INSERT INTO roles (id, name, description, created_by, created_date, modified_by, modified_date)
    VALUES (2, 'executive', 'Utkarsh', 'Rathore', 'utkarsh.rathore@incedoinc.com', 'SSE', 'password', 'True');
INSERT INTO roles (id, name, description, created_by, created_date, modified_by, modified_date)
    VALUES (3, 'guest', 'Ujjwal', 'Ratnakar', 'ujjwal.ratnakar@incedoinc.com', 'Software Engineer Trainee', 'password', 'True');