package cn.hyit.dao;

import cn.hyit.domain.SellerUser;
import cn.hyit.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中seller表中的类
 */
public class SellerUserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());


    /**
     * 登录方法
     * @param loginUser只有用户名和密码
     * @return user包含用户全部数据
     */

    public SellerUser login(SellerUser loginUser){

        try{
            //1.编写sql
            String sql = "select * from seller where seller_name = ? and seller_passWord = ?";
            //2.调用query方法
            SellerUser selleruser = template.queryForObject(sql,
                    new BeanPropertyRowMapper<SellerUser>(SellerUser.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return selleruser;
        }catch(DataAccessException e){
            return null;
        }
    }

    public boolean register(SellerUser registUser){
        try{
            String sql = "insert into seller (seller_name, seller_passWord,seller_tel) value(?, ?, ?)";
            int count= template.update(sql, new Object[]{registUser.getUsername(), registUser.getPassword(),registUser.getTele()});
            if(count >= 1){
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
            String sql = "update seller set seller_passWord = ? where seller_name = ?";
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
