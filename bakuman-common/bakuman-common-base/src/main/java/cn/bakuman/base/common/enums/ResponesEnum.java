package cn.bakuman.base.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author 梦叶
 * @date 2021/11/10 17:00
 */
@AllArgsConstructor
@Getter
public enum ResponesEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "网路繁忙")
    ;
    private int code;
    private String message;
}
