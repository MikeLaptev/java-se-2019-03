### Results

#### Serial Collector [-XX:+UseSerialGC]
```text
[0.012s][info][gc] Using Serial
[1.001s][info][gc] GC(0) Pause Young (Allocation Failure) 68M->22M(247M) 49.075ms
[1.160s][info][gc] GC(1) Pause Young (Allocation Failure) 90M->50M(247M) 91.057ms
[1.284s][info][gc] GC(2) Pause Young (Allocation Failure) 119M->81M(247M) 72.301ms
[1.392s][info][gc] GC(3) Pause Young (Allocation Failure) 150M->112M(247M) 60.200ms
[1.495s][info][gc] GC(4) Pause Young (Allocation Failure) 180M->143M(247M) 58.683ms
[1.596s][info][gc] GC(5) Pause Young (Allocation Failure) 211M->174M(247M) 56.745ms
[2.057s][info][gc] GC(7) Pause Full (Allocation Failure) 205M->205M(274M) 350.862ms
[2.057s][info][gc] GC(6) Pause Young (Allocation Failure) 242M->205M(476M) 419.532ms
[2.337s][info][gc] GC(8) Pause Young (Allocation Failure) 328M->261M(476M) 184.845ms
[2.537s][info][gc] GC(9) Pause Young (Allocation Failure) 393M->321M(476M) 118.401ms
[3.369s][info][gc] GC(11) Pause Full (Allocation Failure) 382M->382M(514M) 636.299ms
[3.369s][info][gc] GC(10) Pause Young (Allocation Failure) 453M->382M(884M) 749.502ms
[3.898s][info][gc] GC(12) Pause Young (Allocation Failure) 610M->486M(884M) 355.531ms
[4.274s][info][gc] GC(13) Pause Young (Allocation Failure) 730M->596M(884M) 225.754ms
[5.796s][info][gc] GC(15) Pause Full (Allocation Failure) 708M->708M(952M) 1153.913ms
[5.797s][info][gc] GC(14) Pause Young (Allocation Failure) 840M->708M(1637M) 1372.401ms
[6.755s][info][gc] GC(16) Pause Young (Allocation Failure) 1129M->898M(1637M) 633.771ms
[7.467s][info][gc] GC(17) Pause Young (Allocation Failure) 1350M->1104M(1637M) 415.201ms
[10.757s][info][gc] GC(19) Pause Full (Allocation Failure) 1309M->1305M(1761M) 2612.571ms
[10.759s][info][gc] GC(18) Pause Young (Allocation Failure) 1555M->1305M(3027M) 3011.754ms
[12.684s][info][gc] GC(20) Pause Young (Allocation Failure) 2088M->1659M(3027M) 1291.190ms
[14.025s][info][gc] GC(21) Pause Young (Allocation Failure) 2494M->2039M(3027M) 804.052ms
[19.633s][info][gc] GC(23) Pause Full (Allocation Failure) 2419M->2419M(3254M) 4123.966ms
[19.634s][info][gc] GC(22) Pause Young (Allocation Failure) 2874M->2419M(3959M) 4995.686ms
[25.576s][info][gc] GC(25) Pause Full (Allocation Failure) 3407M->2868M(3959M) 5300.578ms
[25.576s][info][gc] GC(24) Pause Young (Allocation Failure) 3407M->2868M(3959M) 5300.639ms
00:22:52.118 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 24953
00:22:52.121 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 20261
00:22:52.121 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 26
```

