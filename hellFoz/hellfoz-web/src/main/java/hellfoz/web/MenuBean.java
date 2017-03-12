/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.ElementoMenuDto;
import hellfoz.dto.ElementoSubMenuDto;
import hellfoz.service.MenuService;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 * @author hevacho
 *
 */

@ManagedBean(name="menuBean")
@SessionScoped
public class MenuBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{MenuServiceImpl}")
	private transient MenuService menuService;
	

	private MenuModel menuModel;
		
	@PostConstruct
	private void init(){
		
		obtenerMenu();
	}

	
	
	
	

	/**
	 * Obtiene el menu y lo transforma a un objeto para primefaces
	 */
	private void obtenerMenu() {
		if(menuModel==null){
			List<ElementoMenuDto> elementosMenu = menuService.obtenerMenusActivos();
			menuModel = new DefaultMenuModel();
			for (ElementoMenuDto elementoMenuDto : elementosMenu) {
				if(!elementoMenuDto.isTieneHijos()){
					DefaultMenuItem menuItem = new DefaultMenuItem(elementoMenuDto.getDescripcion());
					menuItem.setCommand(elementoMenuDto.getRuta());
					menuModel.addElement(menuItem);
					
				}else{
					 DefaultSubMenu secondSubmenu = new DefaultSubMenu(elementoMenuDto.getDescripcion());
					 for (ElementoSubMenuDto elementoSubmenu : elementoMenuDto.getElementosSubmenu()) {
						DefaultMenuItem menuItem = new DefaultMenuItem(elementoSubmenu.getDescripcion());
						menuItem.setCommand(elementoSubmenu.getRuta());
						secondSubmenu.addElement(menuItem);
					}
					menuModel.addElement(secondSubmenu);
				}
			
			}
		}
	}

	

	/**
	 * @return the menuModel
	 */
	public MenuModel getMenuModel() {
		return menuModel;
	}



	/**
	 * @param menuModel the menuModel to set
	 */
	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}



	/**
	 * @return the menuService
	 */
	public MenuService getMenuService() {
		return menuService;
	}

	/**
	 * @param menuService the menuService to set
	 */
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}



	

	
}
