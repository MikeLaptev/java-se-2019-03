**Results**

```text
/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java "-javaagent:/Users/mikhail.laptev/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/183.6156.11/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=61819:/Users/mikhail.laptev/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/183.6156.11/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/mikhail.laptev/Development/java-se-2019-03/hw03-annotations/target/classes:/Users/mikhail.laptev/.m2/repository/org/apache/logging/log4j/log4j-core/2.11.2/log4j-core-2.11.2.jar:/Users/mikhail.laptev/.m2/repository/org/apache/logging/log4j/log4j-api/2.11.2/log4j-api-2.11.2.jar org.mlaptev.otus.Application
23:03:55.098 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.SingleTest]
23:03:55.115 [main] INFO  org.mlaptev.otus.tests.SingleTest - constructor
23:03:55.116 [main] INFO  org.mlaptev.otus.tests.SingleTest - setUp
23:03:55.116 [main] INFO  org.mlaptev.otus.tests.SingleTest - firstTest
23:03:55.116 [main] INFO  org.mlaptev.otus.tests.SingleTest - cleanUp
23:03:55.117 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTests]
23:03:55.118 [main] INFO  org.mlaptev.otus.tests.TwoTests - constructor
23:03:55.118 [main] INFO  org.mlaptev.otus.tests.TwoTests - setUp
23:03:55.118 [main] INFO  org.mlaptev.otus.tests.TwoTests - secondTest
23:03:55.118 [main] INFO  org.mlaptev.otus.tests.TwoTests - cleanUp
23:03:55.119 [main] INFO  org.mlaptev.otus.tests.TwoTests - constructor
23:03:55.119 [main] INFO  org.mlaptev.otus.tests.TwoTests - setUp
23:03:55.119 [main] INFO  org.mlaptev.otus.tests.TwoTests - firstTest
23:03:55.120 [main] INFO  org.mlaptev.otus.tests.TwoTests - cleanUp
23:03:55.120 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder]
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - constructor
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - secondTest
23:03:55.123 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
23:03:55.124 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
23:03:55.124 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
23:03:55.125 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - constructor
23:03:55.125 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - firstSetUp
23:03:55.125 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - secondSetUp
23:03:55.125 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - thirdSetUp
23:03:55.125 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - firstTest
23:03:55.126 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - thirdCleanUp
23:03:55.126 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - secondCleanUp
23:03:55.126 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - firstCleanUp
23:03:55.127 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder]
23:03:55.128 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - constructor
23:03:55.128 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
23:03:55.128 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
23:03:55.128 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
23:03:55.128 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - secondTest
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - constructor
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - firstSetUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - secondSetUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - thirdSetUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - firstTest
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - thirdCleanUp
23:03:55.129 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - secondCleanUp
23:03:55.130 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - firstCleanUp
23:03:55.131 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.SingleTestWithException]
23:03:55.131 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - constructor
23:03:55.131 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - setUp
23:03:55.132 [main] ERROR org.mlaptev.otus.framework.Framework - Exception occurs during test execution.
java.lang.reflect.InvocationTargetException: null
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:566) ~[?:?]
	at run(Framework.java:57) [classes/:?]
	at org.mlaptev.otus.Application.main(Application.java:19) [classes/:?]
Caused by: java.lang.NullPointerException: Example of exception.
	at org.mlaptev.otus.tests.SingleTestWithException.firstTest(SingleTestWithException.java:24) ~[classes/:?]
	... 6 more
23:03:55.152 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - cleanUp

Process finished with exit code 0
```