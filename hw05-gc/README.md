### Outcome

According to performed experiments, the `G1` garbage collector is preferable option. 
It requires less time per execution in average and total execution time is the lowest one.
But at the same point, I've noticed that the `ConcMarkSweepGC` spent a bit less time on execution 
for `Yound generation`, so, it might be worth to use it if there is a need in spending less time on 
such pauses. Again, it is specific for this particular example and might not reflect 
to the situation in general.

### Results

#### Serial Collector [-XX:+UseSerialGC -verbose:gc]
```text
21:03:56.324 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 25800
21:03:56.326 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 20989
21:03:56.326 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26

21:04:38.411 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 29284
21:04:38.415 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 23989
21:04:38.415 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26

21:05:53.060 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 29809
21:05:53.063 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 24104
21:05:53.064 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26

21:07:20.892 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 26546
21:07:20.895 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 21697
21:07:20.895 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26

21:08:09.401 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 26500
21:08:09.404 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 21649
21:08:09.404 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26

Average execution - 864.83 ms
```

#### Parallel Collector [-XX:+UseParallelGC -verbose:gc]
```text
21:09:19.481 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 32705
21:09:19.485 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 27674
21:09:19.486 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 27

21:10:01.042 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 27635
21:10:01.045 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 22974
21:10:01.045 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 27

21:10:42.718 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 27310
21:10:42.721 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 22517
21:10:42.721 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 27

21:11:26.191 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 30428
21:11:26.194 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 25810
21:11:26.194 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 27

21:12:11.905 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 30551
21:12:11.909 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 25755
21:12:11.909 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 28

Average execution - 917.13 ms
```

#### CMS [-XX:+UseConcMarkSweepGC -verbose:gc]
```text
20:59:31.636 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 19222
20:59:31.639 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 15403
20:59:31.639 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 96

21:00:12.239 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 21840
21:00:12.243 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 18269
21:00:12.243 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 96

21:01:11.092 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 20076
21:01:11.095 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 22465
21:01:11.095 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 98

21:01:50.897 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 21729
21:01:50.903 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 25472
21:01:50.903 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 98

21:02:44.355 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 19936
21:02:44.358 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 21883
21:02:44.358 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 97

Average execution - 213.38 ms
```

