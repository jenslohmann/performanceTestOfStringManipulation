One-off timings, your mileage may vary, "-server -Xmx2g -Xms2g":

method | iterations | groovy | CompileStatic | java 8
--- | ---:| ---:| ---:| ---:
stringBufferExample | 100000 | 475ms | 495ms | n/a
stringBuffer2Example | 100000 | 63ms | 66ms | 20ms
stringBuilderExample | 100000 | 329ms| 490ms | n/a
stringBuilder2Example | 100000 | 30ms | 39ms | 21ms
stringExample | 100000 | 33168ms | 33473ms | n/a
string2Example | 100000 | 33032ms | 33366ms | 33386ms
stringBufferExample | 1000000 | 2821ms | 2869ms | n/a
stringBuffer2Example | 1000000 | 244ms | 223ms | 57ms
stringBuilderExample | 1000000 | 2817ms | 3326ms | n/a
stringBuilder2Example | 1000000 | 243ms | 229ms | 44ms
stringBufferExample | 10000000 | 30114ms | 31483ms | n/a
stringBuffer2Example | 10000000 | 2503ms | 2307ms | 501ms
stringBuilderExample | 10000000 | 30679ms | 35917ms | n/a
stringBuilder2Example | 10000000 | 2504ms | 2278ms | 497ms
stringBuilder3Example | 10000000 | 2487ms | 2326ms | 554ms

Dynamic String performance test:
```
stringBuffer w/dynamic String Example - 10 - 338ms elapsed.
stringBuffer plain apppendage Example - 10 - 1ms elapsed.
Resulting string is 55000 chars (and 55000 chars).
stringBuffer w/dynamic String Example - 20 - 988ms elapsed.
stringBuffer plain apppendage Example - 20 - 0ms elapsed.
Resulting string is 210000 chars (and 210000 chars).
stringBuffer w/dynamic String Example - 30 - 2935ms elapsed.
stringBuffer plain apppendage Example - 30 - 1ms elapsed.
Resulting string is 465000 chars (and 465000 chars).
stringBuffer w/dynamic String Example - 40 - 6903ms elapsed.
stringBuffer plain apppendage Example - 40 - 1ms elapsed.
Resulting string is 820000 chars (and 820000 chars).
stringBuffer w/dynamic String Example - 50 - 13561ms elapsed.
stringBuffer plain apppendage Example - 50 - 2ms elapsed.
Resulting string is 1275000 chars (and 1275000 chars).
```
