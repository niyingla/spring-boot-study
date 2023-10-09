package com.imooc.architect.showcase.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_demo_model")
public class DemoModel  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Integer status;
    private String name;
    private String note;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date lastModifiedTime;

}
