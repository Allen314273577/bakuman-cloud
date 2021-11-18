package cn.bakuman.auth.service.impl;


import cn.bakuman.auth.mapper.RoleMapper;
import cn.bakuman.auth.po.Role;
import cn.bakuman.auth.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
