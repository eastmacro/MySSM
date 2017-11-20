package manage.service;

import domain.Role;
import manage.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiong
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper mapper;


    public Set<String> selectByUserId(Integer userId){
        List<Role> roleList = mapper.selectByUserId(userId);
        Set<String> roleSet = new HashSet<>();
        for (Role role : roleList){
            roleSet.add(role.getRoleNameEn());
        }
        roleList.addAll(roleList);
        return roleSet;
    }

}
