package com.seata.account.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName(value = "t_account")
public class TAccount {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @TableField(value = "total")
    private Long total;

    /**
     * 已用额度
     */
    @TableField(value = "used")
    private Long used;

    /**
     * 剩余可用额度
     */
    @TableField(value = "residue")
    private Long residue;
}