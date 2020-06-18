
--
-- Sample data for the Biblioteca PostgreSQL database
--

SET statement_timeout = 0;
SET client_encoding = 'LATIN1';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO book VALUES (1, 'The Fellowship Of The Ring', 'J. R. R. Tolkien', '1954') ON CONFLICT DO NOTHING;
INSERT INTO book VALUES (2, 'The Two Towers', 'J. R. R. Tolkien', '1954') ON CONFLICT DO NOTHING;
INSERT INTO book VALUES (3, 'The Return Of The Ring', 'J. R. R. Tolkien', '1955') ON CONFLICT DO NOTHING;

--
-- Name: book_book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('book_book_id_seq', (SELECT MAX(book_id) FROM book), true);
