-- // create_account
-- Migration SQL that makes the change goes here.

CREATE TABLE account (
   account_id SERIAL PRIMARY KEY,
   email CHARACTER VARYING(255) NOT NULL,
   name CHARACTER VARYING(255) NOT NULL,
   password CHARACTER VARYING(255) NOT NULL,
   phone_number CHARACTER VARYING(32) NOT NULL
 );


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE account;
