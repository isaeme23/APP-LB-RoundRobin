<h1 align="center">
<p align="center">Round Robin Load Balancer</p>
</h1>
> **Version 1.0**

## Introducción
Este proyecto pretende implementar un balanceador de cargas que implementa el algoritmo de
*Round Robin* junto con un cliente web y un servicio web en donde se tiene un campo y un
botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y
actualiza la pantalla con la información que este le regresa en formato JSON.

## Instalación
Para poder instalar y usar este proyecto, se necesitará:
* Git.
* Maven.
* Java.
* Intellij o alguna IDE.

En la terminal de tu preferencia y en el directorio en donde trabajarás ejecuta la siguiente linea:

    git clone https://github.com/isaeme23/LogService.git

Por medio de GitHub CLI se podrá instalar este proyecto con la siguiente línea:

    gh repo clone isaeme23/LogService

## Uso del proyecto
### De forma Remota
Una vez instalado, podrás abrirlo en la IDE de su preferencia. Para compilar el código, en la terminal
del proyecto puedes escribir el siguiente comando:

    mvn clean package

Antes de ejecutar este proyecto, debemos ejecutar el servicio correspondiente al que redirigiremos las
peticiones del cliente web. El servicio correspondiente lo podremos encontrar en el siguiente repositorio
junto con sus instrucciones de uso:

```
- https://github.com/isaeme23/LogService
```

Una vez compilado y con el servicio corriendo, podrás ejecutar este proyecto con el siguiente comando en
la terminal correspondiente:

    mvn spring-boot:run

Al ejecutar el proyecto, podremos ver como funciona el proyecto colocando la siguiente línea en el navegador
nuestra preferencia.

    localhost:8080/index.html

Asi podremos ver la siguiente pantalla:

![](img/img1.png)

Si ingresamos cualquier palabra en espacio para insertar texto y hacemos click en el boton veremos el siguiente
comportamiento:

![img2.png](img/img2.png)

