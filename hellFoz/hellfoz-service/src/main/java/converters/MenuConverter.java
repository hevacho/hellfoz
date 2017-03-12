/**
 * 
 */
package converters;

import java.util.LinkedList;
import java.util.List;

import hellfoz.dto.ElementoMenuDto;
import hellfoz.dto.ElementoSubMenuDto;
import hellfoz.model.entities.ElementoMenu;
import hellfoz.model.entities.ElementoSubmenu;

/**
 * @author hevacho
 *
 */
public class MenuConverter {
	
	public static ElementoSubMenuDto toDTO(ElementoSubmenu e){
		ElementoSubMenuDto toRet = null;
		
		if(e!=null){
			toRet= new ElementoSubMenuDto();
			toRet.setDescripcion(e.getDescripcion());
			toRet.setRuta(e.getDireccion());
		}
		
		return toRet;
	}
	
	public static List<ElementoSubMenuDto> toDTO(List<ElementoSubmenu> elementos){
		List<ElementoSubMenuDto> toRet = null;
		
		if(elementos!=null){
			toRet = new LinkedList<ElementoSubMenuDto>();
			for (ElementoSubmenu elementoSubmenu : elementos) {
				if(elementoSubmenu!=null && elementoSubmenu.getActivo()!=null && elementoSubmenu.getActivo().booleanValue()){
					toRet.add(toDTO(elementoSubmenu));
				}
			}
		}
		
		return toRet;
	}
	
	public static ElementoMenuDto toDto (ElementoMenu elemento){
		ElementoMenuDto toRet = null;
		
		if(elemento!=null){
			toRet = new ElementoMenuDto();
			toRet.setDescripcion(elemento.getDescripcion());
			toRet.setRuta(elemento.getDireccion());
			toRet.setTieneHijos(elemento.getElementosSubmenu()!=null && !elemento.getElementosSubmenu().isEmpty());
			toRet.setElementosSubmenu(toDTO(elemento.getElementosSubmenu()));
		}
		
		return toRet;
		
	}
	
	public static List<ElementoMenuDto> toDto(List<ElementoMenu> elemento){
		List<ElementoMenuDto> toRet =null;
		if(elemento!=null){
			toRet = new LinkedList<ElementoMenuDto>();
			for (ElementoMenu elementoMenu : elemento) {
				if(elementoMenu!=null && elementoMenu.getActivo()!=null && elementoMenu.getActivo().booleanValue()){
					toRet.add(toDto(elementoMenu));
				}
			}
		}
		
		return toRet;
	}

}
