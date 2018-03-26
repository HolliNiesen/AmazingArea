DELETE FROM role;
DELETE FROM user;
DELETE FROM account;
INSERT INTO account VALUES (1, 'Niesen'), (2, 'Fake');
INSERT INTO user VALUES (1, 'holli.niesen@gmail.com', 'Holli', '1993-02-16', 'secret', 1);
INSERT INTO user VALUES (2, 'cozzie@gmail.com', 'Cosmo', '2012-05-18', 'secret', 1);
INSERT INTO role VALUES (1, 'parent', 'holli.niesen@gmail.com', 1);