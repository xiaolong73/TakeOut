package cn.hyit.dao;

import cn.hyit.domain.User;
import cn.hyit.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表中的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());


    /**
     * 登录方法
     * @param loginUser只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser){

        try{
            //1.编写sql
            String sql = "select * from USER where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        }catch(DataAccessException e){
            return null;
        }
    }

    public boolean register(User registUser){
        try{
            String sql = "insert into USER (username, password) value(?, ?)";
            int count= template.update(sql, new Object[]{registUser.getUsername(), registUser.getPassword()});
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
