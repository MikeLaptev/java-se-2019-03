### Results

#### Output of the proxied class

```bash
Calculator
22:49:57.266 [main] INFO  org.mlaptev.otus.Application - Calculator
22:49:57.269 [main] INFO  org.mlaptev.otus.Application - ===== 1 =====
22:49:57.272 [main] INFO  org.mlaptev.otus.Application - 3
22:49:57.285 [main] INFO  org.mlaptev.otus.proxy.LogProxy - Executed method: subtract, parameters: {arg0: 1}, {arg1: 2}
22:49:57.285 [main] INFO  org.mlaptev.otus.Application - -1
22:49:57.285 [main] INFO  org.mlaptev.otus.Application - 2
22:49:57.285 [main] INFO  org.mlaptev.otus.Application - ===== 2 =====
22:49:57.286 [main] INFO  org.mlaptev.otus.Application - -5
22:49:57.286 [main] INFO  org.mlaptev.otus.proxy.LogProxy - Executed method: subtract, parameters: {arg0: 2}, {arg1: 3}
22:49:57.286 [main] INFO  org.mlaptev.otus.Application - 1
22:49:57.286 [main] INFO  org.mlaptev.otus.Application - -6
22:49:57.286 [main] INFO  org.mlaptev.otus.Application - Figure
22:49:57.286 [main] INFO  org.mlaptev.otus.Application - ===== 1 =====
22:49:57.288 [main] INFO  org.mlaptev.otus.proxy.LogProxy - Executed method: getArea, parameters: none
22:49:57.288 [main] INFO  org.mlaptev.otus.Application - 1.0
22:49:57.288 [main] INFO  org.mlaptev.otus.Application - ===== 2 =====
22:49:57.288 [main] INFO  org.mlaptev.otus.proxy.LogProxy - Executed method: getArea, parameters: none
22:49:57.289 [main] INFO  org.mlaptev.otus.Application - 3.141592653589793
```
