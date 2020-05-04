insert into payment (id, name, amount) VALUES
                    (1, 'payment 1', 1000),
                    (2, 'payment 2', 1000),
                    (3, 'payment 3', 1000),
                    (4, 'payment 4', 1000),
                    (5, 'payment 5', 1000);

insert into task (id, name, description) values
                (1, 'task 1', 'demo task 1'),
                (2, 'task 1', 'demo task 2'),
                (3, 'task 1', 'demo task 3'),
                (4, 'task 1', 'demo task 4'),
                (5, 'task 1', 'demo task 5');

insert into action_detail (id, name, type, action_id) VALUES
                          (1, 'payment 1', 'PAYMENT', 1),
                          (2, 'payment 2', 'PAYMENT', 2),
                          (3, 'payment 3', 'PAYMENT', 3),
                          (4, 'payment 4', 'PAYMENT', 4),
                          (5, 'payment 5', 'PAYMENT', 5),
                          (6, 'task 1', 'TASK', 1),
                          (7, 'task 2', 'TASK', 2),
                          (8, 'task 3', 'TASK', 3),
                          (9, 'task 4', 'TASK', 4),
                          (10, 'task 5', 'TASK', 5);
