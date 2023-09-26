INSERT INTO user_service.role (id, is_active, creation_date, modification_date, created_by, description, modified_by, name, role_type)
VALUES (1, true, now(), now(), 'utkarsh.rathore', 'internal admin active role', 'utkarsh.rathore', 'ADMIN', 'INTERNAL');

INSERT INTO user_service.user (id, is_active, creation_date, modification_date, email, first_name, last_name, title, username, created_by, modified_by, password)
VALUES (1, true, now(), now(), 'utkarsh.rathore@gmail.com', 'Utkarsh', 'Rathore', 'Admin', 'utkarsh.rathore', 'utkarsh.rathore', 'utkarsh.rathore', 'Utk@1234');

INSERT INTO user_service.user_roles (role_id, user_id) VALUES (1, 1);