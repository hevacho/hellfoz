package hellfoz.model.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase para obtener las imagenes de inicio
 * 
 * @author hevacho
 *
 */
@Entity
@Table(name="imagenes_inicio", schema="hellfoz")
public class ImagenInicio {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ID_IMAGENES_INICIO")
		private int idImagenInicio;
		
		
		@Column(name="foto", columnDefinition="longblob")
		private byte[] foto;
		
		@Column(name="descripcion")
		private String descripcion;
		
		@Column(name="activo")
		private Boolean activo;

		public int getIdImagenInicio() {
			return idImagenInicio;
		}

		public void setIdImagenInicio(int idImagenInicio) {
			this.idImagenInicio = idImagenInicio;
		}

		public byte[] getFoto() {
			return foto;
		}

		public void setFoto(byte[] foto) {
			this.foto = foto;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ImagenesInicio [idImagenInicio=");
			builder.append(idImagenInicio);
			builder.append(", foto=");
			builder.append(Arrays.toString(foto));
			builder.append(", descripcion=");
			builder.append(descripcion);
			builder.append("]");
			return builder.toString();
		}
		
		

		
		
		
	
}
