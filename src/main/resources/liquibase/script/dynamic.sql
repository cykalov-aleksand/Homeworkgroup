-- liquibase formatted sql

-- changeset acycalov:1
CREATE TABLE dinamic(
    id SERIAL PRIMARY KEY,
    product_id TEXT,
    product_name TEXT,
    product_text TEXT,
    rule TEXT);

   -- changeset acycalov:2
   CREATE TABLE rule(
          id SERIAL PRIMARY KEY,
          dinamic_id SERIAL REFERENCES dinamic(id),
          query TEXT,
          arguments TEXT[],
          negate Boolean);







