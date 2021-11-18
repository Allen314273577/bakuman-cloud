package cn.bakuman.auth.service.impl;


import cn.bakuman.auth.mapper.UserMapper;
import cn.bakuman.auth.po.User;
import cn.bakuman.auth.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 梦叶
 * @since 2021-11-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
