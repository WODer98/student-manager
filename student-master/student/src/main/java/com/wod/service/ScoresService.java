package com.wod.service;

import com.wod.dao.ScoresMapper;
import com.wod.entity.AvgScoresSubject;
import com.wod.entity.Scores;
import com.wod.entity.ScoresExample;
import com.wod.entity.StudentScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/20 15:55
 */
@Service
public class ScoresService {
    @Autowired
    private ScoresMapper scoresMapper;

    /**
     * 查询所有学生成绩
     * @return
     */
    public List<StudentScores> selectStudentScores(){
        return scoresMapper.selectStudentScores();
    }

    /**
     * 插入学生成绩
     * 成功则返回数字1
     */
    public boolean insert(Scores scores){
        ScoresExample scoresExample = new ScoresExample();
        scoresExample.createCriteria().andCourseIdEqualTo(scores.getCourseId()).andStudentAccountEqualTo(scores.getStudentAccount());
        List<Scores> scoresList = scoresMapper.selectByExample(scoresExample);
        if (scoresList !=null && scoresList.size()>0){
            return false;
        }
        scoresMapper.insert(scores);
        return true;
    }

    public List<AvgScoresSubject> selectAvgScoresSubject(){
        return scoresMapper.selectAvgScoresSubject();
    }

    public List<StudentScores> selectScoresPersonal(String studentAccount){
        return scoresMapper.selectScoresPersonal(studentAccount);
    }
}
