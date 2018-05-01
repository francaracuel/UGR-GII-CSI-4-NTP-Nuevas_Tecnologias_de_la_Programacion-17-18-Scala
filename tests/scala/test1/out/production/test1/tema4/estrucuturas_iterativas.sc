val x = 1 to 6

val y = 1 to 6 by 2

val z = 10 until 1 by -2

for(x <- 1 to 7) println(x)

for(x <- 1 to 7) yield {
	println(x)
	x
}

(1 to 7).map(x => {
	println(x)
	x
})

val mult3 = for(i <- 1 to 50 if i%3 == 0) yield i

val archivos = (new java.io.File(".")).listFiles

for(archivo <- archivos;
	if archivo.isFile;
	if archivo.getName.contains("s")) yield archivo

for{x <- 1 to 10
	y <- 2 until 8} yield
	{println(x + "- " + y)
		(x, y)}
