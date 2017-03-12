/**
 * 
 */
package converters;

import hellfoz.dto.ImagenDto;
import hellfoz.dto.NoticiaDto;
import hellfoz.model.entities.Noticia;

import java.util.ArrayList;
import java.util.List;

import utiles.FechaUtil;

/**
 * Clase de conversiones para el elemento Noticia
 * @author hevacho
 *
 */
public class NoticiaConverter {
	
	private static String TRES_PUNTOS="...";
	
	public static NoticiaDto toDto(Noticia noticia){
		NoticiaDto toRet = null;
		
		if(noticia!=null){
			toRet = new NoticiaDto();
			toRet.setEnlace(noticia.getEnlace());
			toRet.setFecha(FechaUtil.convertirFecha(noticia.getFecha()));
			
			//imagen pequenha
			if(noticia.getFotoPeq()!=null && noticia.getFotoPeq().length>0){
				ImagenDto fotoPeq = new ImagenDto();
				fotoPeq.setIdImagen(noticia.getIdNoticia());
				fotoPeq.setFoto(noticia.getFotoPeq());
				toRet.setFotoPeq(fotoPeq);
			}
			
			//imagen grande
			if(noticia.getFotoGrande()!=null && noticia.getFotoGrande().length>0){
				ImagenDto fotoGrande = new ImagenDto();
				fotoGrande.setIdImagen(noticia.getIdNoticia());
				fotoGrande.setFoto(noticia.getFotoGrande());
				toRet.setFotoGrande(fotoGrande);
			}
			
			toRet.setIdNoticia(noticia.getIdNoticia());
			toRet.setTexto(noticia.getTexto());
			toRet.setTextoPeq(noticia.getIntro()+TRES_PUNTOS);
			toRet.setTitulo(noticia.getTitulo());
			
		}
		
		return toRet;
		
	}
	
	public static List<NoticiaDto> toDTO(List<Noticia> noticias){
		List<NoticiaDto> toRet = null;
		if(noticias!=null && !noticias.isEmpty()){
			toRet = new ArrayList<NoticiaDto>();
			for (Noticia noticia : noticias) {
				toRet.add(toDto(noticia));
			}
		}
		
		return toRet;
	}

}
