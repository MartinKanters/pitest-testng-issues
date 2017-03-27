# Test issues for pitest + TestNG

We have seen issues with certain combinations of versions of pitest and TestNG which end up in survived mutants while they are false positives.

### Versions

|             |        | TestNG   |      |      |
|-------------|--------|----------|------|------|
|             |        | 6.9.13.6 | 6.10 | 6.11 |
| **pi test** | 1.1.4  | OK       | OK   | OK   |
|             | 1.1.5  | NOK      | NOK  | NOK  |
|             | 1.1.11 | NOK      | NOK  | NOK  |

### Run script
`mvn clean test org.pitest:pitest-maven:mutationCoverage`

### Hypothesis

Out of the 4 tests, 3 fail. The first one always works out fine.
Then the following shows up in the logs 3 times and after that the test fails.

```
stdout  : [TestNG] [WARN] Ignoring duplicate listener : org.pitest.testng.TestNGAdapter
stderr  : org.testng.SkipException: skipping
        at org.pitest.testng.TestNGAdapter.onTestStart(TestNGAdapter.java:74)
        at org.testng.internal.Invoker.runTestListeners(Invoker.java:1739)
        at org.testng.internal.Invoker.runTestListeners(Invoker.java:1714)
        at org.testngstderr  : .internal.Invoker.invokeMethod(Invoker.java:640)
        at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:869)
        at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1193)
...
```

There is an error reported in TestNG versions 6.10 and 6.11 linked to that duplicate listener error: https://github.com/cbeust/testng/issues/1400.
