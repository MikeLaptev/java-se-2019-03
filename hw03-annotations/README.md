### Results

#### 1
Class contains only one setup method, one cleanup method and **one** test method.

```bash
18:52:09.681 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.SingleTest]
18:52:09.695 [main] INFO  org.mlaptev.otus.tests.SingleTest - Constructor
18:52:09.695 [main] INFO  org.mlaptev.otus.tests.SingleTest - Calling setup [1/1].
18:52:09.696 [main] INFO  org.mlaptev.otus.tests.SingleTest - Execution of the test [1/1]...
18:52:09.696 [main] INFO  org.mlaptev.otus.tests.SingleTest - Calling cleanup [1/1].
```

#### 2
Class contains only one setup method, one cleanup method and **two** test methods.

```bash
18:52:09.696 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTests]
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Constructor
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Calling setup [1/1].
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Execution of the test [1/2]...
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Calling cleanup [1/1].
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Constructor
18:52:09.697 [main] INFO  org.mlaptev.otus.tests.TwoTests - Calling setup [1/1].
18:52:09.698 [main] INFO  org.mlaptev.otus.tests.TwoTests - Execution of the test [2/2]...
18:52:09.698 [main] INFO  org.mlaptev.otus.tests.TwoTests - Calling cleanup [1/1].
```

#### 3
Class contains only three setup methods, three cleanup methods and **two** test methods.

Both cleanup and setup methods has the same order.

```bash
18:52:09.698 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder]
18:52:09.699 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Constructor
18:52:09.699 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [1/3] - non-ordered.
18:52:09.699 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [2/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [3/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Execution of the test [1/2]...
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [1/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [2/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [3/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Constructor
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [1/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [2/3] - non-ordered.
18:52:09.700 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling setup [3/3] - non-ordered.
18:52:09.701 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Execution of the test [2/2]...
18:52:09.701 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [1/3] - non-ordered.
18:52:09.701 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [2/3] - non-ordered.
18:52:09.701 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterSameOrder - Calling cleanup [3/3] - non-ordered.
```

#### 4
Class contains only three setup methods, three cleanup methods and **two** test methods.

Both cleanup and setup methods has different orders.

```bash
18:52:09.701 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder]
18:52:09.702 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Constructor
18:52:09.702 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [1/3] - ordered.
18:52:09.702 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [2/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [3/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Execution of the test [1/2]...
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [1/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [2/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [3/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Constructor
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [1/3] - ordered.
18:52:09.703 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [2/3] - ordered.
18:52:09.704 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling setup [3/3] - ordered.
18:52:09.704 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Execution of the test [2/2]...
18:52:09.704 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [1/3] - ordered.
18:52:09.705 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [2/3] - ordered.
18:52:09.705 [main] INFO  org.mlaptev.otus.tests.TwoTestsThreeBeforeAndAfterDiffOrder - Calling cleanup [3/3] - ordered.
```

#### 5 
Class contains only one setup method, one cleanup method and **one** test method, that thrown an exception.

**Expected behaviour** - all cleanup methods should be executed.

```bash
18:52:09.705 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.SingleTestWithException]
18:52:09.706 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - Constructor
18:52:09.706 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - Calling setup [1/1].
18:52:09.706 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - Execution of the test [1/1] - be ready for exception...
18:52:09.706 [main] ERROR org.mlaptev.otus.framework.Framework - Exception occurs during test execution...
java.lang.reflect.InvocationTargetException: null
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:566) ~[?:?]
	at org.mlaptev.otus.framework.Framework.executeSingleTest(Framework.java:56) [classes/:?]
	at org.mlaptev.otus.framework.Framework.run(Framework.java:37) [classes/:?]
	at org.mlaptev.otus.Application.main(Application.java:21) [classes/:?]
Caused by: java.lang.RuntimeException: Exception in the test...
	at org.mlaptev.otus.tests.SingleTestWithException.test(SingleTestWithException.java:25) ~[classes/:?]
	... 7 more
18:52:09.723 [main] INFO  org.mlaptev.otus.tests.SingleTestWithException - Calling cleanup [1/1].
```

#### 6
Class contains only three setup methods, three cleanup methods and **one** test method.

Both cleanup and setup methods has different orders.

One of the cleanup methods throws an exception.

**Expected behaviour** - all cleanup methods should be executed, even one of them throws an exception.

```bash
18:52:09.723 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods]
18:52:09.724 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Constructor
18:52:09.724 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling setup [1/3] - ordered.
18:52:09.725 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling setup [2/3] - ordered.
18:52:09.725 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling setup [3/3] - ordered.
18:52:09.725 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Execution of the test [1/1]...
18:52:09.726 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling cleanup [1/3] - ordered.
18:52:09.726 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling cleanup [2/3] - be ready for exception.
18:52:09.726 [main] ERROR org.mlaptev.otus.framework.Framework - Exception occurs during execution of post-test steps...
java.lang.reflect.InvocationTargetException: null
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:566) ~[?:?]
	at org.mlaptev.otus.framework.Framework.executeSingleTest(Framework.java:67) [classes/:?]
	at org.mlaptev.otus.framework.Framework.run(Framework.java:37) [classes/:?]
	at org.mlaptev.otus.Application.main(Application.java:22) [classes/:?]
Caused by: java.lang.RuntimeException: Exception in one of the after methods...
	at org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods.secondCleanUp(ExceptionInOneOfAfterMethods.java:45) ~[classes/:?]
	... 7 more
18:52:09.727 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfAfterMethods - Calling cleanup [3/3] - ordered.
```

#### 7
Class contains only three setup methods, three cleanup methods and **one** test method.

Both cleanup and setup methods has different orders.

One of the cleanup methods throws an exception.

**Expected behaviour** - no before methods after throwing an exception should be executed, no test(s) should be executed, all the cleanup methods should be executed.

```bash
18:52:09.728 [main] INFO  org.mlaptev.otus.framework.Framework - Executing tests from class [org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods]
18:52:09.728 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Constructor
18:52:09.728 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Calling setup [1/3] - ordered.
18:52:09.729 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Calling setup [2/3] - be ready for exception.
18:52:09.729 [main] ERROR org.mlaptev.otus.framework.Framework - Exception occurs during execution of pre-test steps... Exiting...
java.lang.reflect.InvocationTargetException: null
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[?:?]
	at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[?:?]
	at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[?:?]
	at java.lang.reflect.Method.invoke(Method.java:566) ~[?:?]
	at org.mlaptev.otus.framework.Framework.executeSingleTest(Framework.java:51) [classes/:?]
	at org.mlaptev.otus.framework.Framework.run(Framework.java:37) [classes/:?]
	at org.mlaptev.otus.Application.main(Application.java:23) [classes/:?]
Caused by: java.lang.RuntimeException: Exception in one of the before methods...
	at org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods.secondSetUp(ExceptionInOneOfBeforeMethods.java:25) ~[classes/:?]
	... 7 more
18:52:09.729 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Calling cleanup [1/3] - ordered.
18:52:09.729 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Calling cleanup [2/3] - ordered.
18:52:09.729 [main] INFO  org.mlaptev.otus.tests.ExceptionInOneOfBeforeMethods - Calling cleanup [3/3] - ordered.
```