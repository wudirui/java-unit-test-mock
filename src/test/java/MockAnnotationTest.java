import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationTest {
    @Mock
    UserService userService;

    @InjectMocks
    UserBusiness userBusiness;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Spy
    ArrayList<String> arrayList;

    @Test
    public void deleteUserUseBDD() {
        List<String> list = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(userService.getValues("dummy")).willReturn(list);

        arrayList.add("mockito1");
        arrayList.add("mockito2");
        userBusiness.deleteValues("dummy");

        verify(arrayList).add("mockito1");
        verify(arrayList).add("mockito2");
        verify(userService, times(1)).deleteValues("Use Spring MVC");
        verify(userService, never()).deleteValues("Use Hibernate Java");
        verify(userService, never()).deleteValues("Use Hibernate");

        assertEquals(2, arrayList.size());
        System.out.println("test is working..");
    }

    @Test
    public void deleteUserUseArgumentCaptor() {
        //Given
        List<String> combinedlist = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(userService.getValues("dummy")).willReturn(combinedlist);

        //When
        userBusiness.deleteValues("dummy");

        //Then
        then(userService).should().deleteValues(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
        System.out.println("test is working..");
    }

    @Test
    public void myTest() {
        List<String> list = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
        when(userService.getValues("user")).thenReturn(list);
        List<String> values = userService.getValues("user");
        for (String value : values) {
            System.out.println(value);
        }
    }

}
