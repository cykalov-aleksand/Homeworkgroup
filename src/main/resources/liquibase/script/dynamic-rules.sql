-- liquibase formatted sql

-- changeset acycalov:1
CREATE TABLE dinamic_rules(
    id SERIAL PRIMARY KEY,
    product_id NUMERIC,
    product_name TEXT,
    product_text text,
    user_of BOOLEAN,
    active_rules_of BOOLEAN,
    transaction_sum_compare BOOLEAN,
    transaction_sum_compare_deposit_withdraw BOOLEAN
);