#### Parallel Collector [-XX:+UseParallelGC]
```text
[0.012s][info][gc] Using Parallel
[0.885s][info][gc] GC(0) Pause Young (Allocation Failure) 64M->20M(245M) 19.893ms
[0.981s][info][gc] GC(1) Pause Young (Allocation Failure) 84M->46M(309M) 35.782ms
[1.160s][info][gc] GC(2) Pause Young (Allocation Failure) 174M->104M(309M) 70.213ms
[1.324s][info][gc] GC(3) Pause Young (Allocation Failure) 232M->161M(437M) 58.156ms
[2.154s][info][gc] GC(4) Pause Full (Ergonomics) 161M->160M(607M) 829.656ms
[2.480s][info][gc] GC(5) Pause Young (Allocation Failure) 416M->275M(600M) 97.806ms
[3.243s][info][gc] GC(6) Pause Full (Ergonomics) 275M->275M(938M) 762.861ms
[3.502s][info][gc] GC(7) Pause Young (Allocation Failure) 524M->389M(994M) 72.846ms
[3.973s][info][gc] GC(8) Pause Young (Allocation Failure) 694M->528M(1014M) 252.930ms
[4.531s][info][gc] GC(9) Pause Young (Allocation Failure) 833M->664M(1133M) 347.907ms
[5.273s][info][gc] GC(10) Pause Young (Allocation Failure) 1007M->820M(1199M) 466.569ms
[8.489s][info][gc] GC(11) Pause Full (Ergonomics) 820M->819M(1560M) 3215.668ms
[9.673s][info][gc] GC(12) Pause Young (Allocation Failure) 1162M->975M(1681M) 804.903ms
[10.769s][info][gc] GC(13) Pause Young (Allocation Failure) 1352M->1146M(1737M) 721.527ms
[11.941s][info][gc] GC(14) Pause Young (Allocation Failure) 1523M->1318M(1834M) 804.467ms
[16.271s][info][gc] GC(15) Pause Full (Ergonomics) 1318M->1316M(2303M) 4329.369ms
[17.338s][info][gc] GC(16) Pause Young (Allocation Failure) 1771M->1526M(2303M) 710.901ms
[18.241s][info][gc] GC(17) Pause Young (Allocation Failure) 1981M->1732M(2303M) 555.093ms
[21.786s][info][gc] GC(18) Pause Full (Ergonomics) 1732M->1730M(2916M) 3544.972ms
[22.583s][info][gc] GC(19) Pause Young (Allocation Failure) 2185M->1938M(2916M) 510.540ms
[25.635s][info][gc] GC(20) Pause Full (Ergonomics) 1938M->1936M(3634M) 3051.607ms
[26.001s][info][gc] GC(21) Pause Young (Allocation Failure) 2391M->2144M(3634M) 89.105ms
[26.523s][info][gc] GC(22) Pause Young (Allocation Failure) 2599M->2350M(3634M) 235.594ms
[27.032s][info][gc] GC(23) Pause Young (Allocation Failure) 2805M->2557M(3634M) 228.226ms
[27.578s][info][gc] GC(24) Pause Young (Allocation Failure) 3012M->2766M(3634M) 264.405ms
[32.972s][info][gc] GC(25) Pause Full (Ergonomics) 2766M->2764M(3641M) 5393.655ms
[36.765s][info][gc] GC(26) Pause Full (Ergonomics) 3219M->2969M(3641M) 3504.707ms
00:21:38.032 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 36071
00:21:38.035 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 30981
00:21:38.035 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 27
```

