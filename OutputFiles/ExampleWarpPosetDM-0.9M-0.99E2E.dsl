// Course CS2820 Authentication Tag: 3JDpgcyvRSHACa+sL04B/1GQ630UkA0fREZ8Nqva5v9za52SJ+o1MMbBs+ljICCJBEm62IsiBit9ZUaZunSaJgzC7vOUc4v4B84FfbFJAlc=
WARP system for graph Example created with the following parameters:
Scheduler Name:	WarpPosetDM
M:	0.9
E2E:	0.99
nChannels:	16
Time Slot	A	B	C
0	if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
1	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
2	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
3	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
4	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
5	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
6	if has(F0: A -> B) push(F0: A -> B, #0) else if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
7	if has(F0: A -> B) push(F0: A -> B, #0)	wait(#0)	sleep
8	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0)
9	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
10	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
11	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
12	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
13	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
14	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0) else if !has(F0: B -> C) pull(F0: B -> C, #0)
15	sleep	wait(#0)	if !has(F0: B -> C) pull(F0: B -> C, #0)
16	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0)
17	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
18	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
19	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
20	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
21	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
22	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0) else if has(F1: C -> B) push(F1: C -> B, #0)
23	sleep	wait(#0)	if has(F1: C -> B) push(F1: C -> B, #0)
24	if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
25	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
26	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
27	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
28	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
29	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
30	if !has(F1: B -> A) pull(F1: B -> A, #0) else if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
31	if !has(F1: B -> A) pull(F1: B -> A, #0)	wait(#0)	sleep
32	sleep	sleep	sleep
33	sleep	sleep	sleep
34	sleep	sleep	sleep
35	sleep	sleep	sleep
36	sleep	sleep	sleep
37	sleep	sleep	sleep
38	sleep	sleep	sleep
39	sleep	sleep	sleep
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
