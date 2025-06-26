-- liquibase formatted sql

-- changeset acycalov:1
CREATE TABLE dinamic(
    id BIGSERIAL PRIMARY KEY,
    product_id TEXT,
    product_name TEXT,
    product_text TEXT);

   -- changeset acycalov:2
   CREATE TABLE rule(
          id BIGSERIAL PRIMARY KEY,
          dinamic_id BIGSERIAL REFERENCES dinamic(id) ON DELETE CASCADE,
          query TEXT,
          arguments TEXT[],
          negate Boolean,
          rule_id BIGSERIAL,
          count INTEGER);





