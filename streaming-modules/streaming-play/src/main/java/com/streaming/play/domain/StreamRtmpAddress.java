package com.streaming.play.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
    * 视频地址
    */
@Getter
@Setter
@TableName(value = "stream_rtmp_address")
public class StreamRtmpAddress {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "stream")
    private String stream;

    @TableField(value = "url")
    private String url;
}