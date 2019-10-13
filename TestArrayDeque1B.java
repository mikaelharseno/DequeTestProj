import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();
        OperationSequence os = new OperationSequence();
        Integer size = 0;
        Integer outputad, outputsad;
        Integer count = 0;

        while (count < 600) {
            double func = StdRandom.uniform();
            Integer input = StdRandom.uniform(0, 100);

            if (func < 0.25) {
                sad.addFirst(input);
                ad.addFirst(input);
                assertEquals("addFirst did not work", sad.size(), ad.size());
                size = size + 1;
                DequeOperation newop = new DequeOperation("addFirst", input);
                os.addOperation(newop);
            } else if (func < 0.50) {
                sad.addLast(input);
                ad.addLast(input);
                assertEquals("addLast did not work", sad.size(), ad.size());
                size = size + 1;
                DequeOperation newop = new DequeOperation("addLast", input);
                os.addOperation(newop);
            } else if (func < 0.75 && size > 0) {
                assertNotEquals("Size of SAD is zero", 0, sad.isEmpty());
                assertEquals("Incorrect size", sad.size(), ad.size());
                outputsad = sad.removeFirst();
                outputad = ad.removeFirst();
                assertEquals("removeFirst did not work", sad.size(), ad.size());
                DequeOperation newop = new DequeOperation("removeFirst");
                os.addOperation(newop);
                assertEquals(os.toString(), outputad, outputsad);
                size = size - 1;
            } else if (func < 1.00 && size > 0) {
                assertNotEquals("Size of SAD is zero", 0, sad.isEmpty());
                assertEquals("Incorrect size", sad.size(), ad.size());
                outputsad = sad.removeLast();
                outputad = ad.removeLast();
                assertEquals("removeLast did not work", sad.size(), ad.size());
                DequeOperation newop = new DequeOperation("removeLast");
                os.addOperation(newop);
                assertEquals(os.toString(), outputad, outputsad);
                size = size - 1;
            }
            count  = count + 1;
        }
    }
}