#### CMS [-XX:+UseConcMarkSweepGC]
```text
Java HotSpot(TM) 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.
[0.019s][info][gc] Using Concurrent Mark Sweep
[0.965s][info][gc] GC(0) Pause Young (Allocation Failure) 68M->29M(247M) 156.293ms
[1.086s][info][gc] GC(1) Pause Young (Allocation Failure) 98M->67M(247M) 61.326ms
[1.198s][info][gc] GC(2) Pause Young (Allocation Failure) 135M->103M(247M) 65.227ms
[1.205s][info][gc] GC(3) Pause Initial Mark 109M->109M(247M) 3.766ms
[1.205s][info][gc] GC(3) Concurrent Mark
[1.326s][info][gc] GC(4) Pause Young (Allocation Failure) 172M->140M(247M) 69.491ms
[1.446s][info][gc] GC(5) Pause Young (Allocation Failure) 208M->175M(247M) 66.106ms
[1.564s][info][gc] GC(6) Pause Young (Allocation Failure) 243M->212M(281M) 66.974ms
[1.597s][info][gc] GC(3) Concurrent Mark 391.734ms
[1.597s][info][gc] GC(3) Concurrent Preclean
[1.668s][info][gc] GC(7) Pause Young (Allocation Failure) 280M->250M(319M) 59.425ms
[1.766s][info][gc] GC(8) Pause Young (Allocation Failure) 318M->288M(357M) 53.760ms
[1.863s][info][gc] GC(9) Pause Young (Allocation Failure) 356M->328M(397M) 53.511ms
[1.955s][info][gc] GC(10) Pause Young (Allocation Failure) 396M->364M(433M) 47.517ms
[2.048s][info][gc] GC(11) Pause Young (Allocation Failure) 432M->400M(469M) 46.963ms
[2.138s][info][gc] GC(12) Pause Young (Allocation Failure) 468M->436M(505M) 46.259ms
[2.230s][info][gc] GC(13) Pause Young (Allocation Failure) 504M->472M(542M) 47.813ms
[2.321s][info][gc] GC(14) Pause Young (Allocation Failure) 541M->509M(578M) 48.096ms
[2.358s][info][gc] GC(3) Concurrent Preclean 761.116ms
[2.358s][info][gc] GC(3) Concurrent Abortable Preclean
[2.413s][info][gc] GC(15) Pause Young (Allocation Failure) 577M->546M(615M) 48.871ms
[2.446s][info][gc] GC(3) Concurrent Abortable Preclean 88.597ms
[2.460s][info][gc] GC(3) Pause Remark 598M->598M(615M) 13.292ms
[2.460s][info][gc] GC(3) Concurrent Sweep
[2.525s][info][gc] GC(16) Pause Young (Allocation Failure) 614M->584M(653M) 53.207ms
[2.614s][info][gc] GC(17) Pause Young (Allocation Failure) 652M->620M(688M) 44.706ms
[2.629s][info][gc] GC(3) Concurrent Sweep 169.321ms
[2.631s][info][gc] GC(3) Concurrent Reset
[2.656s][info][gc] GC(3) Concurrent Reset 25.248ms
[2.704s][info][gc] GC(18) Pause Young (Allocation Failure) 688M->656M(1096M) 45.174ms
[2.707s][info][gc] GC(19) Pause Initial Mark 657M->657M(1096M) 2.571ms
[2.708s][info][gc] GC(19) Concurrent Mark
[2.810s][info][gc] GC(20) Pause Young (Allocation Failure) 724M->692M(1096M) 49.239ms
[2.901s][info][gc] GC(21) Pause Young (Allocation Failure) 760M->728M(1096M) 46.692ms
[3.003s][info][gc] GC(22) Pause Young (Allocation Failure) 797M->765M(1096M) 49.160ms
[3.095s][info][gc] GC(23) Pause Young (Allocation Failure) 833M->802M(1096M) 46.781ms
[3.188s][info][gc] GC(24) Pause Young (Allocation Failure) 871M->840M(1096M) 47.570ms
[3.276s][info][gc] GC(25) Pause Young (Allocation Failure) 909M->876M(1096M) 44.140ms
[3.367s][info][gc] GC(26) Pause Young (Allocation Failure) 945M->913M(1096M) 46.936ms
[3.460s][info][gc] GC(27) Pause Young (Allocation Failure) 981M->950M(1096M) 46.379ms
[3.550s][info][gc] GC(28) Pause Young (Allocation Failure) 1018M->985M(1096M) 43.949ms
[3.649s][info][gc] GC(29) Pause Young (Allocation Failure) 1054M->1022M(1096M) 51.508ms
[3.748s][info][gc] GC(30) Pause Young (Allocation Failure) 1090M->1059M(1128M) 53.020ms
[3.848s][info][gc] GC(31) Pause Young (Allocation Failure) 1128M->1098M(1166M) 55.177ms
[3.940s][info][gc] GC(32) Pause Young (Allocation Failure) 1166M->1134M(1202M) 48.192ms
[4.038s][info][gc] GC(33) Pause Young (Allocation Failure) 1202M->1170M(1239M) 49.260ms
[4.131s][info][gc] GC(34) Pause Young (Allocation Failure) 1238M->1206M(1275M) 48.877ms
[4.221s][info][gc] GC(35) Pause Young (Allocation Failure) 1274M->1242M(1311M) 45.849ms
[4.317s][info][gc] GC(36) Pause Young (Allocation Failure) 1311M->1279M(1348M) 49.589ms
[4.411s][info][gc] GC(37) Pause Young (Allocation Failure) 1347M->1316M(1385M) 49.590ms
[4.504s][info][gc] GC(38) Pause Young (Allocation Failure) 1384M->1354M(1423M) 50.399ms
[4.599s][info][gc] GC(39) Pause Young (Allocation Failure) 1422M->1390M(1459M) 48.630ms
[4.636s][info][gc] GC(19) Concurrent Mark 1928.522ms
[4.636s][info][gc] GC(19) Concurrent Preclean
[4.698s][info][gc] GC(40) Pause Young (Allocation Failure) 1458M->1426M(1495M) 54.619ms
[4.793s][info][gc] GC(41) Pause Young (Allocation Failure) 1495M->1463M(1532M) 51.580ms
[4.898s][info][gc] GC(42) Pause Young (Allocation Failure) 1531M->1499M(1568M) 56.364ms
[4.994s][info][gc] GC(43) Pause Young (Allocation Failure) 1567M->1536M(1605M) 51.808ms
[5.089s][info][gc] GC(44) Pause Young (Allocation Failure) 1604M->1572M(1641M) 51.951ms
[5.205s][info][gc] GC(45) Pause Young (Allocation Failure) 1641M->1609M(1678M) 69.671ms
[5.320s][info][gc] GC(46) Pause Young (Allocation Failure) 1678M->1645M(1714M) 55.401ms
[5.446s][info][gc] GC(47) Pause Young (Allocation Failure) 1713M->1682M(1751M) 73.980ms
[5.567s][info][gc] GC(48) Pause Young (Allocation Failure) 1750M->1718M(1787M) 64.258ms
[5.702s][info][gc] GC(49) Pause Young (Allocation Failure) 1786M->1754M(1823M) 82.279ms
[5.800s][info][gc] GC(50) Pause Young (Allocation Failure) 1823M->1791M(1860M) 51.367ms
[5.933s][info][gc] GC(51) Pause Young (Allocation Failure) 1859M->1829M(1897M) 80.082ms
[6.057s][info][gc] GC(52) Pause Young (Allocation Failure) 1897M->1866M(1935M) 60.380ms
[6.171s][info][gc] GC(53) Pause Young (Allocation Failure) 1935M->1902M(1971M) 59.408ms
[6.264s][info][gc] GC(54) Pause Young (Allocation Failure) 1971M->1939M(2008M) 49.081ms
[6.373s][info][gc] GC(55) Pause Young (Allocation Failure) 2007M->1975M(2044M) 59.007ms
[6.474s][info][gc] GC(56) Pause Young (Allocation Failure) 2043M->2011M(2080M) 51.319ms
[6.572s][info][gc] GC(57) Pause Young (Allocation Failure) 2080M->2048M(2117M) 51.965ms
[6.677s][info][gc] GC(58) Pause Young (Allocation Failure) 2116M->2086M(2155M) 58.587ms
[6.784s][info][gc] GC(59) Pause Young (Allocation Failure) 2154M->2124M(2193M) 63.154ms
[6.881s][info][gc] GC(60) Pause Young (Allocation Failure) 2192M->2160M(2229M) 51.143ms
[6.984s][info][gc] GC(61) Pause Young (Allocation Failure) 2228M->2196M(2265M) 52.588ms
[7.081s][info][gc] GC(62) Pause Young (Allocation Failure) 2264M->2232M(2301M) 50.704ms
[7.180s][info][gc] GC(63) Pause Young (Allocation Failure) 2300M->2269M(2338M) 54.289ms
[7.276s][info][gc] GC(64) Pause Young (Allocation Failure) 2337M->2305M(2374M) 50.127ms
[7.375s][info][gc] GC(65) Pause Young (Allocation Failure) 2374M->2343M(2412M) 55.306ms
[7.499s][info][gc] GC(66) Pause Young (Allocation Failure) 2411M->2381M(2450M) 68.398ms
[7.590s][info][gc] GC(67) Pause Young (Allocation Failure) 2449M->2417M(2486M) 48.127ms
[7.686s][info][gc] GC(68) Pause Young (Allocation Failure) 2485M->2453M(2522M) 52.458ms
[7.781s][info][gc] GC(69) Pause Young (Allocation Failure) 2521M->2490M(2558M) 50.461ms
[7.874s][info][gc] GC(70) Pause Young (Allocation Failure) 2558M->2526M(2595M) 49.063ms
[7.970s][info][gc] GC(71) Pause Young (Allocation Failure) 2594M->2563M(2632M) 53.361ms
[8.067s][info][gc] GC(72) Pause Young (Allocation Failure) 2631M->2601M(2670M) 52.193ms
[8.160s][info][gc] GC(73) Pause Young (Allocation Failure) 2669M->2636M(2705M) 49.274ms
[8.253s][info][gc] GC(74) Pause Young (Allocation Failure) 2704M->2672M(2741M) 49.349ms
[8.348s][info][gc] GC(75) Pause Young (Allocation Failure) 2740M->2708M(2777M) 50.670ms
[8.441s][info][gc] GC(76) Pause Young (Allocation Failure) 2777M->2745M(2814M) 50.816ms
[8.535s][info][gc] GC(77) Pause Young (Allocation Failure) 2813M->2782M(2850M) 51.293ms
[8.634s][info][gc] GC(78) Pause Young (Allocation Failure) 2850M->2819M(2888M) 54.235ms
[8.730s][info][gc] GC(79) Pause Young (Allocation Failure) 2887M->2857M(2926M) 52.972ms
[8.823s][info][gc] GC(80) Pause Young (Allocation Failure) 2925M->2893M(2962M) 50.784ms
[8.920s][info][gc] GC(81) Pause Young (Allocation Failure) 2961M->2929M(2998M) 50.714ms
[9.017s][info][gc] GC(82) Pause Young (Allocation Failure) 2998M->2966M(3035M) 52.698ms
[9.111s][info][gc] GC(83) Pause Young (Allocation Failure) 3034M->3002M(3071M) 50.480ms
[9.208s][info][gc] GC(84) Pause Young (Allocation Failure) 3070M->3039M(3108M) 51.095ms
[9.304s][info][gc] GC(85) Pause Young (Allocation Failure) 3107M->3075M(3144M) 52.366ms
[9.401s][info][gc] GC(86) Pause Young (Allocation Failure) 3144M->3113M(3182M) 52.232ms
[9.500s][info][gc] GC(87) Pause Young (Allocation Failure) 3181M->3149M(3218M) 51.905ms
[9.597s][info][gc] GC(88) Pause Young (Allocation Failure) 3217M->3185M(3254M) 50.404ms
[9.695s][info][gc] GC(89) Pause Young (Allocation Failure) 3254M->3222M(3290M) 54.471ms
[9.794s][info][gc] GC(90) Pause Young (Allocation Failure) 3290M->3258M(3327M) 52.694ms
[9.893s][info][gc] GC(91) Pause Young (Allocation Failure) 3326M->3295M(3363M) 53.641ms
[9.991s][info][gc] GC(92) Pause Young (Allocation Failure) 3363M->3333M(3401M) 54.950ms
[10.088s][info][gc] GC(93) Pause Young (Allocation Failure) 3401M->3368M(3437M) 49.520ms
[10.184s][info][gc] GC(94) Pause Young (Allocation Failure) 3437M->3405M(3474M) 52.197ms
[10.235s][info][gc] GC(19) Concurrent Preclean 5598.481ms
[18.441s][info][gc] GC(96) Pause Full (Allocation Failure) 3473M->3362M(3474M) 8214.260ms
[18.442s][info][gc] GC(95) Pause Young (Allocation Failure) 3473M->3362M(4029M) 8215.070ms
00:24:00.303 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 18109
00:24:00.306 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 14713
00:24:00.306 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 96
```

