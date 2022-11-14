# magneto
Magneto Analyzer detecta si el ADN ingresado es humano o mutante.       

El Analyzer se encuentra disponible a través de un servidor Rest API que expone 2 operaciones:
* [POST] /api/mutant/
  * body: con un arreglo que contiene 6 cadena de texto con bases nitrogenadas.
    ```json
    [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]  
    ```     
  * Responses
    * status 200 OK (si el ADN es mutante) 
    * status 403 Forbidden (si el ADN es humano) 
    * status 400 Bad Request (si el body enviado no contiene bases nitrodenas o esta fuera de formato) 
    
* [GET] /api/mutant/stats
  * Response
    ```json     
    {
      "count_mutant_dna": 5, 
      "count_human_dna": 7, 
      "ratio": 0.7142857142857143
    }  
    ``` 
 
<br>
      
## Contexto de implementación     
- Java -version
  ```bash
  openjdk version "17.0.4" 2022-07-19
  OpenJDK Runtime Environment (build 17.0.4+8-Ubuntu-120.04)
  OpenJDK 64-Bit Server VM (build 17.0.4+8-Ubuntu-120.04, mixed mode, sharing)
  ```
- Apache Maven version: 3.8.6
- Spring Boot version: 2.7.5
- Eclipse version: 2022-09 (4.25.0)
- Spring Tools version: 4.16.1 
- JUnit version: 4.13
- MySql version: 8.0 (Docker official image)
- Workbench version: 8.0.29
- Postman version: 10
- StarUML version: 5.0.1

## Requerimientos de instalación
- Java 17
- Apache Maven 3.8
- MySql 8.0
- Postman 10

## Instalación
1. Clonar este [repositorio](https://github.com/maximo-perez-villalba/magneto)  

2. Moverse al directorio magneto/
  ```bash
  cd magneto
  ```
3. Instalar Magneto Analyzer
  ```bash
  mvn install
  ```
4. Lanzar servidor Rest en el port: 8080
  ```bash
  java -jar magneto.analyzer-<version>.jar
  ```
    
<br>
      
## Testeo del Rest API
1. Abrir Postman
2. Cargar la colección de tests que se encuentra en [Magneto.Analyzer_postman-collection.json](/src/test/resources/Magneto.Analyzer_postman-collection.json)
3. Correr la colección completa
    
<br>
      
## Documentación 
Esta sección expone la documentación del core del servicio `Magento Analyzer` que se encuentra en el paquete `com.magneto.analyzer.core`.
    
El método `Analyzer.isMutant(String[] dna)` recibe en el argumento `dna` un arreglo con 6 Strings (matriz) y cada String tiene un largo de 6 caracteres, donde los caracteres solo pueden ser alguna de las bases nitrogendas: 'A','T','C','G'.         

Para que un ADN sea declarado mutante debe contener al menos 3 cadenas, cuya composición contengan 4 bases nitrogenadas consecutivas iguales: "AAAA", "GGGG", "CCCC" o "TTTT". Estas cadenas dentro de la matriz pueden encontrarse en líneas horizontales, verticales o diagonales.   

### Modelo de clases
![Modelo de clases](/docs/class-diagram-analyzer.png)

### Modelo de secuencia del caso de uso isMutant(String[] dna)

El método para poder detectar si es un ADN mutante, primero recorre las lineas horizontales, luego las líneas verticales y por último las líneas diagonales.

![Modelo de secuencia del caso de uso isMutant(String[] dna)](/docs/seuqence-diagram-analyzer-is-mutant.png)
      
<br>     
<br>     
     

