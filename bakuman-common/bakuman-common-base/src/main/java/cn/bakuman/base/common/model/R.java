package cn.bakuman.base.common.model;

import cn.bakuman.base.common.enums.ResponesEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1206834903869667508L;

    /**
     * @see ResponesEnum
     */
    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("响应体数据")
    private T data;

    @ApiModelProperty("message")
    private String message;

    public R(ResponesEnum responesEnum) {
        this.data = null;
        this.code = responesEnum.getCode();
        this.message = responesEnum.getMessage();
    }

    public static <T> R<T> success() {
        return new R<T>(ResponesEnum.SUCCESS);
    }

    public static <T> R<T> error() {
        return new R<T>(ResponesEnum.ERROR);
    }

    public static <T> R<T> error(String message) {
        return new R<T>(ResponesEnum.ERROR).setMessage(message);
    }

    public static <T> R<T> success(T t) {
        R<T> success = R.success();
        success.setData(t);
        return success;
    }
}