#### G1 [-XX:+UseG1GC]
```text
[0.030s][info][gc] Using G1
[0.784s][info][gc] GC(0) Pause Young (Normal) (G1 Evacuation Pause) 24M->2M(256M) 3.870ms
[1.202s][info][gc] GC(1) Pause Young (Normal) (G1 Evacuation Pause) 175M->87M(256M) 75.360ms
[1.254s][info][gc] GC(2) Pause Young (Normal) (G1 Evacuation Pause) 113M->101M(256M) 27.320ms
[1.299s][info][gc] GC(3) Pause Young (Normal) (G1 Evacuation Pause) 139M->122M(256M) 16.620ms
[1.307s][info][gc] GC(4) Pause Young (Concurrent Start) (G1 Humongous Allocation) 124M->126M(256M) 6.762ms
[1.307s][info][gc] GC(5) Concurrent Cycle
[1.384s][info][gc] GC(5) Pause Remark 144M->143M(256M) 60.872ms
[1.424s][info][gc] GC(6) Pause Young (Normal) (G1 Evacuation Pause) 170M->145M(512M) 18.821ms
[1.524s][info][gc] GC(7) Pause Young (Normal) (G1 Evacuation Pause) 206M->177M(512M) 21.930ms
[1.530s][info][gc] GC(5) Pause Cleanup 184M->184M(512M) 0.100ms
[1.532s][info][gc] GC(5) Concurrent Cycle 224.699ms
[1.589s][info][gc] GC(8) Pause Young (Normal) (G1 Evacuation Pause) 242M->210M(512M) 20.623ms
[1.677s][info][gc] GC(9) Pause Young (Normal) (G1 Evacuation Pause) 300M->257M(512M) 26.327ms
[1.695s][info][gc] GC(10) Pause Young (Concurrent Start) (G1 Humongous Allocation) 262M->262M(1024M) 14.955ms
[1.695s][info][gc] GC(11) Concurrent Cycle
[1.846s][info][gc] GC(12) Pause Young (Normal) (G1 Evacuation Pause) 372M->315M(1024M) 30.592ms
[1.940s][info][gc] GC(11) Pause Remark 438M->438M(1024M) 1.159ms
[2.116s][info][gc] GC(13) Pause Young (Normal) (G1 Evacuation Pause) 536M->423M(1024M) 67.611ms
[2.204s][info][gc] GC(11) Pause Cleanup 552M->552M(1024M) 0.217ms
[2.208s][info][gc] GC(11) Concurrent Cycle 513.614ms
[2.322s][info][gc] GC(14) Pause Young (Normal) (G1 Evacuation Pause) 642M->533M(1024M) 63.839ms
[2.358s][info][gc] GC(15) Pause Young (Concurrent Start) (G1 Humongous Allocation) 539M->538M(2253M) 32.011ms
[2.358s][info][gc] GC(16) Concurrent Cycle
[2.728s][info][gc] GC(17) Pause Young (Normal) (G1 Evacuation Pause) 811M->669M(2253M) 75.792ms
[2.870s][info][gc] GC(16) Pause Remark 875M->875M(2253M) 1.174ms
[3.295s][info][gc] GC(16) Pause Cleanup 1301M->1301M(2253M) 0.386ms
[3.304s][info][gc] GC(16) Concurrent Cycle 946.409ms
[3.591s][info][gc] GC(18) Pause Young (Normal) (G1 Evacuation Pause) 1399M->1025M(2253M) 195.781ms
[3.803s][info][gc] GC(19) Pause Young (Normal) (G1 Evacuation Pause) 1208M->1117M(2253M) 100.331ms
[3.840s][info][gc] GC(20) Pause Young (Concurrent Start) (G1 Humongous Allocation) 1120M->1124M(2991M) 33.511ms
[3.840s][info][gc] GC(21) Concurrent Cycle
[4.319s][info][gc] GC(22) Pause Young (Normal) (G1 Evacuation Pause) 1468M->1288M(2991M) 90.336ms
[4.677s][info][gc] GC(23) Pause Young (Normal) (G1 Evacuation Pause) 1631M->1456M(2991M) 117.676ms
[5.043s][info][gc] GC(24) Pause Young (Normal) (G1 Evacuation Pause) 1815M->1632M(2991M) 115.620ms
[5.109s][info][gc] GC(21) Pause Remark 1734M->1734M(2991M) 1.482ms
[5.394s][info][gc] GC(25) Pause Young (Normal) (G1 Evacuation Pause) 2008M->1818M(3384M) 111.113ms
[5.925s][info][gc] GC(26) Pause Young (Normal) (G1 Evacuation Pause) 2217M->2016M(3384M) 122.920ms
[6.319s][info][gc] GC(27) Pause Young (Normal) (G1 Evacuation Pause) 2442M->2225M(3384M) 119.402ms
[6.466s][info][gc] GC(21) Pause Cleanup 2458M->2458M(3384M) 0.580ms
[6.480s][info][gc] GC(21) Concurrent Cycle 2639.628ms
[6.578s][info][gc] GC(28) Pause Young (Concurrent Start) (G1 Humongous Allocation) 2483M->2352M(3384M) 96.610ms
[6.578s][info][gc] GC(29) Concurrent Cycle
[6.950s][info][gc] GC(30) Pause Young (Normal) (G1 Evacuation Pause) 2700M->2524M(3634M) 130.381ms
[7.457s][info][gc] GC(31) Pause Young (Normal) (G1 Evacuation Pause) 2904M->2711M(3634M) 116.949ms
[7.749s][info][gc] GC(32) Pause Young (Normal) (G1 Evacuation Pause) 3005M->2856M(3634M) 99.568ms
[7.968s][info][gc] GC(33) Pause Young (Normal) (G1 Evacuation Pause) 3075M->2963M(3634M) 72.877ms
[8.150s][info][gc] GC(34) Pause Young (Normal) (G1 Evacuation Pause) 3140M->3050M(3786M) 57.897ms
[8.401s][info][gc] GC(35) Pause Young (Normal) (G1 Evacuation Pause) 3243M->3146M(3786M) 55.939ms
[8.585s][info][gc] GC(36) Pause Young (Normal) (G1 Evacuation Pause) 3338M->3241M(3786M) 55.574ms
[8.772s][info][gc] GC(37) Pause Young (Normal) (G1 Evacuation Pause) 3433M->3336M(3786M) 57.203ms
[8.956s][info][gc] GC(38) Pause Young (Normal) (G1 Evacuation Pause) 3528M->3431M(3848M) 58.855ms
00:24:43.490 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - Execution time in milliseconds: 8194
00:24:43.493 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total execution time in milliseconds: 2307
00:24:43.493 [main] INFO  org.mlaptev.otus.GarbageCollectorBenchmark - GC. Total amount of executions: 33
[9.267s][info][gc] GC(29) Pause Remark 3617M->3615M(3848M) 1.507ms
[11.352s][info][gc] GC(29) Pause Cleanup 3615M->3615M(3848M) 1.063ms
[11.362s][info][gc] GC(29) Concurrent Cycle 4783.682ms
```

#### ZGC [-XX:+UnlockExperimentalVMOptions -XX:+UseZGC]
```text
Error occurred during initialization of VM
Option -XX:+UseZGC not supported
```