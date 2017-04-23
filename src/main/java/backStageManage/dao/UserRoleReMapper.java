package backStageManage.dao;

import domain.UserRoleRe;

public interface UserRoleReMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleRe record);

    int insertSelective(UserRoleRe record);

    UserRoleRe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleRe record);

    int updateByPrimaryKey(UserRoleRe record);
}