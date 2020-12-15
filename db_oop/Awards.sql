--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14 (Ubuntu 10.14-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.14 (Ubuntu 10.14-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: addr; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.addr AS (
	street character varying(100),
	city character varying(100),
	postal_code integer
);


ALTER TYPE public.addr OWNER TO postgres;

--
-- Name: name; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.name AS (
	fname character varying(100),
	lname character varying(100)
);


ALTER TYPE public.name OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: invention; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invention (
    in_id integer NOT NULL,
    year_of_invention integer,
    budget integer,
    id integer,
    story character varying(10000),
    year_of_win integer,
    category_id integer
);


ALTER TABLE public.invention OWNER TO postgres;

--
-- Name: invention_in_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.invention_in_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invention_in_id_seq OWNER TO postgres;

--
-- Name: invention_in_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invention_in_id_seq OWNED BY public.invention.in_id;


--
-- Name: inventor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventor (
    id integer NOT NULL,
    name name,
    address public.addr,
    dob date,
    age integer,
    salary integer,
    recieved_awards character varying(500)
);


ALTER TABLE public.inventor OWNER TO postgres;

--
-- Name: inventor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inventor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inventor_id_seq OWNER TO postgres;

--
-- Name: inventor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventor_id_seq OWNED BY public.inventor.id;


--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    username character varying(200),
    password character varying(100),
    vote_id integer
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: winner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.winner (
    in_id integer
);


ALTER TABLE public.winner OWNER TO postgres;

--
-- Name: invention in_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invention ALTER COLUMN in_id SET DEFAULT nextval('public.invention_in_id_seq'::regclass);


--
-- Name: inventor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventor ALTER COLUMN id SET DEFAULT nextval('public.inventor_id_seq'::regclass);


--
-- Data for Name: invention; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invention (in_id, year_of_invention, budget, id, story, year_of_win, category_id) FROM stdin;
1	2020	5000	14	story	2021	1
\.


--
-- Data for Name: inventor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventor (id, name, address, dob, age, salary, recieved_awards) FROM stdin;
2	(Sarang,Dileep)	(Meloor,Thalassery,123)	2001-07-27	12	12343	Nobel prize
3	(fname,lname)	(street,city,212)	2001-10-10	5	1000	wqwwq
4	(fname,lname)	(street,city,1211)	2001-10-10	5	100	
5	(fname,lname)	(street,city,1211)	2001-10-10	5	100	my name is sae\\ra
6	(fname,lname)	(street,city,2112)	2001-10-10	4	1000	wqwq
7	(fname,lname)	(street,city,2112)	2001-10-10	4	1000	this man is grt
8	(fname,lname)	(street,city,2112)	2001-10-10	4	1000	this man is grt
9	(fname,lname)	(street,city,122312)	2001-10-10	5	1000	Awards
10	(fname,lname)	(street,city,122312)	2001-10-10	5	1000	my story
11	(fname,lname)	(street,city,1212)	2001-10-10	45	3500	award
12	(fname,lname)	(street,city,122)	2001-10-10	35	1000	my award
13	(fname,lname)	(street,city,21313)	2001-01-01	21	1000	award
14	(fname,lname)	(street,city,121)	2001-01-01	12	21212	award
\.


--
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login (username, password, vote_id) FROM stdin;
\.


--
-- Data for Name: winner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.winner (in_id) FROM stdin;
\.


--
-- Name: invention_in_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invention_in_id_seq', 1, true);


--
-- Name: inventor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventor_id_seq', 14, true);


--
-- Name: invention invention_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invention
    ADD CONSTRAINT invention_pkey PRIMARY KEY (in_id);


--
-- Name: inventor inventor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventor
    ADD CONSTRAINT inventor_pkey PRIMARY KEY (id);


--
-- Name: invention id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invention
    ADD CONSTRAINT id FOREIGN KEY (id) REFERENCES public.inventor(id);


--
-- Name: winner in_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.winner
    ADD CONSTRAINT in_id FOREIGN KEY (in_id) REFERENCES public.invention(in_id);


--
-- PostgreSQL database dump complete
--

