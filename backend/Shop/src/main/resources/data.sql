INSERT INTO user_role(role_id, role_name, description) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb','admin', 'Base role for admin') ON CONFLICT DO NOTHING
INSERT INTO user_role(role_id, role_name, description) VALUES ('09409500-71bb-11ed-a1eb-0242ac120002','client', 'Base role for clients') ON CONFLICT DO NOTHING
INSERT INTO user_permission(permission_id, uri, permission_key, permission_method) VALUES ('ccc7ff73-1989-413a-ab52-9bec7a049e33', '/users', 'create.user', 'POST') ON CONFLICT DO NOTHING
INSERT INTO role_permission(role_id, permission_id) VALUES ('2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb', 'ccc7ff73-1989-413a-ab52-9bec7a049e33') ON CONFLICT DO NOTHING
INSERT INTO "user" (user_id, email, password, address, phone_number, role_id) VALUES ('33414782-71a7-11ed-a1eb-0242ac120002', 'Giovanni2414g@gmail.com', '12345', 'Cra 1C 2 #60-18', '3225034089', '2e72ed53-f5e2-4f7a-bd86-8aadcadeb4eb') ON CONFLICT DO NOTHING
