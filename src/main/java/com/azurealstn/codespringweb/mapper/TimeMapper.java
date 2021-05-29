package com.azurealstn.codespringweb.mapper;

import org.apache.ibatis.annotations.Select;

//애노테이션을 이용한 SQL 매핑
public interface TimeMapper {

    @Select("select sysdate from dual")
    public String getTime();

}
