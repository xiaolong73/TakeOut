package cn.hyit.domain;

/**
 * 骑手实体类
 */
public class RiderUser {

    private String username;
    private String password;
    private String tele;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTele() {
        return tele;
    }

    @Override
    public String toString() {
        return "RiderUserDao{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }

}
