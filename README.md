Voy a explicar lo que he hecho en este proyecto 
## MainActivity.kt
### SettingsActivity.kt
Esta clase perimite a los usuarios cambiar el color de fondo de la pantalla de configuración y navegar a una pantalla de inicio. Esta aplicación incluye :
- Selección de Color: Los usuarios pueden elegir entre tres colores amarillo, gris claro y azul para configurar el color de fondo de la pantalla.
- Navegación: Un botón que permite volver a la pantalla de inicio.
La clase AppViewModel extiende ViewModel y almacena el estado del color de fondo seleccionado utilizando mutableStateOf.
SettingsActivity es la actividad principal de la pantalla de configuración. Inicializa el ViewModel y establece el contenido de la pantalla utilizando el composable SettingsScreen. Además, incluye funcionalidad de navegación hacia la StartActivity.
El @composable SettingsScreen representa el diseño de la pantalla de configuración. Tiene una columna que muestra la UI de ColorSelection para elegir el color de fondo y un botón que navega de vuelta a la pantalla de inicio.
El @composable ColorSelection permite al usuario seleccionar uno de tres colores (Amarillo, Gris Claro o Azul). Cuando un color es seleccionado, el viewModel actualiza el estado de selectedBackgroundColor, lo que cambia el color de fondo en la SettingsScreen.
El @composable ColorButton representa un botón que permite al usuario seleccionar un color de fondo. Cuando un color es seleccionado, aparece un ícono de verificación y el viewModel se actualiza para reflejar el color elegido.
### StartActivity.kt
