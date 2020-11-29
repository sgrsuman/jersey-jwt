INSERT INTO user (id, first_name, last_name, username, password) VALUES (1, 'John', 'Doe', 'admin', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');
INSERT INTO user (id, first_name, last_name, username, password) VALUES (2, 'Jane', 'Doe', 'emp', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');
INSERT INTO user (id, first_name, last_name, username, password) VALUES (3, 'Johnny', 'Doe', 'cust', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');

INSERT INTO user_authorities (user_id, authority) VALUES (1, 'ADMIN');
INSERT INTO user_authorities (user_id, authority) VALUES (1, 'EMP');
INSERT INTO user_authorities (user_id, authority) VALUES (2, 'EMP');
INSERT INTO user_authorities (user_id, authority) VALUES (3, 'CUST');