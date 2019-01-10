package com.isoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> findPost(){
        String sql="select * from post";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    public List<Map<String,Object>> findPostInfo(String name,int postid){
        System.out.println("name="+name);
        String str="";
        if(!name.equals("")){
            str+=" and emp_name="+name;
            System.out.println(str);
        }
        if(postid!=0)
            str+=" and post_type="+postid;
        String sql="select a.id,b.post_name,emp_name,CASE  emp_sex WHEN  1 THEN     \"男\" WHEN  2 THEN    \"女\" else \"-\" END as emp_sex,emp_age,emp_depart,emp_year from employee a INNER JOIN post b on a.post_type=b.id where 1=1 "+str;
        System.out.println(sql);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
}
