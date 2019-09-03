package pl.exercise.tests.account;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String email;
    private String password;
    private Role roles;

    public User(String email, String password, Role roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("email is wrong");
        }
    }


}
