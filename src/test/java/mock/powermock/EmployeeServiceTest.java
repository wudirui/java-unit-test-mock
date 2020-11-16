package mock.powermock;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({EmployeeUtils.class})
public class EmployeeServiceTest extends TestCase {


    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetEmployeeCount() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        PowerMockito.when(EmployeeUtils.getEmployeeCount()).thenReturn(10);
        final EmployeeService employeeService = new EmployeeService();
        int count = employeeService.getEmployeeCount();
        assertEquals(10, count);
    }

    public void testCreateEmployee() {
        PowerMockito.mockStatic(EmployeeUtils.class);
        Employee employee = new Employee();
        PowerMockito.doNothing().when(EmployeeUtils.class);
        final EmployeeService employeeService = new EmployeeService();
        employeeService.createEmployee(employee);
    }
}