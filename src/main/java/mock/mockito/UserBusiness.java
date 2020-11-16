package mock.mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * UserBusiness中依赖UserService
 */
public class UserBusiness {
    public UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public List<String> getValues(String user) {

        List<String> list = new ArrayList<String>();
        List<String> values = userService.getValues(user);

        for (String item : values) {
            if (item.contains("Hibernate")) {
                list.add(item);
            }
        }
        return list;
    }

    public void deleteValues(String user) {

        List<String> list = userService.getValues(user);

        for (String item : list) {
            if (!item.contains("Hibernate")) {
                userService.deleteValues(item);
            }
        }
    }
}
