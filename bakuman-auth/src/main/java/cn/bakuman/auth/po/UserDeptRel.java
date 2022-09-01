package cn.bakuman.auth.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 梦叶
 * @since 2021-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bkm_user_dept_rel")
@ApiModel(value="UserDeptRel对象", description="")
public class UserDeptRel implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private Integer userId;

    private Integer deptId;


}
