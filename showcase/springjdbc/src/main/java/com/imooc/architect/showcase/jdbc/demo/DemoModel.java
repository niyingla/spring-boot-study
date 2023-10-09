package com.imooc.architect.showcase.jdbc.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jimmy
 */
@Data
@ToString(exclude = {"createTime", "lastModifiedTime"})
public class DemoModel implements Serializable {

    private Long id;
    private Integer status;
    private String name;
    private String note;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastModifiedTime;

}
