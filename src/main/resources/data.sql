CREATE TABLE customer(
    TCKN bigint primary key ,
    NAME varchar(20),
    SUR_NAME varchar(20),
    MONTHLY_INCOME bigint,
    PHONE_NUMBER varchar(11),
    BIRTH_DATE varchar(10),
    GUARANTEE bigint
);
CREATE TABLE credit_score(
                         TCKN bigint primary key ,
                         CREDIT_SCORE bigint
);
CREATE TABLE credit(
                         TCKN bigint primary key ,
                         BIRTH_DATE varchar(10),
                         CREATE_DATE varchar(10),
                         RESULT BOOLEAN,
                         LOAN_AMOUNT bigint
);





INSERT INTO customer (TCKN, NAME, SUR_NAME, MONTHLY_INCOME, PHONE_NUMBER, BIRTH_DATE, GUARANTEE)
VALUES (40268082820, 'safak', 'tamses', 12000, '05367214367', '1996-02-06', 0);
INSERT INTO customer (TCKN, NAME, SUR_NAME, MONTHLY_INCOME, PHONE_NUMBER, BIRTH_DATE, GUARANTEE)
VALUES (12345678910, 'ahmet', 'mehmet', 20000, '05555555555', '1901-01-01', 0);
INSERT INTO customer (TCKN, NAME, SUR_NAME, MONTHLY_INCOME, PHONE_NUMBER, BIRTH_DATE, GUARANTEE)
VALUES (13457845122, 'burak', 'kaya', 31000, '05313313131', '1954-11-13', 500000);

INSERT INTO credit_score (TCKN, CREDIT_SCORE)
VALUES (40268082820, 750);
INSERT INTO credit_score (TCKN, CREDIT_SCORE)
VALUES (12345678910, 1000);
INSERT INTO credit_score (TCKN, CREDIT_SCORE)
VALUES (13457845122, 450);

INSERT INTO credit (TCKN, BIRTH_DATE, CREATE_DATE, RESULT,LOAN_AMOUNT)
VALUES (40268082820, '1996-02-06', '2023-01-02', TRUE, 20000);