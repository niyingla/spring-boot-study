package com.imooc.architect.spring;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jimmy
 */
@SpringBootApplication
@RestController
public class H2Application {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public List<DemoModel> list() {
        return jdbcTemplate.query("select id,name,status,description,create_time,last_modified_time " +
                "from t_demo_model limit 100", new BeanPropertyRowMapper<DemoModel>(DemoModel.class));

    }

    @Data
    @ToString(exclude = {"createTime", "lastModifiedTime"})
    static class DemoModel implements Serializable {

        private Long id;
        private Integer status;
        private String name;
        private String note;
        private String description;
        @JsonIgnore
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createTime;
        @JsonIgnore
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date lastModifiedTime;

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(H2Application.class, args);
//        ContextUtils.printlnBeansClassName(context);

    }
}
