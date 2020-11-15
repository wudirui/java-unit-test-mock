import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockTest {

    /**
     * 基础方法
     */
    @Test
    public void baseTest() {
        List mockList = mock(ArrayList.class);
        Assert.assertTrue(mockList instanceof ArrayList);
        when(mockList.add("张三")).thenReturn(true);
        when(mockList.size()).thenReturn(10);
        Assert.assertTrue(mockList.add("张三"));
        Assert.assertFalse(mockList.add("李四"));
        Assert.assertEquals(mockList.size(), 10);
        System.out.println(mockList.get(0));
    }

    /**
     * 校验verify
     */
    @Test
    public void verifyTest() {
        List mockList = mock(ArrayList.class);
        mockList.add("once");
        mockList.add("twice");
        mockList.add("three time");
        mockList.add("three time");
        mockList.add("three time");
        verify(mockList).add("once");
        verify(mockList, times(1)).add("once");
        verify(mockList, times(2)).add("twice");
        verify(mockList, times(3)).add("three time");
        verify(mockList, never()).add("never happened");
        verify(mockList, atLeastOnce()).add("three time");
        verify(mockList, atLeast(2)).add("three time");
        verify(mockList, atMost(5)).add("three time");

        verify(mockList, timeout(100)).add("once");
    }

    /**
     * 参数匹配
     */
    @Test
    public void paramTest() {
        List mockedList = mock(ArrayList.class);
        mockedList.add("zhangrui");
        when(mockedList.get(anyInt())).thenReturn("hello world");
        System.out.println(mockedList.get(0));
    }

    /**
     * 异常测试
     */
    @Test(expected = RuntimeException.class)
    public void ExceptionTest() {
        List list = mock(List.class);
        doThrow(new RuntimeException()).when(list).add(1);
        list.add(1);
    }
}
