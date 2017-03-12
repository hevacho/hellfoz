/**
 * 
 */
package hellfoz.service.impl;

import hellfoz.dto.FicheroDto;
import hellfoz.dto.ParametroVarioDto;
import hellfoz.model.dao.FicheroVarioDao;
import hellfoz.model.dao.ParametroVarioDao;
import hellfoz.model.entities.FicheroVario;
import hellfoz.model.entities.ParametroVario;
import hellfoz.service.VariosService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import utiles.Constants;
import converters.FicheroVarioConverter;
import converters.ParametroConverter;

/**
 * @author hevacho
 *
 */
@Service("VariosServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class VariosServiceImpl implements VariosService {
	
	private static final Logger LOG = LoggerFactory.getLogger(VariosServiceImpl.class);
	
	@Autowired
	private FicheroVarioDao ficheroVarioDao;
	
	@Autowired
	private ParametroVarioDao parametroVarioDao;
	
	@Override
	public FicheroDto obtenerHorarioGrupos(){
		List<FicheroVario> ficheros = ficheroVarioDao.getFicheroVario(Constants.CLAVE_GRUPOS_HORARIO);
		
		if(ficheros!=null && !ficheros.isEmpty()){
			if(ficheros.size()>1){
				LOG.warn("Existe mas de un fichero para los grupos de horarios. Clave busqueda:"+Constants.CLAVE_GRUPOS_HORARIO);
			}
			return FicheroVarioConverter.toDTO(ficheros.get(0));
		}
		return null;
	}
 	
	@Override
	public ParametroVarioDto obtenerParametroClaveNow(String clave){
		return obtenerParametroClave(clave);
	}

	
	@Override
	@Cacheable(value="eternal")
	public ParametroVarioDto obtenerParametroCacheado(String clave){
		return obtenerParametroClave(clave);
	}
	
	/**
	 * @param clave
	 * @return
	 */
	private ParametroVarioDto obtenerParametroClave(String clave) {
		ParametroVario paramBD = parametroVarioDao.findByClaveAndTimeNow(clave);
		
		if(paramBD!=null){
			return ParametroConverter.toDto(paramBD);
		}
		
		LOG.warn("Se ha recuperado un parametro nulo con la clave :"+clave);
		
		return null;
	}
	
}
