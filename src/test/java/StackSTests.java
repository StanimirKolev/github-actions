import TestDrivenDev.EmptyStackSException;
import TestDrivenDev.StackS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackSTests {

    StackS stackS;


    @Test
    public void onCreateSizeIsZero() {
        stackS = new StackS();
        assertEquals(0, stackS.size());
    }

    @Test
    public void stackSAcceptsInteger() {
        stackS = new StackS<Integer>();
        assertNotEquals(null, stackS);
    }

    @Test
    public void stackSAcceptsStrings() {
        stackS = new StackS<String>();
        assertNotEquals(null, stackS);
    }

    @Test
    public void pushAddsOneMoreElement() {
        stackS = new StackS();
        int sizeBegin = stackS.size();
        stackS.push(5);
        int sizeAfter = stackS.size();
        assertEquals(sizeAfter, sizeBegin + 1);
        stackS.push(4);
        stackS.push(3);
        stackS.push(2);
        assertEquals(4, stackS.size());
    }

    @Test
    public void pushMustAddLastElem() throws EmptyStackSException {
        stackS = new StackS();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);
        stackS.push(4);
        assertEquals(4, stackS.peek());
    }

    @Test
    public void popMustGiveLastElem() throws EmptyStackSException {
        stackS = new StackS();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);
        stackS.push(4);
        assertEquals(4, stackS.pop());
        assertEquals(3, stackS.pop());
        assertEquals(2, stackS.pop());
        assertEquals(1, stackS.pop());
    }

    @Test
    public void popMustDecreaseTheSize() throws EmptyStackSException {
        stackS = new StackS();
        stackS.push(1);
        stackS.push(2);
        stackS.push(3);
        stackS.push(4);
        assertEquals(4, stackS.size());
        stackS.pop();
        assertEquals(3, stackS.size());
        stackS.pop();
        assertEquals(2, stackS.size());
        stackS.pop();
        assertEquals(1, stackS.size());
        stackS.pop();
        assertEquals(0, stackS.size());
    }

    @Test
    public void peekMustThrowIfNoElems() {
        stackS = new StackS();
        assertThrows(EmptyStackSException.class, () -> stackS.peek());
    }

    @Test
    public void popMustThrowIfNoElems() {
        stackS = new StackS();
        assertThrows(EmptyStackSException.class, () -> stackS.pop());
    }

    @Test
    public void emptyShouldReturnCorrectInfo() throws EmptyStackSException {
        stackS = new StackS();
        assertTrue(stackS.empty());
        stackS.push("Stanimir");
        assertFalse(stackS.empty());
        stackS.pop();
        assertTrue(stackS.empty());

    }
}
