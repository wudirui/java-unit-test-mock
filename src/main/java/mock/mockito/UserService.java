package mock.mockito;

import java.util.List;

/**
 * 注解的形式实现mock
 */
public interface UserService {
    public List<String> getValues(String value);

    public void deleteValues(String delValue);
}
