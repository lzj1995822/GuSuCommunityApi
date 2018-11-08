package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.RoleMenu;
import com.cloudkeeper.leasing.identity.repository.RoleMenuRepository;
import com.cloudkeeper.leasing.identity.service.RoleMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单 service
 * @author jerry
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService {

    /** 角色菜单 repository */
    private final RoleMenuRepository roleMenuRepository;

    @Override
    protected BaseRepository<RoleMenu> getBaseRepository() {
        return roleMenuRepository;
    }

    @Nonnull
    @Override
    public List<RoleMenu> findAllByRoleId(@Nonnull String roleId) {
        return roleMenuRepository.findAllByRoleId(roleId);
    }

    @Override
    public void deleteAllByRoleId(@Nonnull String roleId) {
        roleMenuRepository.deleteAllByRoleId(roleId);
    }

    @Nonnull
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<RoleMenu> save(@Nonnull String roleId, @Nonnull List<String> menuCodeList) {
        roleMenuRepository.deleteAllByRoleId(roleId);
        return menuCodeList.stream().map(menuCode -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuCode(menuCode);
            return roleMenuRepository.save(roleMenu);
        }).collect(Collectors.toList());
    }

    @Nonnull
    @Override
    public List<String> findAllMenuCodeByPrincipalId(@Nonnull String principalId) {
        return roleMenuRepository.findAllMenuCodeByPrincipalId(principalId);
    }
}
