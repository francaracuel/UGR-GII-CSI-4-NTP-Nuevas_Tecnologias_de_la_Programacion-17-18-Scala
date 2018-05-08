class Multiplicador(val factor: Int) {
	def apply(valor: Int): Int = factor * valor
}

object Multiplicador{
	def apply(factor: Int): Multiplicador = {
		new Multiplicador(factor)
	}
}

object ejemploApply extends App{

	/// ....

}