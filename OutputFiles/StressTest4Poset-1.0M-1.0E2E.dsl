// Course CS2820 Authentication Tag: KsHSMYtQl1ijMSrGxE6Go5PoLm0NA+Icgzcme1NTTZE4z+xBWxMSay+oQB2rtaBtSOk2On6IpWHpE9h3KVlw0ZjxJunf1nbBQ3B4jIhAED8=
WARP system for graph StressTest4 created with the following parameters:
Scheduler Name:	Poset
M:	1.0
E2E:	1.0
nChannels:	16
Time Slot	A	B	C	D	E	F	G	H	I	J	K	L
0	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
1	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
2	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
3	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
4	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
5	wait(#1)	if !has(F4: A -> B) pull(F4: A -> B, #1)	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
6	wait(#1)	if !has(F4: A -> B) pull(F4: A -> B, #1) else if has(F4: B -> C) push(F4: B -> C, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
7	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
8	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
9	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1)	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
10	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1) else if has(F5: B -> C) push(F5: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
11	sleep	sleep	wait(#1)	if !has(F4: C -> D) pull(F4: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
12	sleep	sleep	wait(#1)	if !has(F4: C -> D) pull(F4: C -> D, #1) else if has(F4: D -> E) push(F4: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
13	sleep	if has(F6: B -> C) push(F6: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #0)	sleep	sleep
14	sleep	sleep	wait(#1)	if !has(F6: C -> D) pull(F6: C -> D, #1)	wait(#0)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #0) else if has(F4: J -> K) push(F4: J -> K, #0)	wait(#0)	sleep
15	sleep	sleep	wait(#1)	if !has(F5: C -> D) pull(F5: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F4: K -> L) pull(F4: K -> L, #0)
16	sleep	sleep	wait(#1)	if !has(F5: C -> D) pull(F5: C -> D, #1) else if has(F5: D -> E) push(F5: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
17	wait(#0)	if !has(F7: A -> B) pull(F7: A -> B, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
18	wait(#0)	if !has(F7: A -> B) pull(F7: A -> B, #0) else if has(F7: B -> C) push(F7: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
19	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
20	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
21	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
22	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
23	sleep	sleep	wait(#0)	if !has(F7: C -> D) pull(F7: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
24	sleep	sleep	wait(#0)	if !has(F7: C -> D) pull(F7: C -> D, #0) else if has(F7: D -> E) push(F7: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
25	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
26	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0) else if has(F8: D -> E) push(F8: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
27	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1)	sleep	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
28	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1) else if has(F9: B -> C) push(F9: B -> C, #1)	wait(#1)	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0) else if has(F8: F -> G) push(F8: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
29	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0)	sleep	sleep	sleep	sleep
30	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1) else if has(F9: D -> E) push(F9: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0) else if has(F8: H -> I) push(F8: H -> I, #0)	wait(#0)	sleep	sleep	sleep
31	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #0)	sleep	sleep
32	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #0) else if has(F9: J -> K) push(F9: J -> K, #0)	wait(#0)	sleep
33	sleep	sleep	wait(#1)	if !has(F10: C -> D) pull(F10: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F9: K -> L) pull(F9: K -> L, #0)
34	sleep	sleep	wait(#1)	if !has(F10: C -> D) pull(F10: C -> D, #1) else if has(F10: D -> E) push(F10: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
35	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #0)	sleep	sleep
36	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #0) else if has(F10: J -> K) push(F10: J -> K, #0)	wait(#0)	sleep
37	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F10: K -> L) pull(F10: K -> L, #0)
38	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
39	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
40	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
41	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
42	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
43	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
44	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
45	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
46	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
47	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
48	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
49	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
50	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
51	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
52	sleep	sleep	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
53	sleep	sleep	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
54	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
55	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
56	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
57	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
58	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
59	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
60	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
61	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
62	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
63	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
64	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
65	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
66	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
67	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
68	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
69	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
70	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
71	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
72	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
73	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
74	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
75	wait(#0)	if !has(F4: A -> B) pull(F4: A -> B, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
76	wait(#0)	if !has(F4: A -> B) pull(F4: A -> B, #0) else if has(F4: B -> C) push(F4: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
77	sleep	sleep	wait(#0)	if !has(F4: C -> D) pull(F4: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
78	sleep	sleep	wait(#0)	if !has(F4: C -> D) pull(F4: C -> D, #0) else if has(F4: D -> E) push(F4: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
79	sleep	if has(F6: B -> C) push(F6: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #1)	sleep	sleep
80	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #1) else if has(F4: J -> K) push(F4: J -> K, #1)	wait(#1)	sleep
81	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#1)	if !has(F4: K -> L) pull(F4: K -> L, #1)
82	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
83	wait(#0)	if !has(F5: A -> B) pull(F5: A -> B, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
84	wait(#0)	if !has(F5: A -> B) pull(F5: A -> B, #0) else if has(F5: B -> C) push(F5: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
85	sleep	sleep	wait(#0)	if !has(F5: C -> D) pull(F5: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
86	sleep	sleep	wait(#0)	if !has(F5: C -> D) pull(F5: C -> D, #0) else if has(F5: D -> E) push(F5: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
87	sleep	sleep	wait(#0)	if !has(F6: C -> D) pull(F6: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
88	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
89	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
90	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
91	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
92	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
93	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
94	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
95	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
96	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
97	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
98	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
99	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
100	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
101	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
102	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
103	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
104	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
105	wait(#1)	if !has(F7: A -> B) pull(F7: A -> B, #1)	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
106	wait(#1)	if !has(F7: A -> B) pull(F7: A -> B, #1) else if has(F7: B -> C) push(F7: B -> C, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
107	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
108	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
109	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1)	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
110	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1) else if has(F9: B -> C) push(F9: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
111	sleep	sleep	wait(#1)	if !has(F7: C -> D) pull(F7: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
112	sleep	sleep	wait(#1)	if !has(F7: C -> D) pull(F7: C -> D, #1) else if has(F7: D -> E) push(F7: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
113	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
114	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0) else if has(F8: D -> E) push(F8: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
115	sleep	sleep	sleep	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
116	sleep	sleep	sleep	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0) else if has(F8: F -> G) push(F8: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
117	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0)	sleep	sleep	sleep	sleep
118	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1) else if has(F9: D -> E) push(F9: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0) else if has(F8: H -> I) push(F8: H -> I, #0)	wait(#0)	sleep	sleep	sleep
119	sleep	sleep	sleep	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #1)	sleep	sleep
120	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #1) else if has(F9: J -> K) push(F9: J -> K, #1)	wait(#1)	sleep
121	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#1)	if !has(F9: K -> L) pull(F9: K -> L, #1)
122	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
123	sleep	sleep	wait(#0)	if !has(F10: C -> D) pull(F10: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
124	sleep	sleep	wait(#0)	if !has(F10: C -> D) pull(F10: C -> D, #0) else if has(F10: D -> E) push(F10: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
125	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #0)	sleep	sleep
126	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #0) else if has(F10: J -> K) push(F10: J -> K, #0)	wait(#0)	sleep
127	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F10: K -> L) pull(F10: K -> L, #0)
128	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
129	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
130	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
131	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
132	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
133	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
134	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
135	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
136	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
137	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
138	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
139	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
140	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
141	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
142	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
143	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
144	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
145	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
146	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
147	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
148	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
149	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
150	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
151	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
152	wait(#1)	if !has(F4: A -> B) pull(F4: A -> B, #1)	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
153	wait(#1)	if !has(F4: A -> B) pull(F4: A -> B, #1) else if has(F4: B -> C) push(F4: B -> C, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
154	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
155	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
156	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1)	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
157	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1) else if has(F5: B -> C) push(F5: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
158	sleep	sleep	wait(#1)	if !has(F4: C -> D) pull(F4: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
159	sleep	sleep	wait(#1)	if !has(F4: C -> D) pull(F4: C -> D, #1) else if has(F4: D -> E) push(F4: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
160	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #1)	sleep	sleep
161	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #1) else if has(F4: J -> K) push(F4: J -> K, #1)	wait(#1)	sleep
162	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#1)	if !has(F4: K -> L) pull(F4: K -> L, #1)
163	sleep	sleep	wait(#0)	if !has(F5: C -> D) pull(F5: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
164	sleep	sleep	wait(#0)	if !has(F5: C -> D) pull(F5: C -> D, #0) else if has(F5: D -> E) push(F5: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
165	sleep	if has(F6: B -> C) push(F6: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
166	sleep	sleep	wait(#0)	if !has(F6: C -> D) pull(F6: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
167	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
168	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
169	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
170	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
171	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
172	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
173	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
174	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
175	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
176	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
177	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
178	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
179	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
180	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
181	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
182	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
183	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
184	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
185	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
186	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
187	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
188	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
189	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
190	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
191	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
192	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
193	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
194	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
195	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
196	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
197	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
198	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
199	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
200	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
201	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
202	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
203	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
204	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
205	wait(#1)	if !has(F7: A -> B) pull(F7: A -> B, #1)	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
206	wait(#1)	if !has(F7: A -> B) pull(F7: A -> B, #1) else if has(F7: B -> C) push(F7: B -> C, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
207	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
208	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
209	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1)	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
210	wait(#1)	if !has(F9: A -> B) pull(F9: A -> B, #1) else if has(F9: B -> C) push(F9: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
211	sleep	sleep	wait(#1)	if !has(F7: C -> D) pull(F7: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
212	sleep	sleep	wait(#1)	if !has(F7: C -> D) pull(F7: C -> D, #1) else if has(F7: D -> E) push(F7: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
213	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
214	sleep	sleep	wait(#0)	if !has(F8: C -> D) pull(F8: C -> D, #0) else if has(F8: D -> E) push(F8: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
215	sleep	sleep	sleep	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
216	sleep	sleep	sleep	sleep	wait(#0)	if !has(F8: E -> F) pull(F8: E -> F, #0) else if has(F8: F -> G) push(F8: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
217	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0)	sleep	sleep	sleep	sleep
218	sleep	sleep	wait(#1)	if !has(F9: C -> D) pull(F9: C -> D, #1) else if has(F9: D -> E) push(F9: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F8: G -> H) pull(F8: G -> H, #0) else if has(F8: H -> I) push(F8: H -> I, #0)	wait(#0)	sleep	sleep	sleep
219	sleep	sleep	sleep	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #1)	sleep	sleep
220	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F9: E -> J) pull(F9: E -> J, #1) else if has(F9: J -> K) push(F9: J -> K, #1)	wait(#1)	sleep
221	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#1)	if !has(F9: K -> L) pull(F9: K -> L, #1)
222	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
223	sleep	sleep	wait(#0)	if !has(F10: C -> D) pull(F10: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
224	sleep	sleep	wait(#0)	if !has(F10: C -> D) pull(F10: C -> D, #0) else if has(F10: D -> E) push(F10: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
225	wait(#0)	if !has(F4: A -> B) pull(F4: A -> B, #0)	sleep	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #1)	sleep	sleep
226	wait(#0)	if !has(F4: A -> B) pull(F4: A -> B, #0) else if has(F4: B -> C) push(F4: B -> C, #0)	wait(#0)	sleep	wait(#1)	sleep	sleep	sleep	sleep	if !has(F10: E -> J) pull(F10: E -> J, #1) else if has(F10: J -> K) push(F10: J -> K, #1)	wait(#1)	sleep
227	sleep	sleep	wait(#0)	if !has(F4: C -> D) pull(F4: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#1)	if !has(F10: K -> L) pull(F10: K -> L, #1)
228	sleep	sleep	wait(#0)	if !has(F4: C -> D) pull(F4: C -> D, #0) else if has(F4: D -> E) push(F4: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
229	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1)	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #0)	sleep	sleep
230	wait(#1)	if !has(F5: A -> B) pull(F5: A -> B, #1) else if has(F5: B -> C) push(F5: B -> C, #1)	wait(#1)	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F4: E -> J) pull(F4: E -> J, #0) else if has(F4: J -> K) push(F4: J -> K, #0)	wait(#0)	sleep
231	sleep	sleep	wait(#1)	if !has(F5: C -> D) pull(F5: C -> D, #1)	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F4: K -> L) pull(F4: K -> L, #0)
232	sleep	sleep	wait(#1)	if !has(F5: C -> D) pull(F5: C -> D, #1) else if has(F5: D -> E) push(F5: D -> E, #1)	wait(#1)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
233	sleep	if has(F6: B -> C) push(F6: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
234	sleep	sleep	wait(#0)	if !has(F6: C -> D) pull(F6: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
235	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
236	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
237	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
238	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
239	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
240	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
241	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
242	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
243	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
244	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
245	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
246	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
247	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
248	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
249	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
250	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
251	sleep	sleep	wait(#0)	if !has(F2: C -> D) pull(F2: C -> D, #0) else if has(F2: D -> E) push(F2: D -> E, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep
252	sleep	sleep	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0)	sleep	sleep	sleep	sleep	sleep	sleep
253	sleep	sleep	sleep	sleep	wait(#0)	if !has(F2: E -> F) pull(F2: E -> F, #0) else if has(F2: F -> G) push(F2: F -> G, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep
254	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1)	sleep	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0)	sleep	sleep	sleep	sleep
255	sleep	sleep	wait(#1)	if !has(F3: C -> D) pull(F3: C -> D, #1) else if has(F3: D -> E) push(F3: D -> E, #1)	wait(#1)	sleep	wait(#0)	if !has(F2: G -> H) pull(F2: G -> H, #0) else if has(F2: H -> I) push(F2: H -> I, #0)	wait(#0)	sleep	sleep	sleep
256	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0)	sleep	sleep
257	sleep	sleep	sleep	sleep	wait(#0)	sleep	sleep	sleep	sleep	if !has(F3: E -> J) pull(F3: E -> J, #0) else if has(F3: J -> K) push(F3: J -> K, #0)	wait(#0)	sleep
258	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	wait(#0)	if !has(F3: K -> L) pull(F3: K -> L, #0)
259	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
260	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
261	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
262	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
263	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
264	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
265	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
266	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
267	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
268	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
269	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
270	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
271	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
272	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
273	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
274	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
275	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
276	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
277	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
278	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
279	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
280	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
281	sleep	if has(F1: B -> C) push(F1: B -> C, #0)	wait(#0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
282	sleep	sleep	wait(#0)	if !has(F1: C -> D) pull(F1: C -> D, #0)	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
283	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
284	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
285	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
286	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
287	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
288	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
289	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
290	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
291	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
292	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
293	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
294	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
295	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
296	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
297	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
298	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
299	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep	sleep
