## TIENDA DE HUERTOS

*¡Bienvenid@ a nuestra tienda!*

Este proyecto es una aplicación que permite gestionar una tienda 
que vende huertos, los cuales pueden contener plantas de distintas especies
como tomate, lechuga, mango o zanahoria. Los clientes pueden resgistrarse
y seleccionar qué desean comprar, si huertos del catálogo o personalizar
uno a su gusto. La aplicación se conecta a una base de datos SQLite y realiza
consultas para mostrar resultados específicos.

## DIAGRAMA DE CLASES

```mermaid
classDiagram

class Cliente{
-dni: String
-nombre: String
+getNombre():String
+setNombre(String):void
+getDni():String
+setDni(String):void
}


class Consultas{
-databaseManager:DatabaseManager
-resultSet:ResultSet
+insertarCliente(Cliente):boolean
+listaHuertos():ArrayList<DatosHuerto>
+cerrarConexion():void
}

class DatabaseManager{
-instance:DatabaseManager
-conexion:Connection
-url:String
+getInstance():DatabaseManager
+getConnection():Connection
+close():void
}

class DatosHuerto{
-idHuerto: Integer
-planta_id:Integer
-especie:String
+getIdHuerto():Integer
+setIdHuerto(Integer):void
+getPlanta_id():Integer
+setPlanta_id(Integer):void
+getEspecie():String
+setEspecie(String):void
}

class Huerto{
-idHuerto:Integer
-planta_id:Integer
+getIdHuerto():Integer
+setIdHuerto(Integer):void
+getPlanta_id():Integer
+setPlanta_id(Integer):void
}

class Planta{
-Especie:enum
-idPlanta:Integer
-especie:Especie
+getEspecie():Especie
+setEspecie(Especie):void
+getIdPlanta():Integer
+setIdPlanta(Integer):void
}

class View{
+mostrarHuertoIU():void
+mostrarHuertoCatalogoIU():void
+mostrarHuertoPersonalizado():void
}

class HuertoIU{
initComponents()
}

class HuertoCatalogoIU{
initComponents()
+cargarTabla():void
}

class HuertoPersonalizadoIU{
initComponents()
}

class HuertoController{
 +main()
 +abrirCatalogo()
 +abrirPersonalizado()
}

Controller o-- HuertoController

Model o-- Cliente
Model o-- Huerto
Model o-- DatosHuerto
Model o-- Planta
Model o-- Consultas
Model o-- DatabaseManager

Model <|-- Controller
View <|-- Controller

View o-- HuertoIU
View o-- HuertoCatalogoIU
View o-- HuertoPersonalizadoIU
```



## DIAGRAMA DE SECUENCIA
El diagrama de secuencia de este proyecto, es una representación visual de las interacciones y 
la secuencia de eventos en el proyecto, lo que facilita la comprensión y el análisis del flujo de 
ejecución y la comunicación entre los diferentes componentes del sistema. Sigue el patrón de diseño MVC, el cual
observaremos mejor gracias a este diagrama.

```mermaid
sequenceDiagram
    participant User
    participant View
    participant Controller
    participant Model
    
    User ->> View: Registra al cliente
    activate View
    View ->> Controller: El cliente se quiere registrar
    activate Controller
    Controller->> Model: ¿Puedes registrar al cliente?
    activate Model
    Model-->>Controller: Ya está registrado
    deactivate Model
    Controller-->>View: Cliente registrado!
    deactivate Controller
    View-->>User:Listo! Tu cliente fue registrado

    User->>View: Quiero comprar un huerto del catálogo
    activate View
    View-->>Controller: El cliente quiere comprar un huerto del catálogo
    activate Controller
    Controller->>Model: Puedes venderle un huerto del catálogo?
    activate Model
    Model-->>Controller: Aquí tienes el huerto
    deactivate Model
    Controller-->>View: Huerto comprado!
    deactivate Controller
    View-->>User: Listo, tu huerto ha sido comprado!
    deactivate View
```