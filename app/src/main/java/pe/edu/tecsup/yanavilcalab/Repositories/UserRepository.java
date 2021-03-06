package pe.edu.tecsup.yanavilcalab.Repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.edu.tecsup.yanavilcalab.Modelos.User;

public class UserRepository {

    public static void create(String username, String fullname, String email, String password) {

        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);

        SugarRecord.save(user);
    }

    public static User login(String email, String password){

        List<User> users = SugarRecord.find(User.class,
                "email=? and password=?", email, password);

        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
}

