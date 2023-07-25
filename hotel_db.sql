--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

-- Started on 2023-03-30 18:39:11

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 212 (class 1259 OID 149850)
-- Name: auction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.auction (
    id bigint NOT NULL,
    actual_price numeric(38,2),
    auction_status character varying(255),
    auction_winner character varying(255),
    end_date timestamp(6) with time zone,
    start_date timestamp(6) with time zone,
    start_price numeric(38,2),
    stay_entity_id bigint
);


ALTER TABLE public.auction OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 149849)
-- Name: auction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auction_id_seq OWNER TO postgres;

--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 211
-- Name: auction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.auction_id_seq OWNED BY public.auction.id;


--
-- TOC entry 209 (class 1259 OID 117333)
-- Name: auction_manager_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auction_manager_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auction_manager_seq OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 137065)
-- Name: auction_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.auction_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auction_seq OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 149859)
-- Name: bid; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bid (
    id bigint NOT NULL,
    bid_time timestamp(6) with time zone,
    email character varying(255),
    price numeric(38,2),
    auction_id bigint
);


ALTER TABLE public.bid OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 149858)
-- Name: bid_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bid_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bid_id_seq OWNER TO postgres;

--
-- TOC entry 3363 (class 0 OID 0)
-- Dependencies: 213
-- Name: bid_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bid_id_seq OWNED BY public.bid.id;


--
-- TOC entry 216 (class 1259 OID 149866)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    id bigint NOT NULL,
    accommodation_capacity integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.room OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 149872)
-- Name: room_entity_beds_sizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room_entity_beds_sizes (
    room_entity_id bigint NOT NULL,
    beds_sizes integer
);


ALTER TABLE public.room_entity_beds_sizes OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 149875)
-- Name: room_entity_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room_entity_images (
    room_entity_id bigint NOT NULL,
    images character varying(255)
);


ALTER TABLE public.room_entity_images OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 149865)
-- Name: room_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.room_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.room_id_seq OWNER TO postgres;

--
-- TOC entry 3364 (class 0 OID 0)
-- Dependencies: 215
-- Name: room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.room_id_seq OWNED BY public.room.id;


--
-- TOC entry 220 (class 1259 OID 149879)
-- Name: stay; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.stay (
    id bigint NOT NULL,
    reservation_end_date timestamp(6) with time zone,
    reservation_start_date timestamp(6) with time zone,
    user_id character varying(255),
    room_entity_id bigint
);


ALTER TABLE public.stay OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 149878)
-- Name: stay_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.stay_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stay_id_seq OWNER TO postgres;

--
-- TOC entry 3365 (class 0 OID 0)
-- Dependencies: 219
-- Name: stay_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.stay_id_seq OWNED BY public.stay.id;


--
-- TOC entry 3189 (class 2604 OID 149853)
-- Name: auction id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auction ALTER COLUMN id SET DEFAULT nextval('public.auction_id_seq'::regclass);


--
-- TOC entry 3190 (class 2604 OID 149862)
-- Name: bid id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid ALTER COLUMN id SET DEFAULT nextval('public.bid_id_seq'::regclass);


--
-- TOC entry 3191 (class 2604 OID 149869)
-- Name: room id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room ALTER COLUMN id SET DEFAULT nextval('public.room_id_seq'::regclass);


--
-- TOC entry 3192 (class 2604 OID 149882)
-- Name: stay id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stay ALTER COLUMN id SET DEFAULT nextval('public.stay_id_seq'::regclass);


