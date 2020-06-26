package com.wod.service;

import com.wod.dao.ManagerMapper;
import com.wod.entity.Manager;
import com.wod.entity.ManagerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：童达
 * @date：2020/6/5 15:52
 */
@Service
public class ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    public boolean findManagerWithUsernameAndPassword(Manager manager){
        ManagerExample managerExample = new ManagerExample();
        managerExample.createCriteria().andUsernameEqualTo(manager.getUsername())
                .andPasswordEqualTo(manager.getPassword());
        List<Manager> managerList = managerMapper.selectByExample(managerExample);
        return managerList != null && managerList.size()==1;
    }
}
