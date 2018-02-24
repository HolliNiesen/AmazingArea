TRUNCATE user;
DELETE FROM account;
DELETE FROM role;
INSERT INTO account VALUES (1, 'holli.niesen@gmail.com', 'Niesen', 'family', 'parent'), (2, 'fake.place@haha.com', 'Nope', 'fake', 'fakeAgain');
INSERT INTO role VALUES (1, 'parent'), (2, 'child'), (3, 'fake');
INSERT INTO user VALUES (1, 'Holli', '1993-02-16', 1, 1), (2, 'Cosmo', '2012-05-18', 2, 1);