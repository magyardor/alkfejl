-- Adding bill for testing
INSERT INTO bill(bill_id, count, sum, comment, created_at, update_at) VALUES(1, 3, 1000, 'takeaway', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO bill(bill_id, count, sum, comment, created_at, update_at) VALUES(2, 2, 700, 'nothing', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO bill(bill_id, count, sum, comment, created_at, update_at) VALUES(3, 1, 500, 'lactose intolerant', CURRENT_TIME(), CURRENT_TIME());

-- Adding some order for testing
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(1, 'diet coke', '500', 'no sugar', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(1, 'hot dog', '300', 'vega', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(1, 'extra cheese', '200', 'vega', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(2, 'coke', '400', 'tasty', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(2, 'sandwitch', '300', 'gluten free', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO order(bill_id, type, price, comment, created_at, updated_at) VALUES(3, 'diet coke', '500', 'no sugar', CURRENT_TIME(), CURRENT_TIME());

--Adding complaint
INSERT INTO complaint(bill_id, text, created_at) VALUES(1, 'undi íze volt', CURRENT_TIME());

-- Adding users
INSERT INTO user(username, password, email_address, enabled, type, created_at, updated_at) VALUES('staff', '11111', 'staff@worry.com', true, 'STAFF', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO user(username, password, email_address, enabled, type, created_at, updated_at) VALUES('guess', '00000', 'guess@worry.com', true, 'GUESS', CURRENT_TIME(), CURRENT_TIME());
