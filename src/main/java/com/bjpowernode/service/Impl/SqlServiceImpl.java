package com.bjpowernode.service.Impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.SqlSerivice;
import com.bjpowernode.utils.SqlSessionUtils;

public class SqlServiceImpl implements SqlSerivice {

    private StudentDao s = SqlSessionUtils.getSqlSession().getMapper(StudentDao.class);

    @Override
    public Student getById(Integer id) {

        Student byId = s.getById(id);

        return byId;
        
    }

}
