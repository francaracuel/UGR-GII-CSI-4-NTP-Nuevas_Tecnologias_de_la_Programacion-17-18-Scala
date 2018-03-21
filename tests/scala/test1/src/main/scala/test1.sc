var i=10

while(i > 0){
	println("Valor de i: "+i)
	i -= 1
}

i = 5

do{
	println("Valor de i: "+i)
	i -= 1
} while(i >= 0)

val x = 1 to 10
val y = 1 until 10
val z = 1 to 10 by 2
val h = 10 to 1 by -2

for(i <- 1 to 10 by 4) yield i
	println("Valor de i: "+i)

for(i <- 1 to 10 by 4;
	j <- 1 to 10 by 4) yield (i, j)

for{i <- 1 to 10
	j <- 1 to 10} yield (i, j)