package dk.jlo

class DynamicStringPerfTest {

    static String string1 = 'asd'
    static String string2 = 'sdf'
    static Map<Integer, String> strings

    static void main(String[] args) {

        int maxStrings = 51

        strings = genStrings(maxStrings)

        String s1 = ''
        String s2 = ''

        10.step(maxStrings, 10) {Integer it ->
            long iterations = it.longValue()
            time "stringBuffer w/dynamic String Example - ${iterations}", { s1 = stringBufferExample(iterations) }
            time "stringBuffer plain apppendage Example - ${iterations}", { s2 = stringBuffer2Example(iterations) }
            println "Resulting string is ${s1.length()} chars (and ${s2.length()} chars)."
            assert s1.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
            assert s2.length() > 1 // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
            System.gc()
        }
    }

    static String stringBufferExample(long iterations) {
        StringBuffer stringBuffer = new StringBuffer()
        for (int i in 0..<iterations) {
            stringBuffer.append("${strings.get(Integer.valueOf(i))}")
        }
        return stringBuffer.toString()
    }

    static String stringBuffer2Example(long iterations) {
        StringBuffer stringBuffer = new StringBuffer()
        for (int i in 0..<iterations) {
            stringBuffer.append(strings.get(Integer.valueOf(i)))
        }
        return stringBuffer.toString()
    }

    static void time(String name, Closure closure) {
        long before = System.currentTimeMillis()
        closure()
        long after = System.currentTimeMillis()
        println("${name} - ${after - before}ms elapsed.")
    }

    static Map<Integer, String> genStrings(int numberOfStrings) {
        Map<Integer, String> strings = [:]
        String s = ''
        for (i in 0..<numberOfStrings) {
            s += '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890' +
                    '1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890'
            strings.put(new Integer(i), s)
            // println "String no. ${i} is ${s.length()} chars."
        }
        return strings
    }
}
