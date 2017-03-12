/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.NoticiaDao;
import hellfoz.model.entities.Noticia;

/**
 * @author hevacho
 *
 */
@Repository
public class NoticiaDaoImpl extends
		AbstractBaseGenericDaoImpl<Noticia, Integer> implements NoticiaDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Noticia> getNoticiasPeq(int inicio, int tamanhoBloque){
		String jpql = "Select n.idNoticia, n.titulo, n.texto, n.fecha, n.intro, n.fotoPeq  FROM Noticia n order by n.fecha desc";
		Query query = getEntityManager().createQuery(jpql);
		
		query.setFirstResult(inicio);
		query.setMaxResults(tamanhoBloque);
		
		 List<Object[]> objects = query.getResultList();
		 List<Noticia> toRet = new ArrayList<Noticia>();
		 for (Object[] object : objects) {
			Noticia noticia= new Noticia();
			noticia.setIdNoticia((Integer) object[0]);
			noticia.setTitulo((String) object[1]);
			noticia.setTexto((String) object[2]);
			noticia.setFecha((Date) object[3]);
			noticia.setIntro((String) object[4]);
			noticia.setFotoPeq((byte[]) object[5]);
			
			toRet.add(noticia);
		}
		 
		 return toRet;
	}
	
	@Override
	public int getTotalNoticias(){
		String jpql = "Select count(n.idNoticia) FROM Noticia n";
		Query query = getEntityManager().createQuery(jpql);
		
		try{
			return Integer.parseInt(query.getSingleResult().toString());
		}catch(NoResultException e){
			return 0;
		}
	}

}
