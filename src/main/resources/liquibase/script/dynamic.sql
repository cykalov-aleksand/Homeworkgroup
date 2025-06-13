-- liquibase formatted sql

-- changeset acycalov:1
CREATE TABLE dinamic(
    id SERIAL PRIMARY KEY,
    product_id TEXT,
    product_name TEXT,
    product_text text
   );
   -- changeset acycalov:2
   CREATE TABLE rulle(
          id SERIAL PRIMARY KEY,
          query TEXT,
          negative Boolean,
          rulle SERIAL);

          -- changeset acycalov:3
             CREATE TABLE argument(
                    id SERIAL PRIMARY KEY,
                    argument_id SERIAL,
                    name TEXT);

