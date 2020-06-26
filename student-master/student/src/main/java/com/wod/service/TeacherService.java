package com.wod.service;

import com.wod.dao.TeacherMapper;
import com.wod.entity.Teacher;
import com.wod.entity.TeacherExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/6 15:20
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    public boolean findTeacherWithTeacherAccountAndTeacherPassword(Teacher teacher){
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeacherAccountEqualTo(teacher.getTeacherAccount())
                .andTeacherPasswordEqualTo(teacher.getTeacherPassword());
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        return teacherList != null && teacherList.size() == 1;
    }

    /**
     * 查询所有老师的信息
     * @return 所有老师的集合
     */
    public List<Teacher> selectAllTeacher(){
        return teacherMapper.selectAllTeacher();
    }

    public int updateByPrimaryKey(Teacher teacher){
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }
}
