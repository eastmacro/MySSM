package domain;

public class Role {
    private Integer id;

    private String roleNameEn;

    private String roleNameCh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn == null ? null : roleNameEn.trim();
    }

    public String getRoleNameCh() {
        return roleNameCh;
    }

    public void setRoleNameCh(String roleNameCh) {
        this.roleNameCh = roleNameCh == null ? null : roleNameCh.trim();
    }
}