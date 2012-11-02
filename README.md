# Laboratorio 2 de Programación II #

Un auto cuenta con una caja de cambios que maneja hasta 3 velocidades.
Se sabe también que cada cambio puede desarrollar un límite mínimo y máximo
de velocidad(en kph) tal como se muestra en la tabla adjunta.

| CAMBIO | VELOCIDAD MIN | VELOCIDAD MAX |
|:------:|:-------------:|:-------------:|
|PRIMERA |0				 |60			 |
|SEGUNDA |61			 |120			 |
|TERCERA |121			 |180			 |

En caso de que el auto intentara acelerar o frenar fuera de los límites
establecidos, entonces el *sistema de guía inteligente* automáticamente
baja o sube la velocidad(según sea el caso) hasta el límite más próximo.
Esto lo hace siempre y cuando la nueva velocidad establecida se encuentre
a ±10kph del límite establecido.
Si estuviera fuera de este límite, entonces el motor se funde y el auto se detiene.
Por ejemplo, si se encuentra en *segunda* y acelera hasta 125kph, automáticamente la
velocidad se establece a 120kph, sin embargo, si se frena hasta 50kph entonces el motor se funde.

**Observaciones**
* El auto cuenta con los métodos *acelerar, frenar y hacerCambios*.
* Ud. decide en qué medida aumenta o disminuye la velocidad a medida que acelera o frena.
* Visualice los valores de aceleración, frenado y cambios en la pantalla.

## Solución:

* Diagrama de clases

![UML](https://cacoo.com/diagrams/YrqAdCVV9cAY4Lz5-71DA3.png "lab2-UML-melo")