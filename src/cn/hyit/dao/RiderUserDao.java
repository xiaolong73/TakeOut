package cn.hyit.dao;

import cn.hyit.domain.RiderUser;
import cn.hyit.domain.User;
import cn.hyit.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中rider表中的类
 */
public class RiderUserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());


    /**
     * 登录方法
     * @param loginUser只有用户名和密码
     * @return user包含用户全部数据
     */

    public RiderUser login(RiderUser loginUser){

        try{
            //1.编写sql
            String sql = "select * from rider where rider_name = ? and rider_passWord = ?";
            //2.调用query方法
            RiderUser user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<RiderUser>(RiderUser.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        }catch(DataAccessException e){
            return null;
        }
    }

    public boolean register(RiderUser registUser){
        try{
            String sql = "insert into rider (rider_name, rider_passWord, rider_tel) value(?, ?, ?)";
            int count= template.update(sql, new Object[]{registUser.getUsername(), registUser.getPassword(),registUser.getTele()});
            if(count >= 1) {
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public boolean changepassword(String username, String password){

        try{
            String sql = "update rider set rider_passWord = ? where rider_name = ?";
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
