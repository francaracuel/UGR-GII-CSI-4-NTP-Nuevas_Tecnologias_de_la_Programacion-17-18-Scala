val lista=List(1, 2, 3)

val lista2=List(4, 5)

val lista3 = lista ::: lista2

val lista4 = 0 :: lista

val mayor2 = lista3.count(v => v > 2)

val mayor3 = lista3.count(_ > 3)

lista.drop(2)
lista.dropRight(2)

lista.length