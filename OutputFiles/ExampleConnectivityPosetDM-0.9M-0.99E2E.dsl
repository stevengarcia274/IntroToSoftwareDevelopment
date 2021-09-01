// Course CS2820 Authentication Tag: 3JDpgcyvRSHACa+sL04B/1hZ6NZfTqtLZ/PDexnpWd84z+xBWxMSay+oQB2rtaBtyfbXFjeyq3SKZHihe1nmxccHEQ9u28d9ThXjhkrZ5KA=
WARP system for graph Example created with the following parameters:
Scheduler Name:	ConnectivityPosetDM
M:	0.9
E2E:	0.99
nChannels:	16
Time Slot	A	B	C
0	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
1	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
2	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
3	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
4	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
5	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
6	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
7	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
8	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0)	sleep
9	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if !has(F0: A -> B) pull(F0: A -> B, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
10	wait(#0)	if !has(F0: A -> B) pull(F0: A -> B, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
11	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
12	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
13	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
14	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
15	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
16	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
17	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
18	sleep	if has(F0: B -> C) push(F0: B -> C, #0) else if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
19	sleep	if has(F0: B -> C) push(F0: B -> C, #0)	wait(#0)
20	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
21	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
22	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
23	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
24	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
25	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
26	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
27	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
28	sleep	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0)	wait(#0)
29	wait(#0)	if !has(F1: C -> B) pull(F1: C -> B, #0) else if !has(F1: C -> B) pull(F1: C -> B, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	wait(#0)
30	wait(#0)	if !has(F1: C -> B) pull(F1: C -> B, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	wait(#0)
31	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
32	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
33	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
34	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
35	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
36	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
37	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
38	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0) else if has(F1: B -> A) push(F1: B -> A, #0)	sleep
39	wait(#0)	if has(F1: B -> A) push(F1: B -> A, #0)	sleep
40	sleep	sleep	sleep
41	sleep	sleep	sleep
42	sleep	sleep	sleep
43	sleep	sleep	sleep
44	sleep	sleep	sleep
45	sleep	sleep	sleep
46	sleep	sleep	sleep
47	sleep	sleep	sleep
48	sleep	sleep	sleep
49	sleep	sleep	sleep
50	sleep	sleep	sleep
51	sleep	sleep	sleep
52	sleep	sleep	sleep
53	sleep	sleep	sleep
54	sleep	sleep	sleep
55	sleep	sleep	sleep
56	sleep	sleep	sleep
57	sleep	sleep	sleep
58	sleep	sleep	sleep
59	sleep	sleep	sleep
60	sleep	sleep	sleep
61	sleep	sleep	sleep
62	sleep	sleep	sleep
63	sleep	sleep	sleep
64	sleep	sleep	sleep
65	sleep	sleep	sleep
66	sleep	sleep	sleep
67	sleep	sleep	sleep
68	sleep	sleep	sleep
69	sleep	sleep	sleep
70	sleep	sleep	sleep
71	sleep	sleep	sleep
72	sleep	sleep	sleep
73	sleep	sleep	sleep
74	sleep	sleep	sleep
75	sleep	sleep	sleep
76	sleep	sleep	sleep
77	sleep	sleep	sleep
78	sleep	sleep	sleep
79	sleep	sleep	sleep
80	sleep	sleep	sleep
81	sleep	sleep	sleep
82	sleep	sleep	sleep
83	sleep	sleep	sleep
84	sleep	sleep	sleep
85	sleep	sleep	sleep
86	sleep	sleep	sleep
87	sleep	sleep	sleep
88	sleep	sleep	sleep
89	sleep	sleep	sleep
90	sleep	sleep	sleep
91	sleep	sleep	sleep
92	sleep	sleep	sleep
93	sleep	sleep	sleep
94	sleep	sleep	sleep
95	sleep	sleep	sleep
96	sleep	sleep	sleep
97	sleep	sleep	sleep
98	sleep	sleep	sleep
99	sleep	sleep	sleep
