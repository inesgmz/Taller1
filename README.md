
Voy a explicar lo que he hecho en este proyecto 
## MainActivity.kt
Vamos a crear una aplicación sencilla que permite al usuario ingresar un nombre, guardarlo temporalmente y luego navegar a una pantalla de configuración. Utiliza un ViewModel para gestionar el color del fondo de la pantalla 
-  MainActivity es la actividad principal de la aplicación, que contiene la pantalla donde el usuario puede ingresar su nombre y navegar a la siguiente actividad.
-  El @composable  MainScreen  maneja el diseño de la pantalla principal. Permite al usuario ingresar un nombre, guardarlo temporalmente, y luego mostrar el nombre guardado en pantalla. También tiene un botón que permite navegar a la pantalla de configuración.
### SettingsActivity.kt
Esta clase perimite a los usuarios cambiar el color de fondo de la pantalla de configuración y navegar a una pantalla de inicio. Esta aplicación incluye :
- Selección de Color: Los usuarios pueden elegir entre tres colores amarillo, gris claro y azul para configurar el color de fondo de la pantalla.
- Navegación: Un botón que permite volver a la pantalla de inicio.
- La clase AppViewModel extiende ViewModel y almacena el estado del color de fondo seleccionado utilizando mutableStateOf.
- SettingsActivity es la actividad principal de la pantalla de configuración. Inicializa el ViewModel y establece el contenido de la pantalla utilizando el composable SettingsScreen. Además, incluye funcionalidad de navegación hacia la StartActivity.
- El @composable SettingsScreen representa el diseño de la pantalla de configuración. Tiene una columna que muestra la UI de ColorSelection para elegir el color de fondo y un botón que navega de vuelta a la pantalla de inicio.
- El @composable ColorSelection permite al usuario seleccionar uno de tres colores (Amarillo, Gris Claro o Azul). Cuando un color es seleccionado, el viewModel actualiza el estado de selectedBackgroundColor, lo que cambia el color de fondo en la SettingsScreen.
- El @composable ColorButton representa un botón que permite al usuario seleccionar un color de fondo. Cuando un color es seleccionado, aparece un ícono de verificación y el viewModel se actualiza para reflejar el color elegido.
### StartActivity.kt
Esta clase se enfoca en crear una pantalla de inicio que muestra un saludobasado en la hora del día y permite al usuario navegar a la pantalla principal de la aplicación.
- StartActivity es la actividad principal que se encarga de la pantalla de inicio. Esta actividad utiliza el ViewModel para almacenar el estado del color de fondo y establece el contenido mediante la función composable StartScreen.
- El @composable StartScreen maneja el diseño de la pantalla de inicio. Esta configurado para que calcule la hora actual para mostrar un saludo adecuado. Además, se incluye un botón que permite al usuario continuar a la siguiente pantalla. 
