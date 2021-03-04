package dk.jlo;

class AppendJavaPerfTest {

    static String string1 = "asd";
    static String string2 = "sdf";

    public static void main(String[] args) {
        String s;
        long iterations = 100_000L;
        long before;
        long after;

        before = System.currentTimeMillis();
        s = stringBuffer2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuffer2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        before = System.currentTimeMillis();
        s = stringBuilder2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuilder2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        before = System.currentTimeMillis();
        s = string2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("string2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        iterations = 1000_000L;

        before = System.currentTimeMillis();
        s = stringBuffer2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuffer2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        before = System.currentTimeMillis();
        s = stringBuilder2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuilder2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        iterations = 10_000_000L;

        before = System.currentTimeMillis();
        s = stringBuffer2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuffer2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        before = System.currentTimeMillis();
        s = stringBuilder2Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuilder2Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
        System.gc();

        before = System.currentTimeMillis();
        s = stringBuilder3Example(iterations);
        after = System.currentTimeMillis();
        System.out.println("stringBuilder3Example - " + iterations + " - " + (after - before) + "ms elapsed.");

        assert s.length() > 1; // Værdien skal bruges, så en evt. compiler ikke optimerer den væk
    }

    static String stringBuffer2Example(long iterations) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(string1).append(i).append(string2);
        }
        return stringBuffer.toString();
    }

    static String stringBuilder2Example(long iterations) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(string1 + i + string2);
        }
        return stringBuilder.toString();
    }

    static String stringBuilder3Example(long iterations) {
        StringBuilder stringBuilder = new StringBuilder(10_000_000);
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(string1 + i + string2);
        }
        return stringBuilder.toString();
    }

    static String string2Example(long iterations) {
        String string = "";
        for (int i = 0; i < iterations; i++) {
            string += string1 + i + string2;
        }
        return string;
    }
}
