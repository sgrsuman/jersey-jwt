INSERT INTO user (id, first_name, last_name, user_type, password) VALUES (1, 'John', 'Doe', 'admin', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');
INSERT INTO user (id, first_name, last_name, user_type, password) VALUES (2, 'Jane', 'Doe', 'emp', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');
INSERT INTO user (id, first_name, last_name, user_type, password) VALUES (3, 'Johnny', 'Doe', 'cust', '$2a$10$32Hw5zY7uvx0EgsfE/yQNuuL.Nrt5srepNP.vlmES2VKbYAnOBqC6');

INSERT INTO user_authorities (id, user_id, authority) VALUES (1, 1, 'ADMIN');
INSERT INTO user_authorities (id, user_id, authority) VALUES (2, 1, 'EMP');
INSERT INTO user_authorities (id, user_id, authority) VALUES (3, 2, 'EMP');
INSERT INTO user_authorities (id, user_id, authority) VALUES (4, 3, 'CUST');

INSERT INTO account (id, user_id, account_type, kyc, account_balance) VALUES (1, 1, 'SAVINGS', 'YES', 3000)
INSERT INTO account (id, user_id, account_type, kyc, account_balance) VALUES (2, 2, 'SAVINGS', 'YES', 2000)
INSERT INTO account (id, user_id, account_type, kyc, account_balance) VALUES (3, 3, 'SAVINGS', 'NO', 1000)