--
-- TOC entry 3348 (class 0 OID 149850)
-- Dependencies: 212
-- Data for Name: auction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.auction (id, actual_price, auction_status, auction_winner, end_date, start_date, start_price, stay_entity_id) FROM stdin;
1	15.00	FINISHED	mattwasilewski96@gmail.com	2023-03-15 23:50:34.962+01	2023-03-15 23:50:37.027+01	0.00	1
6	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-04-08 00:50:37.027+02	0.00	6
7	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-04-08 00:50:37.027+02	0.00	7
4	25.00	CREATED		2023-04-08 00:50:34.962+02	2023-04-02 00:50:37.027+02	0.00	4
5	25.00	CREATED		2023-04-09 00:50:34.962+02	2023-04-03 00:50:37.027+02	0.00	5
3	15.00	FINISHED	mattwasilewski96@gmail.com	2023-03-15 23:50:34.962+01	2023-03-15 23:50:37.027+01	0.00	3
8	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-04-08 00:50:37.027+02	0.00	8
9	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-04-08 00:50:37.027+02	0.00	9
10	25.00	CREATED	\N	2023-05-15 00:50:34.962+02	2023-05-08 00:50:37.027+02	0.00	10
11	25.00	CREATED	\N	2023-05-15 00:50:34.962+02	2023-05-08 00:50:37.027+02	0.00	11
12	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-03-31 00:50:37.027+02	0.00	12
13	25.00	CREATED	\N	2023-04-15 00:50:34.962+02	2023-03-31 00:50:37.027+02	0.00	13
14	25.00	STARTED	\N	2023-04-14 00:50:34.962+02	2023-03-30 00:50:37.027+02	0.00	14
15	25.00	STARTED	\N	2023-04-14 00:50:34.962+02	2023-03-30 00:50:37.027+02	0.00	15
16	25.00	STARTED	\N	2023-04-14 00:50:34.962+02	2023-03-30 00:50:37.027+02	0.00	16
17	25.00	STARTED	\N	2023-04-14 00:50:34.962+02	2023-03-30 00:50:37.027+02	0.00	17
18	25.00	CREATED	\N	2023-05-14 00:50:34.962+02	2023-04-30 00:50:37.027+02	0.00	18
19	25.00	CREATED	\N	2023-05-14 00:50:34.962+02	2023-04-30 00:50:37.027+02	0.00	19
\.


--
-- TOC entry 3350 (class 0 OID 149859)
-- Dependencies: 214
-- Data for Name: bid; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bid (id, bid_time, email, price, auction_id) FROM stdin;
1	2023-03-22 18:48:36.349+01	mattwasilewski96@gmail.com	2222.00	3
\.


--
-- TOC entry 3352 (class 0 OID 149866)
-- Dependencies: 216
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room (id, accommodation_capacity, name) FROM stdin;
4	2	Czerwony pokoj
5	2	Zielony pokoj
6	2	Pokoj VIP
7	2	Pokoj zagadka
2	2	Zakonczony pokoj
1	2	Testowy pokoj
3	2	Marcowy pokoj
8	2	Pokoj ostateczny
9	2	Wolny pokoj
10	2	Bezimienny pokoj
11	2	Co to za pokoj?
12	2	Pokoj standard
13	2	Pokoj premium
14	2	Pokoj bez bidow!
15	2	Pokoj bez bidow premium!
16	2	Pokoj bez bidow VIP!
17	2	Pokoj bez bidow EXTRA!
18	2	Bez bidów!
19	3	Bez bidów!
\.


--
-- TOC entry 3353 (class 0 OID 149872)
-- Dependencies: 217
-- Data for Name: room_entity_beds_sizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room_entity_beds_sizes (room_entity_id, beds_sizes) FROM stdin;
1	1
1	1
2	1
2	1
3	1
3	1
4	1
4	1
5	1
5	1
6	1
6	1
7	1
7	1
8	1
8	1
9	1
9	1
10	1
10	1
11	1
11	1
12	1
12	1
13	1
13	1
14	1
14	1
15	1
15	1
16	1
16	1
17	1
17	1
18	1
18	1
19	2
19	1
\.


--
-- TOC entry 3354 (class 0 OID 149875)
-- Dependencies: 218
-- Data for Name: room_entity_images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.room_entity_images (room_entity_id, images) FROM stdin;
1	test1
1	test2
2	test1
2	test2
3	test1
3	test2
4	test1
4	test2
5	test1
5	test2
6	test1
6	test2
7	test1
7	test2
8	test1
8	test2
9	test1
9	test2
10	test1
10	test2
11	test1
11	test2
12	test1
12	test2
13	test1
13	test2
14	test1
14	test2
15	test1
15	test2
16	test1
16	test2
17	test1
17	test2
18	test1
18	test2
19	test1
19	test2
\.


