package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.Impl.SqlServiceImpl;
import com.bjpowernode.service.SqlSerivice;
import com.bjpowernode.utils.SqlService;
import org.junit.Test;

public class TestStudentDao {

    @Test
    public void TestgetById(){

        SqlSerivice s = new SqlServiceImpl();
        SqlSerivice ss = (SqlSerivice) SqlService.getSqlService(s);
        Student byId = ss.getById(1);
        System.out.println(byId);

    }

}
