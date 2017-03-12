package hellfoz.model;

import java.io.Serializable;
import java.util.List;

public interface BaseGenericDao<T, K extends Serializable> {

	 T create(T entity);

     T update(T entity);

     void delete(T entity);

     T findById(Class<T> clase, K key);

     List<T> findAll(Class<T> clase);

	 
}
