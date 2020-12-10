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
-- Name: award; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.award (
    award_id integer NOT NULL,
    award_name character varying(100),
    organisation character varying(100),
    country character varying(50),
    id integer,
    category_id integer
);


ALTER TABLE public.award OWNER TO postgres;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    category_name character varying(100),
    category_id integer NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

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
-- Name: nominee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nominee (
    nid integer NOT NULL,
    rating numeric(2,1),
    in_id integer,
    category_id integer
);


ALTER TABLE public.nominee OWNER TO postgres;

--
-- Name: winner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.winner (
    n_id integer
);


ALTER TABLE public.winner OWNER TO postgres;

--
-- Data for Name: award; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.award (award_id, award_name, organisation, country, id, category_id) FROM stdin;
1	Nobel prize	Karolinska Institute	Norway	1	1
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (category_name, category_id) FROM stdin;
crypto	1
\.


--
-- Data for Name: invention; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invention (in_id, year_of_invention, budget, id, story, year_of_win, category_id) FROM stdin;
1	2010	100000	1	It was very great	2011	1
\.


--
-- Data for Name: inventor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventor (id, name, address, dob, age, salary, recieved_awards) FROM stdin;
1	(Sarang,Dileep)	(Meloor,Thalassery,123)	2001-07-27	12	12343	Nobel prize
\.


--
-- Data for Name: nominee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nominee (nid, rating, in_id, category_id) FROM stdin;
1	9.6	1	1
\.


--
-- Data for Name: winner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.winner (n_id) FROM stdin;
1
\.


--
-- Name: award award_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.award
    ADD CONSTRAINT award_pkey PRIMARY KEY (award_id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


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
-- Name: nominee nominee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominee
    ADD CONSTRAINT nominee_pkey PRIMARY KEY (nid);


--
-- Name: invention category_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invention
    ADD CONSTRAINT category_id FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- Name: nominee category_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominee
    ADD CONSTRAINT category_id FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- Name: award category_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.award
    ADD CONSTRAINT category_id FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- Name: invention id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invention
    ADD CONSTRAINT id FOREIGN KEY (id) REFERENCES public.inventor(id);


--
-- Name: award id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.award
    ADD CONSTRAINT id FOREIGN KEY (id) REFERENCES public.inventor(id);


--
-- Name: nominee in_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominee
    ADD CONSTRAINT in_id FOREIGN KEY (in_id) REFERENCES public.invention(in_id);


--
-- Name: winner n_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.winner
    ADD CONSTRAINT n_id FOREIGN KEY (n_id) REFERENCES public.nominee(nid);


--
-- PostgreSQL database dump complete
--

