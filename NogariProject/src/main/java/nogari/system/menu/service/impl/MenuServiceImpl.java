package nogari.system.menu.service.impl;

import lombok.extern.slf4j.Slf4j;
import nogari.system.menu.dao.mapper.MenuMapper;
import nogari.system.menu.domain.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nogari.system.menu.service.MenuService;

import java.util.List;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> findMenu(String menuCd, String menuNm) {
        log.info("===================>  MenuServiceImpl 진입");
        List<MenuDTO> list = menuMapper.selectMenuList(menuCd, menuNm);
        log.info("===================>  MenuServiceImpl 쿼리 돌고 난 후 :: {}",list.toString());
        return menuMapper.selectMenuList(menuCd, menuNm);
    }

    @Override
    public List<MenuDTO> findMenuByCd(String menuCd) {
        return menuMapper.selectScreen(menuCd);
    }

    @Override
    public void createMenu(List<MenuDTO> list) {
        log.info("===================>  MenuServiceImpl createMenu :: {}",list.size());
        int resultCnt = 0;
        for(MenuDTO mDto:list){
            menuMapper.insertMenu(mDto);
            resultCnt ++;
        }
        log.info("===================>  MenuServiceImpl resultCnt :: {}",resultCnt);
    }

    @Override
    public void editMenu(List<MenuDTO> list) {
        log.info("===================>  MenuServiceImpl createMenu :: {}",list.size());
        int resultCnt = 0;
        for(MenuDTO mDto:list){
            menuMapper.updateMenu(mDto);
            resultCnt ++;
        }
        log.info("===================>  MenuServiceImpl resultCnt :: {}",resultCnt);
    }

    @Override
    public void deleteMenu(String menuCd) {
        menuMapper.deleteMenu(menuCd);
    }
}
