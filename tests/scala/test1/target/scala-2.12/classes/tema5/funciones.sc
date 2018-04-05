def saludo = "hola"

saludo

def multiplicar(x: Int, y: Int): Int = x * y

def multiplicar2(x: Int, y: Int) = x * y

// Uso de return
def quitarBlancosIniciales(s: String): String = {
	if (s == null) return null
	s.trim

}

def imprimirMensaje(s: String) = println(s)

def mostrarValor(x: Int) = println(x)

mostrarValor(3)

mostrarValor(3+5*5)

// Si se muestra por pantalla, se accede a un fichero, etc, se
// debería usar paréntesis
def mostrarError() = {
	println("Error...")
}
