FROM openjdk:8
COPY example.txt /ruta/en/el/contenedor/example.txt
COPY target/EmisorAdquiriente-1.0.jar java-app.jar
ENTRYPOINT [ "java","-jar","/java-app.jar" ]