Example of one of executions:
```text
[0.012s][info][gc] Using Concurrent Mark Sweep
[1.592s][info][gc] GC(0) Pause Young (Allocation Failure) 68M->26M(247M) 125.781ms
[1.719s][info][gc] GC(1) Pause Young (Allocation Failure) 94M->66M(247M) 64.374ms
[1.823s][info][gc] GC(2) Pause Young (Allocation Failure) 134M->102M(247M) 56.259ms
[1.826s][info][gc] GC(3) Pause Initial Mark 104M->104M(247M) 2.840ms
[1.826s][info][gc] GC(3) Concurrent Mark
[1.935s][info][gc] GC(4) Pause Young (Allocation Failure) 171M->139M(247M) 59.016ms
[2.042s][info][gc] GC(5) Pause Young (Allocation Failure) 207M->174M(247M) 60.302ms
[2.081s][info][gc] GC(3) Concurrent Mark 254.801ms
[2.081s][info][gc] GC(3) Concurrent Preclean
[2.175s][info][gc] GC(6) Pause Young (Allocation Failure) 242M->211M(280M) 82.540ms
[2.285s][info][gc] GC(7) Pause Young (Allocation Failure) 279M->249M(318M) 63.942ms
[2.389s][info][gc] GC(8) Pause Young (Allocation Failure) 317M->288M(357M) 54.902ms
[2.493s][info][gc] GC(9) Pause Young (Allocation Failure) 356M->327M(396M) 57.971ms
[2.591s][info][gc] GC(10) Pause Young (Allocation Failure) 395M->363M(432M) 49.758ms
[2.692s][info][gc] GC(11) Pause Young (Allocation Failure) 431M->399M(469M) 55.450ms
[2.726s][info][gc] GC(3) Concurrent Preclean 644.874ms
[2.726s][info][gc] GC(3) Concurrent Abortable Preclean
[2.791s][info][gc] GC(12) Pause Young (Allocation Failure) 468M->436M(505M) 52.333ms
[2.826s][info][gc] GC(3) Concurrent Abortable Preclean 99.485ms
[2.840s][info][gc] GC(3) Pause Remark 490M->490M(505M) 14.189ms
[2.840s][info][gc] GC(3) Concurrent Sweep
[2.904s][info][gc] GC(13) Pause Young (Allocation Failure) 504M->472M(541M) 53.326ms
[3.010s][info][gc] GC(14) Pause Young (Allocation Failure) 540M->508M(577M) 56.120ms
[3.031s][info][gc] GC(3) Concurrent Sweep 191.222ms
[3.033s][info][gc] GC(3) Concurrent Reset
[3.059s][info][gc] GC(3) Concurrent Reset 25.918ms
[3.106s][info][gc] GC(15) Pause Young (Allocation Failure) 577M->545M(910M) 46.773ms
[3.112s][info][gc] GC(16) Pause Initial Mark 548M->548M(910M) 3.284ms
[3.112s][info][gc] GC(16) Concurrent Mark
[3.213s][info][gc] GC(17) Pause Young (Allocation Failure) 614M->583M(910M) 54.681ms
[3.327s][info][gc] GC(18) Pause Young (Allocation Failure) 652M->620M(910M) 56.593ms
[3.425s][info][gc] GC(19) Pause Young (Allocation Failure) 688M->656M(910M) 50.721ms
[3.529s][info][gc] GC(20) Pause Young (Allocation Failure) 724M->692M(910M) 51.170ms
[3.632s][info][gc] GC(21) Pause Young (Allocation Failure) 760M->728M(910M) 54.293ms
[3.740s][info][gc] GC(22) Pause Young (Allocation Failure) 797M->765M(910M) 58.315ms
[3.842s][info][gc] GC(23) Pause Young (Allocation Failure) 833M->803M(910M) 52.239ms
[3.947s][info][gc] GC(24) Pause Young (Allocation Failure) 871M->841M(910M) 52.194ms
[4.051s][info][gc] GC(25) Pause Young (Allocation Failure) 909M->877M(946M) 57.379ms
[4.168s][info][gc] GC(26) Pause Young (Allocation Failure) 945M->913M(982M) 68.907ms
[4.272s][info][gc] GC(27) Pause Young (Allocation Failure) 982M->950M(1019M) 55.126ms
[4.375s][info][gc] GC(28) Pause Young (Allocation Failure) 1018M->986M(1055M) 55.438ms
[4.473s][info][gc] GC(29) Pause Young (Allocation Failure) 1054M->1023M(1092M) 50.295ms
[4.576s][info][gc] GC(30) Pause Young (Allocation Failure) 1091M->1060M(1129M) 54.346ms
[4.675s][info][gc] GC(31) Pause Young (Allocation Failure) 1128M->1098M(1167M) 53.783ms
[4.778s][info][gc] GC(32) Pause Young (Allocation Failure) 1166M->1134M(1203M) 52.780ms
[4.876s][info][gc] GC(33) Pause Young (Allocation Failure) 1202M->1170M(1239M) 50.622ms
[4.916s][info][gc] GC(16) Concurrent Mark 1803.986ms
[4.916s][info][gc] GC(16) Concurrent Preclean
[4.977s][info][gc] GC(34) Pause Young (Allocation Failure) 1238M->1206M(1275M) 54.918ms
[5.077s][info][gc] GC(35) Pause Young (Allocation Failure) 1275M->1243M(1312M) 52.170ms
[5.185s][info][gc] GC(36) Pause Young (Allocation Failure) 1311M->1279M(1348M) 59.579ms
[5.298s][info][gc] GC(37) Pause Young (Allocation Failure) 1347M->1316M(1385M) 67.098ms
[5.404s][info][gc] GC(38) Pause Young (Allocation Failure) 1384M->1354M(1423M) 58.182ms
[5.503s][info][gc] GC(39) Pause Young (Allocation Failure) 1423M->1390M(1459M) 52.878ms
[5.605s][info][gc] GC(40) Pause Young (Allocation Failure) 1458M->1427M(1496M) 53.692ms
[5.705s][info][gc] GC(41) Pause Young (Allocation Failure) 1495M->1463M(1532M) 53.419ms
[5.809s][info][gc] GC(42) Pause Young (Allocation Failure) 1531M->1499M(1568M) 56.078ms
[5.911s][info][gc] GC(43) Pause Young (Allocation Failure) 1568M->1536M(1605M) 56.071ms
[6.025s][info][gc] GC(44) Pause Young (Allocation Failure) 1604M->1573M(1642M) 61.205ms
[6.143s][info][gc] GC(45) Pause Young (Allocation Failure) 1642M->1611M(1680M) 72.008ms
[6.276s][info][gc] GC(46) Pause Young (Allocation Failure) 1680M->1647M(1716M) 84.647ms
[6.392s][info][gc] GC(47) Pause Young (Allocation Failure) 1716M->1684M(1753M) 64.575ms
[6.528s][info][gc] GC(48) Pause Young (Allocation Failure) 1752M->1720M(1789M) 88.036ms
[6.652s][info][gc] GC(49) Pause Young (Allocation Failure) 1789M->1756M(1825M) 72.099ms
[6.827s][info][gc] GC(50) Pause Young (Allocation Failure) 1825M->1793M(1862M) 127.552ms
[6.943s][info][gc] GC(51) Pause Young (Allocation Failure) 1862M->1830M(1899M) 68.639ms
[7.063s][info][gc] GC(52) Pause Young (Allocation Failure) 1898M->1867M(1936M) 74.149ms
[7.196s][info][gc] GC(53) Pause Young (Allocation Failure) 1935M->1903M(1972M) 79.278ms
[7.335s][info][gc] GC(54) Pause Young (Allocation Failure) 1972M->1939M(2008M) 91.690ms
[7.521s][info][gc] GC(55) Pause Young (Allocation Failure) 2008M->1976M(2045M) 136.312ms
[7.636s][info][gc] GC(56) Pause Young (Allocation Failure) 2044M->2012M(2081M) 65.805ms
[7.748s][info][gc] GC(57) Pause Young (Allocation Failure) 2080M->2049M(2118M) 65.952ms
[7.863s][info][gc] GC(58) Pause Young (Allocation Failure) 2117M->2086M(2155M) 67.309ms
[7.983s][info][gc] GC(59) Pause Young (Allocation Failure) 2155M->2124M(2193M) 74.266ms
[8.105s][info][gc] GC(60) Pause Young (Allocation Failure) 2192M->2159M(2228M) 66.852ms
[8.236s][info][gc] GC(61) Pause Young (Allocation Failure) 2228M->2196M(2265M) 74.854ms
[8.369s][info][gc] GC(62) Pause Young (Allocation Failure) 2264M->2232M(2301M) 86.465ms
[8.498s][info][gc] GC(63) Pause Young (Allocation Failure) 2300M->2268M(2337M) 83.215ms
[8.627s][info][gc] GC(64) Pause Young (Allocation Failure) 2337M->2305M(2374M) 81.422ms
[8.766s][info][gc] GC(65) Pause Young (Allocation Failure) 2374M->2343M(2412M) 90.791ms
[8.897s][info][gc] GC(66) Pause Young (Allocation Failure) 2411M->2378M(2447M) 84.014ms
[9.035s][info][gc] GC(67) Pause Young (Allocation Failure) 2447M->2415M(2484M) 90.562ms
[9.177s][info][gc] GC(68) Pause Young (Allocation Failure) 2483M->2451M(2520M) 96.694ms
[9.312s][info][gc] GC(69) Pause Young (Allocation Failure) 2520M->2487M(2556M) 89.132ms
[9.464s][info][gc] GC(70) Pause Young (Allocation Failure) 2556M->2524M(2593M) 98.339ms
[9.594s][info][gc] GC(71) Pause Young (Allocation Failure) 2593M->2561M(2630M) 83.243ms
[9.714s][info][gc] GC(72) Pause Young (Allocation Failure) 2629M->2598M(2667M) 73.249ms
[9.854s][info][gc] GC(73) Pause Young (Allocation Failure) 2667M->2635M(2704M) 93.942ms
[9.982s][info][gc] GC(74) Pause Young (Allocation Failure) 2703M->2671M(2740M) 82.494ms
[10.110s][info][gc] GC(75) Pause Young (Allocation Failure) 2739M->2707M(2776M) 81.458ms
[10.215s][info][gc] GC(76) Pause Young (Allocation Failure) 2776M->2744M(2813M) 57.812ms
[10.322s][info][gc] GC(77) Pause Young (Allocation Failure) 2812M->2781M(2850M) 60.771ms
[10.438s][info][gc] GC(78) Pause Young (Allocation Failure) 2849M->2818M(2887M) 66.984ms
[10.549s][info][gc] GC(79) Pause Young (Allocation Failure) 2887M->2854M(2923M) 64.625ms
[10.662s][info][gc] GC(80) Pause Young (Allocation Failure) 2922M->2891M(2960M) 67.492ms
[10.786s][info][gc] GC(81) Pause Young (Allocation Failure) 2959M->2927M(2996M) 76.694ms
[10.901s][info][gc] GC(82) Pause Young (Allocation Failure) 2995M->2964M(3033M) 67.841ms
[11.031s][info][gc] GC(83) Pause Young (Allocation Failure) 3032M->3000M(3069M) 74.321ms
[11.154s][info][gc] GC(84) Pause Young (Allocation Failure) 3068M->3037M(3106M) 77.602ms
[11.291s][info][gc] GC(85) Pause Young (Allocation Failure) 3106M->3076M(3145M) 88.962ms
[11.422s][info][gc] GC(86) Pause Young (Allocation Failure) 3144M->3111M(3181M) 81.485ms
[11.542s][info][gc] GC(87) Pause Young (Allocation Failure) 3180M->3148M(3217M) 67.652ms
[11.663s][info][gc] GC(88) Pause Young (Allocation Failure) 3216M->3184M(3253M) 74.219ms
[11.788s][info][gc] GC(89) Pause Young (Allocation Failure) 3252M->3221M(3290M) 78.620ms
[11.921s][info][gc] GC(90) Pause Young (Allocation Failure) 3289M->3257M(3326M) 84.477ms
[12.053s][info][gc] GC(91) Pause Young (Allocation Failure) 3325M->3295M(3364M) 85.242ms
[12.184s][info][gc] GC(92) Pause Young (Allocation Failure) 3363M->3332M(3401M) 82.468ms
[12.309s][info][gc] GC(93) Pause Young (Allocation Failure) 3401M->3368M(3437M) 78.633ms
[12.443s][info][gc] GC(94) Pause Young (Allocation Failure) 3436M->3405M(3474M) 88.100ms
[12.508s][info][gc] GC(16) Concurrent Preclean 7592.371ms
[22.861s][info][gc] GC(96) Pause Full (Allocation Failure) 3473M->3362M(3474M) 10368.816ms
[22.861s][info][gc] GC(95) Pause Young (Allocation Failure) 3473M->3362M(4029M) 10369.579ms
21:18:47.266 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 21865
21:18:47.271 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 18072
21:18:47.271 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 96
```

