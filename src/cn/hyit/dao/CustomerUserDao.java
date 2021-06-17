package cn.hyit.dao;


import cn.hyit.domain.CustomerUser;
import cn.hyit.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表中的类
 */
public class CustomerUserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());


    /**
     * 登录方法
     * @param loginUser只有用户名和密码
     * @return user包含用户全部数据
     */
    public CustomerUser login(CustomerUser loginUser){

        try{
            //1.编写sql
            String sql = "select * from user where user_name = ? and user_passWord = ?";
            //2.调用query方法
            CustomerUser cuser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<CustomerUser>(CustomerUser.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return cuser;
        }catch(DataAccessException e){
            return null;
        }
    }

    public boolean register(CustomerUser registUser){
        try{
            String sql = "insert into user (user_name, user_passWord, user_tel) value(?, ?, ?)";
            int count= template.update(sql, new Object[]{registUser.getUsername(), registUser.getPassword(), registUser.getTele()});
            if(count >= 1) {
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public boolean changepassword(String username, String password){

        try{
            String sql = "update user set user_passWord = ? where user_name = ?";
            int count = template.update(sql,new Object[]{password, username});
            if(count >= 1){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }



}
