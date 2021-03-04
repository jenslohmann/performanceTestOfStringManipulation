package dk.jlo

class AppendPerfTest {

    static String string1 = 'asd'
    static String string2 = 'sdf'

    static void main(String[] args) {
        String s = ''
        long iterations = 100_000L

        time "stringBufferExample - ${iterations}", { s = stringBufferExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuffer2Example - ${iterations}", { s = stringBuffer2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilderExample - ${iterations}", { s = stringBuilderExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilder2Example - ${iterations}", { s = stringBuilder2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringExample - ${iterations}", { s = stringExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "string2Example - ${iterations}", { s = string2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        iterations = 1000_000L

        time "stringBufferExample - ${iterations}", { s = stringBufferExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuffer2Example - ${iterations}", { s = stringBuffer2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilderExample - ${iterations}", { s = stringBuilderExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilder2Example - ${iterations}", { s = stringBuilder2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        iterations = 10_000_000L

        time "stringBufferExample - ${iterations}", { s = stringBufferExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuffer2Example - ${iterations}", { s = stringBuffer2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilderExample - ${iterations}", { s = stringBuilderExample(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilder2Example - ${iterations}", { s = stringBuilder2Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc()

        time "stringBuilder3Example - ${iterations}", { s = stringBuilder3Example(iterations) }

        assert s.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
    }

    static String stringBufferExample(long iterations) {
        StringBuffer stringBuffer = new StringBuffer()
        for (i in 0..<iterations) {
            stringBuffer.append("${i}${string1}${string2}")
        }
        return stringBuffer.toString()
    }

    static String stringBuffer2Example(long iterations) {
        StringBuffer stringBuffer = new StringBuffer()
        for (i in 0..<iterations) {
            stringBuffer.append(string1 + i + string2)
        }
        return stringBuffer.toString()
    }

    static String stringBuilderExample(long iterations) {
        StringBuilder stringBuilder = new StringBuilder()
        for (i in 0..<iterations) {
            stringBuilder.append("${i}${string1}${string2}")
        }
        return stringBuilder.toString()
    }

    static String stringBuilder2Example(long iterations) {
        StringBuilder stringBuilder = new StringBuilder()
        for (i in 0..<iterations) {
            stringBuilder.append(string1 + i + string2)
        }
        return stringBuilder.toString()
    }

    static String stringBuilder3Example(long iterations) {
        StringBuilder stringBuilder = new StringBuilder(10_000_000)
        for (i in 0..<iterations) {
            stringBuilder.append(string1 + i + string2)
        }
        return stringBuilder.toString()
    }

    static String stringExample(long iterations) {
        String string = ''
        for (i in 0..<iterations) {
            string += ("${i}${string1}${string2}")
        }
        return string
    }

    static String string2Example(long iterations) {
        String string = ''
        for (i in 0..<iterations) {
            string += string1 + i + string2
        }
        return string
    }

    static void time(String name, Closure closure) {
        long before = System.currentTimeMillis()
        closure()
        long after = System.currentTimeMillis()
        println("${name} - ${after - before}ms elapsed.")
    }
}
