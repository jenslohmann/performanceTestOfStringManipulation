One-off timings, your mileage may vary, "-server -Xmx2g -Xms2g":

method | iterations | groovy | java
--- | ---:| ---:| ---:
stringBufferExample | 100000 | 495ms | n/a
stringBuffer2Example | 100000 | 63ms | 20ms
stringBuilderExample | 100000 | 329ms| n/a
stringBuilder2Example | 100000 | 30ms | 21ms
stringExample | 100000 | 33168ms | n/a
string2Example | 100000 | 33032ms|33386ms
stringBufferExample | 1000000 | 2821ms | n/a
stringBuffer2Example | 1000000 | 244ms | 57ms
stringBuilderExample | 1000000 | 2817ms | n/a
stringBuilder2Example | 1000000 | 243ms | 44ms
stringBufferExample | 10000000 | 30114ms | n/a
stringBuffer2Example | 10000000 | 2503ms | 501ms
stringBuilderExample | 10000000 | 30679ms | n/a
stringBuilder2Example | 10000000 | 2504ms | 497ms
stringBuilder3Example | 10000000 | 2487ms | 554ms