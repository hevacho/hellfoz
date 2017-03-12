

            _ _   ___        
  /\  /\___| | | / __\__ ____
 / /_/ / _ \ | |/ _\/ _ \_  /
/ __  /  __/ | / / | (_) / / 
\/ /_/ \___|_|_\/   \___/___|


1. La estructura del proyecto se subdivide en tres modulos
	- Model: contiene las Entidades de Hibernate y tambien los Daos.
	- Service: capa de servicio que contiene la logica de negocio asi como la transaccion
	- Web: contiene los beans de la vista y un bean especial TaskEntradas que se encarga de enviar los emails con las entradas.
	
2. Para montar el proyecto debe disponerse de una BD, yo he elegido mySql. En caso de elegir otra habria que configurar el persistence.xml 
asi como seguramente elegir otro driver en el POM. Una vez montada la BD ejecutar el script hellfoz.sql que se encuentra en este mismo directorio.
La Base de Datos ya contiene las fotos, y los datos necesarios para poder ejecutar la aplicacion.
Crear un usuario hellfoz con password hellfoz. Si se desa otro entronces modificar en el fichero applicationContext-jpa el DataSource.

3. Configurar el fichero config.properties que se encuentra en src/main/conf/local para poner el servidor de correo que se usara. Yo he usado gmail

4. Configurar la captcha en el web.xml, puedes obtener una en la siguiente direccion https://www.google.com/recaptcha/intro/index.html

5. Configurar paypal para la parte de pagos. Necesitaras una cuenta en la snadbox de paypal y rellenar los datos de 

# Credentials
clientId=yourID
clientSecret=yourSecret

del fichero sdk_config.properties
 
6. Configurar las rutas de los logs en el fichero src/main/con/local/logback.xml
 
7. Compilar con maven usando el perfil local y desplegar en tu servidor o contenedor de aplicaciones. Yo he usado Tomcat 8 y Tomcat 7.

8. Se han subido los informes creados con Ireport (las entradas), al directorio InformesJasper.


