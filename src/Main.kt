import javax.annotation.processing.Messager

/*
//Con Constructor
//Crea una clase Libro con un constructor que acepte titulo y autor.
//Instancia un objeto de Libro.
class Libro(titulo:String="",autor:String=""){}
val libro:Libro=Libro("Hola","Pedro")

//Sin Constructor
//Crea una clase Persona sin constructor.
//Instancia un objeto de Persona y asigna valores a sus propiedades
class Persona(){
    var nombre="Pedro"
    var edad="100"
}
val persona:Persona=Persona()

//Constructor Primario y Secundario
//Crea una clase Coche con un constructor primario que acepte marca. Añade un constructor secundario que acepte marca y modelo.
class Coche(marcha:Int){
    constructor(modelo: String=""):this(marcha=0){}
}

//Con Constructor Default
//Crea una clase Mascota con propiedades nombre y tipo con valores
//por defecto. Instancia un objeto sin pasar argumentos.

class Mascota(nombre:String="Princesa",tipo:String="perro"){}
val princesa:Mascota=Mascota()

//Objeto con Métodos
//Crea una clase Calculadora que tenga un método sumar con dos
// parámetros y que retorne su suma.
 class Calculadora(){
    fun sumar(a:Float,b:Float):Float{
        return a+b
    }
}
val c=Calculadora()
var resp=c.sumar(100F,100F)
fun main() {
  println(resp)
}

//Objetos con Propiedades Mutables
//Crea una clase Estudiante con una propiedad mutable
//calificacion. Instancia un objeto y modifica su calificacion.
//nota el copilador toma los paretesis desde del nombre como un contructor si se declara otro de segundo
//nivel emite un erro de contructor Primary constructor call expected
class Estudiante{
    public var calificacion:Float
    constructor(){
        calificacion=0.0f
    }
}

fun main() {
    var pedro:Estudiante = Estudiante()
 pedro.calificacion=10f
    println(pedro.calificacion)
}

//Clase con Propiedad de Solo Lectura
//Crea una clase Configuracion con una propiedad de solo
// lectura urlServidor.
 class Configuracion{
    val urlServidor:String="www.code.com"
}
fun main() {
  var configuracion:Configuracion=Configuracion()
    println(configuracion.urlServidor)
    //configuracion.urlServidor="100" //errror
}

//Objeto con Inicializador
//Crea una clase Usuario con un bloque de inicialización que imprima
//"Usuario Creado" cuando se instancia.
class Usuario{
    constructor(){
        println("Usuario Creado")
    }
}

var usuario:Usuario=Usuario()

//Clase con Lista de Objetos
//Crea una clase Grupo que contenga una
//lista de Estudiante. Añade estudiantes al grupo.
class Estudiante{
    var nombre:String
    constructor(nombre:String="Alumno"){
        this.nombre=nombre
    }
}
class Grupo{
    var listaEstudiante:MutableList<Estudiante> = mutableListOf()
    constructor( lista:MutableList<Estudiante> ){
        this.listaEstudiante=lista
    }
}
var grupoEstudiante:Grupo = Grupo(mutableListOf(
    Estudiante("Pedro"),
    Estudiante("Antorio"),
    Estudiante("Samuel"),
    Estudiante()
))

fun main() {
    for(i in grupoEstudiante.listaEstudiante){
        println(i.nombre)
    }
}


//Instancia Objetos en una Lista
//Crea una lista de Libro e instancia tres
//libros directamente en la lista.
class Libro(autor:String="Autor",nombre:String="Nombre"){}
var lista:MutableList<Libro> = mutableListOf(
    Libro("Gabriel Garcia Marquez","100 años de soledad")
)

//Modificación de Propiedades tras Instancia
//Crea un objeto de Persona y modifica su
//propiedad edad después de instanciarlo.
class Persona{var edad}
fun main(){
    var pedro:Persona= Persona(1)
    pedro.edad=10
    println(pedro.edad)
}

//Constructor con Propiedades Opcionales
//Crea una clase Producto con un constructor que
//tenga una propiedad opcional precio.
class Producto(val precio:Float=0.0F)
fun main(){
  var producto:Producto = Producto()
    println(producto.precio)
}

//Instancia con Bloque apply
//Instancia un objeto de Coche y usa apply para asignar marca y modelo.
//nota los cambios si se guardan el objeto
class Coche(var marca:String="",var modelo:String="")
fun main(){
   var coche:Coche = Coche().apply {
       marca="Mustang"
       modelo="GT"
   }
    println("El carro es de la marca ${coche.marca} del model ${coche.modelo}")
}

//Uso de also tras Instancia
//Crea y configura un objeto Mascota usando also.
class Mascota(var nombre:String)
//nota Dentro del bloque also, puedes realizar operaciones
// secundarias sin modificar el objeto original
fun main(){
   var princesa = Mascota("Princesa").also {
       println(it.nombre)
   }
}

//Creación de Objeto Singleton
//Crea un objeto ConfiguracionGlobal
//usando object para que actúe como singleton.
//https://www.baeldung.com/kotlin/singleton-classes
class ConfiguracionGlobal private constructor(){
    val url_api:String="www.code.com"
    companion object{
        val intance:ConfiguracionGlobal by lazy{
            ConfiguracionGlobal()
        }
    }
}

fun main(){
    //comparo la direccion de memoria
    var auxGlobal:ConfiguracionGlobal = ConfiguracionGlobal.intance
   println("${auxGlobal.url_api} hash de la variable:${System.identityHashCode(auxGlobal)}")
    var auxGlobal1:ConfiguracionGlobal = ConfiguracionGlobal.intance
    println("${auxGlobal.url_api} hash de la variable:${System.identityHashCode(auxGlobal1)}")
}

//Clase con Contador de Instancias
//Crea una clase Alumno que cuente cuántas instancias se han creado.
class Alumno{
    var nombre:String
    constructor(nombre:String="Alumno"){
        this.nombre=nombre
        setAlumnos(getAlumnos()+1)
    }
    companion object{
        private var count = 0
         fun getAlumnos():Int{
            return this.count
        }
        private fun setAlumnos(count:Int){
            this.count=count
        }
    }
}

fun main() {
    var listAlumno: MutableList<Alumno> = mutableListOf()
    for (i in 0..(10..40).random()) {
        listAlumno.add(Alumno((0..100).random().toString()))
    }
    //los metodos estaticos se llaman desde el nombre de la clase
    println(Alumno.getAlumnos())
    var aux=1
    for (i in listAlumno){
        println("${i.nombre} ${aux}")
        aux++
    }
}

//Objetos con Diferentes Constructores
//Crea una clase Pantalla con varios constructores que acepten diferentes combinaciones de propiedades.
class Pantalla(x:Int=0,y:Int=0){
    var x: Int = 0
    var y: Int = 0
    var ancho:Int = 0
    var alto:Int = 0
    var pixel:Int = 0

    init {
        this.x=0
        this.y=0
    }

    constructor(ancho:Int=0,alto:Int=0,x: Int=0, y: Int=0) : this(x,y) {
        this.alto=alto
        this.ancho=ancho
    }

    constructor(ancho:Int=0,alto:Int=0,x: Int=0, y: Int=0,pixel:Int=0) : this(ancho,alto,x,y){
        this.pixel=pixel
    }
}
fun main() {
    var pantalla:Pantalla =Pantalla()
    var pantalla1:Pantalla=Pantalla(1)
    var pantalla2:Pantalla=Pantalla(1,2)
    var pantalla3:Pantalla=Pantalla(1,2,3)
    var pantalla4:Pantalla=Pantalla(1,2,3,4)
    var pantalla5:Pantalla=Pantalla(1,2,3,4,5)
}


//Clase con Método que Modifica Propiedades
//Crea una clase Juego que tenga un método
//actualizarPuntuacion que modifica la puntuación del jugador.
class Juego(vida:Int=10,ataque:Int=10,puntosPartida:Int=0){
    var vida:Int = 0
    var ataque:Int = 0
    var aumentarPuntos = 0
    init {
       this.vida=10
       this.ataque=10
       this.aumentarPuntos=0
    }
    fun aumentarPuntos(puntos:Int=1){ if(puntos<0) return
       this.aumentarPuntos+=puntos
    }
}
fun main() {
   var juego:Juego = Juego()
    juego.aumentarPuntos()
    juego.aumentarPuntos(10)
    println(juego.aumentarPuntos)
}

//Instancia de Objeto con Constructor Secundario
//Usa el constructor secundario de Coche para crear un objeto con marca y modelo.
class Coche(placa:String=""){
    var placa:String =""
    var marca:String =""
    var modelo:String=""
    init {
        this.placa=placa
    }
    constructor(placa: String="",marca:String="",modelo:String="") : this(placa){
        this.marca=marca
        this.modelo=modelo
    }
}
fun main() {
    val coche = Coche(marca = "Toyota", modelo = "Corolla")
    println("Marca: ${coche.marca}, Modelo: ${coche.modelo}")
}

//Condiciones en Bloque de Inicialización
//En Usuario, añade un bloque de inicialización que verifique
//una condición antes de completar la creación del objeto.
class Caldera{
    var estadoCaldera:String=""
    var peligro:Boolean?=null
    constructor(estadoCaldera:String=""){
        when(estadoCaldera){
            "NORMAL","ACETABLE"->{peligro=false}
            "ALTAPRECION","SOBRE_CALENTAMIENTO","PERDIDA_DE_GAS"->{peligro=true}
            else -> { peligro=null }
        }
        if (peligro!=null && peligro==true) println("APAGAR CALDERA, PROBLEMA:${estadoCaldera}")
        this.estadoCaldera=estadoCaldera
    }
}

fun main(){
    var listaEstados:MutableList<String> = mutableListOf(
        "NORMAL","ACETABLE","ALTAPRECION","SOBRE_CALENTAMIENTO","PERDIDA_DE_GAS"
    )
    var listaEstadosCaldera:MutableList<Caldera> = mutableListOf()
    for(i in 5..(10..15).random()){
        listaEstadosCaldera.add(Caldera(listaEstados.random()))
    }

    var aux=1
    for (i in listaEstadosCaldera){
        println("numero de estado=${aux} Estatus=${i.estadoCaldera}")
        aux++
    }
}

//Herencia Básica
//Crea una clase base Vehiculo y una clase derivada Bicicleta.
open class Vehiculo(numRuedas: Int = 0) {
    var numRuedas: Int = 0
    init {
        this.numRuedas = numRuedas
    }

}

class Bicicleta : Vehiculo {
   constructor(numRuedas: Int) : super(numRuedas)
}

fun main(){
  var bicicleta:Bicicleta = Bicicleta(2)
    println(bicicleta.numRuedas)
}

//Clase Abstracta
//Define una clase abstracta Forma y
//una clase concreta Circulo que herede de Forma.
abstract class Forma{
    var puntos:MutableList<Pair<Int,Int>> = mutableListOf()
    constructor(puntos:MutableList<Pair<Int,Int>> = mutableListOf()){
      this.puntos=puntos
    }
    abstract fun dibujar()
}

class Circulo(puntos:MutableList<Pair<Int,Int>>): Forma(puntos){
    override fun dibujar() {
        println("Dibujo:Circulo")
        puntos.let {
            println(it)
        }
    }
}

fun main(){
 var circulo:Circulo = Circulo(
     mutableListOf(
         Pair(10,12),
         Pair(11,13),
         Pair(12,14),
         Pair(13,15),
         Pair(14,16)
     )
 )
    circulo.dibujar()
}


//Interface Implementada
//Crea una interface Operable con un método operar.
//Implementa esta interface en la clase Calculadora.
interface Operable{
    fun operar()
}

class Calculadora : Operable{
    override fun operar() {
        println("Operando")
    }
}

fun main(){
   var calculadora:Calculadora=Calculadora()
    calculadora.operar()
}

Objeto con Array de Propiedades
Define una clase Almacen con un array de Producto.
class Producto(
    var nombre:String,
    var ID:String
)
class Almacen{
    var listaProducto:MutableList<Producto> = mutableListOf()
    init {
        listaProducto = mutableListOf()
    }
}
fun main(){
    var almacen:Almacen = Almacen()
    almacen.listaProducto.add(Producto("Arroz","DI-515632"))
    almacen.listaProducto.add(Producto("Frijol","DI-515732"))
    almacen.listaProducto.add(Producto("Papa","DI-515639"))
   for (it in almacen.listaProducto){
       println("${it.ID} ${it.nombre}")
   }
}

//Creación de Objeto dentro de Otro
//Dentro de Grupo, instancia un Estudiante directamente
//en su lista de estudiantes.
class Estudiante(
    var nombre:String="",
    var edad:Int=0
)
class Grupo{
    var listaAlumno:MutableList<Estudiante> = mutableListOf()
    constructor(){
        this.listaAlumno.add(Estudiante("Pedro",10))
    }
    constructor(listaAlumno:MutableList<Estudiante>){
        this.listaAlumno = listaAlumno
    }
}
fun main(){
    var grupo:Grupo = Grupo()
    for (it in grupo.listaAlumno){
        println("${it.nombre} ${it.edad}")
    }
}

//Enumeraciones en Clase
//Crea una enumeración EstadoPedido y úsala en la clase Pedido.
//nota : https://www.develou.com/clases-enum-en-kotlin/
enum class Estado{
    EstadoPerdido
}
class Pedido{
    constructor(estado: Estado){
        when(estado){
            Estado.EstadoPerdido -> println("Error en el envio del paquete ")
        }
    }
}
fun main(){
    var init:Pedido = Pedido(Estado.EstadoPerdido)
}

//Clase con Propiedad List Mutable
//Define Grupo con una lista mutable de
//Estudiante y métodos para añadir y remover estudiantes.
class Estudiante(
    var nombre:String="",
    var edad:Int=0
)
class Grupo{
    private var listaEstudiantes : MutableList<Estudiante> = mutableListOf()
    fun listaEstudiantesAdd(estudiante:Estudiante):Boolean{
        return this.listaEstudiantes.add(estudiante)
    }
    fun  listaEstudianteDelete(estudiante: Estudiante):Boolean{
        var index = this.listaEstudiantes.indexOf(estudiante)
        if(index>=0){
            this.listaEstudiantes.removeAt(index)
            return true
        }
        return false
    }
}
fun comentario(estatus:Boolean){
    println(if(estatus) "Accion completada con exito" else "Accion no completa")
}
fun main(){
    var grupo:Grupo = Grupo()
    var pedro = Estudiante("Pedro",10)
    comentario(grupo.listaEstudiantesAdd(pedro))
    comentario(grupo.listaEstudianteDelete(pedro))
    comentario(grupo.listaEstudianteDelete(pedro))
}


//Composición de Objetos
//Crea una clase Motor y úsala dentro de la clase Coche.
class Motor(val tipo:String){
   fun encender(){
       println("Inicio el motor tipo ${tipo}")
   }
    fun apager(){
        println("Se apago el motor tipo ${tipo}")
    }
}
class Coche(motor: Motor){
    val motor : Motor
    init{
        this.motor=motor
    }
    fun arrancar(){
        motor.encender()
        println("El coche esta arrancando")
    }
    fun apagar(){
        motor.apager()
        println("El coche esta apagado")
    }
}
fun main(){
    var coche = Coche(Motor("Roush 427 SRXE Crate Engines"))
    coche.arrancar()
    coche.apagar()
}

//Clase con Propiedad de Tipo Interface
//Crea una interface Notificable y
//una clase Alerta con una propiedad de tipo Notificable.
interface Notificable{
  fun notificar(mensaje:String)
}
//clase que implementa la interfaz
class EmailNotificar : Notificable{
    override fun notificar(mensaje: String) {
        println("Enviando el email:${mensaje}")
    }
}
//uso como parametro de tipo notificable
class Alerta(private val notificable: Notificable){
    fun enviarNotificacion(mensaje: String){
        notificable.notificar(mensaje)
    }
}
fun main(){
    val emailNotificar : EmailNotificar = EmailNotificar()
    val alerta : Alerta = Alerta(emailNotificar)
    alerta.enviarNotificacion("Ayuda el codigo exploto")
}

//Uso de with para Configurar Objeto
//Usa with para configurar un objeto Pedido recién creado.
class Pedido(
    var id:Int=0,
    var monto:Float=0.0F,
    var productos: MutableList<String> = mutableListOf()
){
    fun mostrar(){
        println("Mostrando productos del pedido")
        println(id)
        println(monto)
        for(it in productos) println(it)
    }
}
fun main(){
    var pedido:Pedido = Pedido()
    pedido.mostrar()
    with(pedido) {
        id=100
        monto=100F
        productos.add("CocaCola")
    }
    pedido.mostrar()
}

//Data Class
//Convierte la clase Libro en una data class y
//crea dos instancias para compararlas con ==.
data class Libro(
    var nombre:String="",
    var autor:String=""
)
fun main(){
    var libro1:Libro=Libro("X","X")
    var libro2:Libro=Libro("X","X")
    if(libro1 == libro2) println("Son iguales")
    else println("Son diferentes")
}

//Copiar Objeto con copy
//Usa el método copy de una data class
//para crear un objeto con algunas propiedades modificadas.
data class Persona(
    var nombre:String=""
)
fun main(){
    val luis:Persona=Persona("Luis")
    val clon:Persona=luis.copy("Clon Luis")
    println(luis.nombre)
    println(clon.nombre)
}



//Clase con lateinit
//note http://www.androidcurso.com/index.php/99-kotlin/926-inicializacion-de-propiedades-lateinit-vs-lazy
//Usa lateinit para una propiedad perfil en la clase Usuario,
//inicialízala después de la creación del objeto.
class Usuario{
    lateinit var perfil:String
    fun iniciarPerfil(){
        this.perfil="Hola"
    }
    fun mostrarPeril(){
        if(::perfil.isInitialized){
            println(this.perfil)
        }else{
            println("Inicializa el perfil")
        }
    }
}
fun main(){
    val usuario:Usuario = Usuario()
    usuario.mostrarPeril()
    usuario.iniciarPerfil()
    usuario.mostrarPeril()
}

Clase con Propiedades Calculadas
//note:https://medium.com/@joseortizfuenzalida/patrones-de-diseño-en-kotlin-3c51b61c733f
Añade una propiedad calculada descripcionCompleta a
 Libro que combine titulo y autor.
 class Libro(val titulo:String,val autor:String){
    val descripcionCompleta:String
        get() = "$titulo - $autor"
}
fun main(){
    var libro:Libro = Libro("X","Y")
    println("el libro ${libro.descripcionCompleta}")
}

//bjeto con lazy Initialization 
//Usa lazy para inicializar una propiedad configuracion
//en ConfiguracionGlobal solo cuando sea necesario.
class ConfiguracionGlobal {
    val configuracion: String by lazy {
        // Simulación de una operación costosa para inicializar la configuración
        println("Inicializando configuración...")
        "Configuración inicializada"
    }
}

fun main() {
    val global = ConfiguracionGlobal()

    // La propiedad configuracion no se inicializará hasta que se acceda a ella
    println("Propiedad configuracion no inicializada todavía")

    // Acceder a la propiedad configuracion por primera vez
    println("Configuración: ${global.configuracion}")

    // La próxima vez que se acceda a la propiedad configuracion, ya estará inicializada
    println("Configuración: ${global.configuracion}")
}


//Extensión de Funciones para Clases Existentes
//Crea una función de extensión imprimirInformacion para Persona.
//Nota:https://kotlinlang.org/docs/extensions.html#extensions-are-resolved-statically
class Persona(val nombre: String, val edad: Int)
// Función de extensión para imprimir información de Persona
fun Persona.imprimirInformacion() {
    println("Nombre: $nombre, Edad: $edad")
}

fun main() {
    val persona = Persona("Juan", 30)
    persona.imprimirInformacion()
}

//Creación de Clase Anidada
//Dentro de Bodega, crea una clase anidada Ubicacion
//que represente la ubicación de un producto.
class Bodega {
    // Clase anidada Ubicacion
    class Ubicacion(val pasillo: Int, val estante: Int) {
        override fun toString(): String {
            return "Pasillo: $pasillo, Estante: $estante"
        }
    }
}

fun main() {
    // Crear una instancia de Ubicacion y usarla
    val ubicacionProducto = Bodega.Ubicacion(2, 3)
    println("Ubicación del producto: $ubicacionProducto")
}

//Clase Interna que Accede a Propiedades Externas
//Haz que Ubicacion en Bodega sea una clase interna
//que pueda acceder a las propiedades de Bodega.
//Note:https://www.geeksforgeeks.org/kotlin-nested-class-and-inner-class/
class Bodega {
    // Clase interna Ubicacion
    inner class Ubicacion(val pasillo: Int, val estante: Int) {
        fun mostrarUbicacion() {
            println("Pasillo: $pasillo, Estante: $estante, Bodega: ${this@Bodega.nombre}")
        }
    }

    val nombre = "Bodega principal"
}

fun main() {
    // Crear una instancia de Bodega
    val bodega = Bodega()

    // Crear una instancia de Ubicacion y acceder a las propiedades de Bodega
    val ubicacionProducto = bodega.Ubicacion(2, 3)
    ubicacionProducto.mostrarUbicacion()
}

//Sobrecarga de Operadores
//Sobrecarga el operador + en
//Calculadora para sumar dos objetos Calculadora.
//Nota:https://kotlinlang.org/docs/operator-overloading.html#binary-operations
class Calculadora(var valor: Int) {
    operator fun plus(other: Calculadora): Calculadora {
        return Calculadora(this.valor + other.valor)
    }
}

fun main() {
    val calculadora1 = Calculadora(5)
    val calculadora2 = Calculadora(10)

    val resultado = calculadora1 + calculadora2
    println("Resultado de la suma: ${resultado.valor}")
}


//Delegación de Propiedad
//Usa la delegación de propiedad by lazy
//para una propiedad datos en Usuario.
class Usuario {
    val datos: Datos by lazy {
        println("Inicializando datos...")
        Datos("John Doe", 30)
    }
}

data class Datos(val nombre: String, val edad: Int)

fun main() {
    val usuario = Usuario()

    // La propiedad datos no se inicializará hasta que se acceda a ella
    println("Propiedad datos no inicializada todavía")

    // Acceder a la propiedad datos por primera vez
    println("Datos del usuario: ${usuario.datos}")

    // La próxima vez que se acceda a la propiedad datos, ya estará inicializada
    println("Datos del usuario: ${usuario.datos}")
}
 
//Retorno Simple
//Escribe una función que retorne un número entero.
fun numeroEntero():Int{
    return (0..100).random()
}

//Función sin return Explícito
//Crea una función que sume dos números y retorne
// el resultado sin usar la palabra clave return.
fun suma(a:Float,b:Float) = a + b

//Retorno de un Booleano
//Desarrolla una función que compare dos números y
// retorne true si el primero es mayor que el segundo.
fun comparacion(a:Int,b:Int):Boolean{
    return if(a>b) true else false
}

//Función con Retorno Unit
//Implementa una función que imprima "Hola Mundo"
// y no retorne ningún valor (Unit).
fun imprimir(mensaje:String):Unit{
    println("${mensaje}")
}

//Retorno de una Cadena
//Escribe una función que acepte un
// nombre y retorne un saludo personalizado.
fun saludoPersonalisado(mensaje:String):String{
    return "Hola un gusto saludarte,${mensaje}"
}

//Función que Retorna un Objeto
//Crea una clase Persona y una función que retorne un objeto Persona.
data class Pesona(
    var nombre:String=""
)
fun modificarNombre(nuevoNombre: String,pesona: Pesona):Pesona{
    pesona.nombre=nuevoNombre
    return pesona
}

//Retorno de una Lista
//Desarrolla una función que retorne una lista de strings.
fun returnLista():List<String>{
    return listOf(
        "Pedro","luis","Maria","Luisa","Agela"
    )
}

//Uso de return en Bloques de Código
//Implementa una función que use if para
// retornar diferentes valores basados en una condición.
fun estatus(valor:Int):String{
    return if(valor==1) "BIEN" else if(valor==2) "MAL" else "APAGAR"
}

//Función con Ciclo y return
//Escribe una función que itere sobre una lista y retorne
// inmediatamente cuando encuentre un elemento específico.
fun retornarItem(lista: List<String>,cadena:String):String{
    for (it in lista) if(it == cadena) return it
    return ""
}

//Retorno desde una Función Anónima
//Crea una función que retorne el resultado de una
// función anónima que sume dos números.
fun retornarValorAnonimo(): Int{
   val sumar = fun (a:Int,b:Int):Int=a+b
    return sumar(10,20)
}
//Retorno de una Función Lambda
//Implementa una función que retorne el resultado
// de una lambda que multiplica dos números.
fun retornarLambda():Int{
    val multiplicar = {a:Int,b:Int -> a * b}
    return multiplicar(10,20)
}

//Función con Retorno Explícito de null
//Escribe una función que pueda retornar un Int?
// y que retorne null bajo ciertas condiciones.
fun returnNullInt(a:Int):Int?{
    return if (a==10) null else 1
}

//Retorno de una Expresión when
//Desarrolla una función que use when para
// retornar diferentes valores basados en el input.
fun returnWhen(a: Int):String{
    when(a){
        in 1..100 ->   return  "A"
        in 200..300 -> return  "B"
        in 400..500 -> return  "C"
        else -> return "K"
    }
}

//Diferencia entre println y return
//Crea dos funciones, una que imprima un valor y
// otra que retorne un valor,
// y observa la diferencia al usarlas.
fun mostrarValor(a:Int){println("El valor es: ${a}")}
fun retornarValor():Int=(1..500).random()
//R:mostrar el valor retorina un valor Unit y mientras retornar valor
//guarda una direccion de memoria y la retorna a una variable del mismo tipo

//Función con return en Expresión Lambda
//Implementa una función que tome una lambda
// como parámetro y retorne su resultado.
fun parametroLambda(a:Int,b:Int, lambda:(a:Int,b:Int)->Int):Int=lambda(a,b)

//Retorno Condicionado con Operador Ternario
//Simula un operador ternario dentro de una
//función para retornar dos posibles valores.
fun simulacionOperadorTernario(a:Int,b:Int):String=if(a>b)"A mayor a b" else if(a<b) "B mayor de a" else "Son iguales"

//Función que Retorna una Función
//Escribe una función que retorne otra función
// que a su vez retorne un valor.
fun retornarFuncionRetornarValor():()->Int={->10}

//Uso de return en try-catch
//Implementa una función que use try-catch
//y retorne un valor tanto en el bloque try como en catch.
fun validarEntraDatos():Pair<String,Int>{
    try {
        println("Ingrese un numero:")
        var entrada= readln()
        var valor=entrada.toInt()
        return Pair("Correcta_Carga",valor)
    }catch (e:Exception){
        return  Pair("Error:${e.message}",-1)
    }
}

//Retorno de Tipo Any
//Crea una función que pueda retornar cualquier tipo de dato.
fun validarTipo():Any{
    var list:List<Any> = listOf(
        {->10},
        Triple(listOf(Unit),null,{a:Any,b:Any->a}),
        "Hola mundo",
        10,
        10F,
        0xFFFF_FFFF_FFFFu,
        ubyteArrayOf(0xEFu, 0xBBu, 0xBFu),
        Unit
    )
    return list.random()
}

//Función con Parámetro por Defecto y return
//Escribe una función que acepte un parámetro con
// valor por defecto y retorne un valor basado en este.
fun valorPorDefecto(v:Int=0):Int = v + 1

//Retorno de un Map
//Desarrolla una función que retorne un Map de tipo <String, Int>.
fun retornarMap():Map<String,Int> = mutableMapOf(
    "A" to 100,
    "B" to 200
)

//Función Recursiva con return
//Implementa una función recursiva
// que calcule el factorial de un número.
fun factorial(a: Int):Int = if(a==0)  1 else  factorial(a - 1) * a

//Función con return en Bloque de forEach
//Escribe una función que itere sobre una lista
// con forEach y use return para salir prematuramente.
fun returnForEach(lista:List<String>,item:String):String{
    lista.forEach{
        if(it==item) return "Error"
    }
    return "Bien"
}

//Función con Generics que Retorna un Tipo Específico
//Crea una función genérica que acepte un parámetro de cualquier tipo
// y retorne un valor específico de ese tipo.
fun <T> retonarValorEspecifico(valor: T):T=valor

//Función que Usa return para Filtrar Lista
//Desarrolla una función que filtre una lista de números
// y retorne solo aquellos que cumplen con una condición específica.
fun filtrarNumeros(listaNumeros:List<Int>,condicion:(Int)->Boolean):List<Int>{
     return listaNumeros.filter {
         return@filter  if (condicion(it)) true else false
     }
}

//Función con Retorno de Una Tupla
//Escribe una función que retorne una
// Pair o Triple con diferentes tipos de datos.
fun retornarTupla():Triple<Any,Any?,Any> = Triple(listOf(Unit),null,{a:Any,b:Any->a})

//Función con Retorno de Unit por Default
//Implementa una función que haga un trabajo específico
// pero no retorne nada, demostrando el uso implícito de Unit.
fun holaMundo():Unit{
    println("Hola Mundo :V")
}

//Retorno de un Array
//Desarrolla una función que cree y retorne un array de enteros
fun crearArray():Array<Int> = Array((1..10).random()){i -> i * 10}

//Diferenciando return en Bloques Lambda
//Explica y demuestra cómo el uso de return en un bloque
// lambda puede afectar el flujo de una función anónima o lambda.
fun flujo(a:String){
    println("caso ${a}")
    var lista:List<Int> = listOf(1,2,3,4,5)
    if(a=="C1"){
        lista.forEach {
            if(it == 5 ) return
        }
        println("Saludo de flujo C1")
    }
    if(a == "C2"){
        lista.forEach {
            if(it == 5 ) return@forEach
        }
        println("Saludo de flujo C2")
    } else{
        lista.forEach {
            if(it == 5 ) return@flujo
        }
        println("Saludo de flujo CN")
    }
    println("Saludo de flujo")
    return
}
//Salida:
//caso C1
//caso C2
//Saludo de flujo C2
//Saludo de flujo
//caso CN
//Nota:como podemos ver al ejecutar C1 C2 CN
//se presentan diferentes flujos:
//C1 sale de todas las funciones
//C2 sale solo del forEach
//CN sale de la funcion superio, por ende se termina el forEach
//Concluccion: se tiene que tener cuidado al salir de la lambda
//ya que si no le danmos un limite de contexto puede cerrar todo
//el bloque de codigo

fun main(){
    println(numeroEntero())
    println(suma(10F,10F))
    println(comparacion(10,20))
    imprimir("Hola Mundo")
    println(saludoPersonalisado("Pedro"))
    println(modificarNombre("Pedro",Pesona("Luis")))
    println(returnLista())
    println(listOf( estatus(1),estatus(2),estatus(3)))
    println(retornarItem(listOf("Manuel","Luis"),"Laura"))
    println(retornarItem(listOf("Manuel","Luis"),"Luis"))
    println(retornarValorAnonimo())
    println(retornarLambda())
    println(returnNullInt(1))
    println(returnNullInt(10))
    println(returnWhen(153))
    println(parametroLambda(10,10,{a:Int,b:Int -> (a+b)/10}))
    println(simulacionOperadorTernario(10,10))
    println(retornarFuncionRetornarValor()())
    println(validarEntraDatos())
    println(validarTipo())
    println(valorPorDefecto())
    println(retornarMap())
    println(factorial(5))
    println(retornarItem(listOf("Hola","Adios"),"Hola"))
    println(retonarValorEspecifico(25))
    println(retonarValorEspecifico("String"))
    println(filtrarNumeros(listOf(1,52,16,20,24),{a:Int->a%10==0}))
    println(filtrarNumeros(listOf(1,52,16,20,24),{a:Int->a>10}))
    println(retornarTupla())
    holaMundo()
    println(crearArray())
    flujo("C1")
    flujo("C2")
    flujo("CN")
}
*/