#### G1 [-XX:+UseG1GC -verbose:gc]
```text
21:12:53.495 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 9286
21:12:53.498 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2769
21:12:53.498 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 33

21:13:17.214 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 8982
21:13:17.216 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2675
21:13:17.217 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 34

21:13:37.170 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 8764
21:13:37.174 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2537
21:13:37.174 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 33

21:14:00.418 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 8945
21:14:00.421 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2550
21:14:00.421 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 32

21:14:20.115 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 9081
21:14:20.118 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2632
21:14:20.118 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 32

Average execution - 80.26 ms
```

Example of one of executions:
```text
[0.013s][info][gc] Using G1
[0.945s][info][gc] GC(0) Pause Young (Normal) (G1 Evacuation Pause) 24M->2M(256M) 4.705ms
[1.433s][info][gc] GC(1) Pause Young (Normal) (G1 Evacuation Pause) 138M->68M(256M) 56.948ms
[1.500s][info][gc] GC(2) Pause Young (Normal) (G1 Evacuation Pause) 104M->87M(256M) 27.250ms
[1.564s][info][gc] GC(3) Pause Young (Normal) (G1 Evacuation Pause) 133M->111M(256M) 23.761ms
[1.636s][info][gc] GC(4) Pause Young (Normal) (G1 Evacuation Pause) 168M->143M(256M) 23.439ms
[1.649s][info][gc] GC(5) Pause Young (Concurrent Start) (G1 Humongous Allocation) 143M->145M(512M) 11.826ms
[1.649s][info][gc] GC(6) Concurrent Cycle
[1.792s][info][gc] GC(7) Pause Young (Normal) (G1 Evacuation Pause) 222M->184M(512M) 20.524ms
[1.842s][info][gc] GC(6) Pause Remark 241M->241M(512M) 1.309ms
[1.888s][info][gc] GC(8) Pause Young (Normal) (G1 Evacuation Pause) 261M->223M(512M) 28.819ms
[1.970s][info][gc] GC(9) Pause Young (Normal) (G1 Evacuation Pause) 302M->264M(512M) 27.106ms
[2.026s][info][gc] GC(6) Pause Cleanup 343M->343M(512M) 0.135ms
[2.029s][info][gc] GC(6) Concurrent Cycle 379.601ms
[2.082s][info][gc] GC(10) Pause Young (Concurrent Start) (G1 Humongous Allocation) 352M->310M(1024M) 48.559ms
[2.082s][info][gc] GC(11) Concurrent Cycle
[2.445s][info][gc] GC(12) Pause Young (Normal) (G1 Evacuation Pause) 545M->427M(1024M) 73.022ms
[2.450s][info][gc] GC(11) Pause Remark 431M->429M(1024M) 1.735ms
[2.674s][info][gc] GC(13) Pause Young (Normal) (G1 Evacuation Pause) 656M->540M(1024M) 72.424ms
[2.781s][info][gc] GC(11) Pause Cleanup 691M->691M(1024M) 0.224ms
[2.786s][info][gc] GC(11) Concurrent Cycle 703.694ms
[2.854s][info][gc] GC(14) Pause Young (Concurrent Start) (G1 Humongous Allocation) 701M->622M(1024M) 66.063ms
[2.854s][info][gc] GC(15) Concurrent Cycle
[3.037s][info][gc] GC(16) Pause Young (Normal) (G1 Evacuation Pause) 768M->694M(2253M) 67.017ms
[3.572s][info][gc] GC(17) Pause Young (Normal) (G1 Evacuation Pause) 1044M->866M(2253M) 110.183ms
[3.616s][info][gc] GC(15) Pause Remark 922M->920M(2253M) 1.827ms
[3.973s][info][gc] GC(18) Pause Young (Normal) (G1 Evacuation Pause) 1253M->1053M(2253M) 118.053ms
[4.412s][info][gc] GC(19) Pause Young (Normal) (G1 Evacuation Pause) 1461M->1254M(2253M) 158.182ms
[4.432s][info][gc] GC(15) Pause Cleanup 1275M->1275M(2253M) 0.480ms
[4.445s][info][gc] GC(15) Concurrent Cycle 1591.174ms
[4.520s][info][gc] GC(20) Pause Young (Concurrent Start) (G1 Humongous Allocation) 1292M->1278M(2991M) 72.600ms
[4.520s][info][gc] GC(21) Concurrent Cycle
[5.253s][info][gc] GC(22) Pause Young (Normal) (G1 Evacuation Pause) 1637M->1450M(2991M) 212.953ms
[5.549s][info][gc] GC(23) Pause Young (Normal) (G1 Evacuation Pause) 1670M->1559M(2991M) 108.370ms
[5.871s][info][gc] GC(24) Pause Young (Normal) (G1 Evacuation Pause) 1830M->1692M(2991M) 121.971ms
[6.215s][info][gc] GC(25) Pause Young (Normal) (G1 Evacuation Pause) 1982M->1836M(3433M) 117.338ms
[6.381s][info][gc] GC(21) Pause Remark 1964M->1962M(3433M) 1.742ms
[6.710s][info][gc] GC(26) Pause Young (Normal) (G1 Evacuation Pause) 2140M->1984M(3433M) 117.827ms
[7.090s][info][gc] GC(27) Pause Young (Normal) (G1 Evacuation Pause) 2316M->2145M(3433M) 129.320ms
[7.452s][info][gc] GC(28) Pause Young (Normal) (G1 Evacuation Pause) 2486M->2313M(3433M) 126.431ms
[7.922s][info][gc] GC(29) Pause Young (Normal) (G1 Evacuation Pause) 2672M->2491M(3676M) 211.423ms
[8.350s][info][gc] GC(21) Pause Cleanup 2747M->2747M(3676M) 2.969ms
[8.464s][info][gc] GC(21) Concurrent Cycle 3944.786ms
[8.634s][info][gc] GC(30) Pause Young (Concurrent Start) (G1 Humongous Allocation) 2774M->2629M(3676M) 161.113ms
[8.634s][info][gc] GC(31) Concurrent Cycle
[8.994s][info][gc] GC(32) Pause Young (Normal) (G1 Evacuation Pause) 2934M->2779M(3676M) 115.507ms
[9.304s][info][gc] GC(33) Pause Young (Normal) (G1 Evacuation Pause) 3064M->2921M(3676M) 102.264ms
[9.557s][info][gc] GC(34) Pause Young (Normal) (G1 Evacuation Pause) 3133M->3027M(3844M) 90.730ms
[10.077s][info][gc] GC(35) Pause Young (Normal) (G1 Evacuation Pause) 3260M->3141M(3844M) 106.203ms
[10.301s][info][gc] GC(36) Pause Young (Normal) (G1 Evacuation Pause) 3331M->3237M(3844M) 73.652ms
[10.520s][info][gc] GC(37) Pause Young (Normal) (G1 Evacuation Pause) 3432M->3333M(3844M) 73.437ms
[10.760s][info][gc] GC(38) Pause Young (Normal) (G1 Evacuation Pause) 3528M->3431M(3902M) 82.955ms
21:24:54.036 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 9811
21:24:54.042 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2956
21:24:54.042 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 33
```

#### ZGC [-XX:+UnlockExperimentalVMOptions -XX:+UseZGC -verbose:gc]
```text
Error occurred during initialization of VM
Option -XX:+UseZGC not supported
```