-- // create_book
-- Migration SQL that makes the change goes here.

CREATE TABLE book (
   book_id SERIAL PRIMARY KEY,
   title CHARACTER VARYING(255) NOT NULL,
   author CHARACTER VARYING(255) NOT NULL,
   year_published CHARACTER VARYING(255) NOT NULL
 );


-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE book;

