import java.util.ArrayList;
import java.util.List;

public class UserBusiness {
    public UserService userService;

    public UserBusiness(UserService userService) {
        this.userService = userService;
    }

    public List<String> getValues(String user) {

        List<String> list = new ArrayList<String>();
        List<String> values = userService.getValues(user);

        for (String todo : values) {
            if (todo.contains("Hibernate")) {
                list.add(todo);
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
