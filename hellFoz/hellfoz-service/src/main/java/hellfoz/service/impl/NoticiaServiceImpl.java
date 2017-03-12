/**
 * 
 */
package hellfoz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.NoticiaConverter;
import hellfoz.dto.NoticiaDto;
import hellfoz.dto.NoticiasPagina;
import hellfoz.model.dao.NoticiaDao;
import hellfoz.model.entities.Noticia;
import hellfoz.service.NoticiaService;

/**
 * @author hevacho
 *
 */
@Service("NoticiaServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class NoticiaServiceImpl implements NoticiaService {
	
	@Autowired
	private NoticiaDao noticiaDao;
	
	@Override
	public NoticiasPagina obtenerNoticias(int inicio, int tamanho){
		
		List<Noticia> noticiasBD = noticiaDao.getNoticiasPeq(inicio, tamanho);
		int total = noticiaDao.getTotalNoticias();
		
		NoticiasPagina toRet = new NoticiasPagina();
		toRet.setNoticias(NoticiaConverter.toDTO(noticiasBD));
		toRet.setTotal(total);
		
		return toRet;
	}

	/* (non-Javadoc)
	 * @see hellfoz.service.NoticiaService#obtenerNoticia(java.lang.Integer)
	 */
	@Override
	public NoticiaDto obtenerNoticia(Integer idNoticia) {
		Noticia not = noticiaDao.findById(Noticia.class, idNoticia);
		return NoticiaConverter.toDto(not);
	}

}