--
-- TOC entry 3356 (class 0 OID 149879)
-- Dependencies: 220
-- Data for Name: stay; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.stay (id, reservation_end_date, reservation_start_date, user_id, room_entity_id) FROM stdin;
1	2023-03-15 23:50:17+01	2023-03-15 23:50:18.4+01	testid	1
2	2023-03-15 23:50:17+01	2023-03-15 23:50:18.4+01	testid	2
3	2023-03-15 23:50:17+01	2023-03-15 23:50:18.4+01	testid	3
4	2023-06-08 00:50:17+02	2023-06-02 00:50:18.4+02	testid	4
5	2023-06-08 00:50:17+02	2023-06-02 00:50:18.4+02	testid	5
6	2023-06-29 00:50:17+02	2023-06-22 00:50:18.4+02	testid	6
7	2023-06-29 00:50:17+02	2023-06-22 00:50:18.4+02	testid	7
8	2023-07-29 00:50:17+02	2023-07-22 00:50:18.4+02	testid	8
9	2023-07-29 00:50:17+02	2023-07-22 00:50:18.4+02	testid	9
10	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	10
11	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	11
12	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	12
13	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	13
14	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	14
15	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	15
16	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	16
17	2023-08-29 00:50:17+02	2023-08-22 00:50:18.4+02	testid	17
18	2023-09-29 00:50:17+02	2023-09-22 00:50:18.4+02	testid	18
19	2023-09-29 00:50:17+02	2023-09-22 00:50:18.4+02	testid	19
\.


--
-- TOC entry 3366 (class 0 OID 0)
-- Dependencies: 211
-- Name: auction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auction_id_seq', 19, true);


--
-- TOC entry 3367 (class 0 OID 0)
-- Dependencies: 209
-- Name: auction_manager_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auction_manager_seq', 1, false);


--
-- TOC entry 3368 (class 0 OID 0)
-- Dependencies: 210
-- Name: auction_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.auction_seq', 1, false);


--
-- TOC entry 3369 (class 0 OID 0)
-- Dependencies: 213
-- Name: bid_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bid_id_seq', 1, false);


--
-- TOC entry 3370 (class 0 OID 0)
-- Dependencies: 215
-- Name: room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.room_id_seq', 19, true);


--
-- TOC entry 3371 (class 0 OID 0)
-- Dependencies: 219
-- Name: stay_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.stay_id_seq', 19, true);


--
-- TOC entry 3194 (class 2606 OID 149857)
-- Name: auction auction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auction
    ADD CONSTRAINT auction_pkey PRIMARY KEY (id);


--
-- TOC entry 3196 (class 2606 OID 149864)
-- Name: bid bid_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid
    ADD CONSTRAINT bid_pkey PRIMARY KEY (id);


--
-- TOC entry 3198 (class 2606 OID 149871)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (id);


--
-- TOC entry 3200 (class 2606 OID 149884)
-- Name: stay stay_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stay
    ADD CONSTRAINT stay_pkey PRIMARY KEY (id);


--
-- TOC entry 3204 (class 2606 OID 149900)
-- Name: room_entity_images fk3bsg90rt6rvm96uw296b3hslg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_entity_images
    ADD CONSTRAINT fk3bsg90rt6rvm96uw296b3hslg FOREIGN KEY (room_entity_id) REFERENCES public.room(id);


--
-- TOC entry 3201 (class 2606 OID 149885)
-- Name: auction fk6g5dvdvybc7ngk2d4qi4oyahf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.auction
    ADD CONSTRAINT fk6g5dvdvybc7ngk2d4qi4oyahf FOREIGN KEY (stay_entity_id) REFERENCES public.stay(id);


--
-- TOC entry 3205 (class 2606 OID 149905)
-- Name: stay fk6t8r37nndbr4fpxhhp37jh7b0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.stay
    ADD CONSTRAINT fk6t8r37nndbr4fpxhhp37jh7b0 FOREIGN KEY (room_entity_id) REFERENCES public.room(id);


--
-- TOC entry 3203 (class 2606 OID 149895)
-- Name: room_entity_beds_sizes fk7fuhwmlpvsixush18urkm1l0x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room_entity_beds_sizes
    ADD CONSTRAINT fk7fuhwmlpvsixush18urkm1l0x FOREIGN KEY (room_entity_id) REFERENCES public.room(id);


--
-- TOC entry 3202 (class 2606 OID 149890)
-- Name: bid fkhexc6i4j8i0tmpt8bdulp6g3g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bid
    ADD CONSTRAINT fkhexc6i4j8i0tmpt8bdulp6g3g FOREIGN KEY (auction_id) REFERENCES public.auction(id);


-- Completed on 2023-03-30 18:39:11

--
-- PostgreSQL database dump complete
--

