package udemy

object PartialFunctions extends App {

  val aFunction = (x: Int) => x + 1
  val aFussyFunction = (x: Int) =>
    if (x == 1) 42
    else if (x == 2) 56
    else if (x == 5) 999
    else throw new RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  }

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 5 => 999
  }

  println(aPartialFunction(2))
  // println(aPartialFunction(589659)) --> throws match error

  // utils
  println(aPartialFunction.isDefinedAt(67))

  // lift into option
  val lifted = aPartialFunction.lift
  println(lifted(2))
  println(lifted(98))

  // Partial functions extend normal functions
  val aNormalFunction: Int => Int = {
    case 1 => 999
  }

  // HOFs accept partial functions as well
  val aMappedList = List(1,2,3,5).map {
    case 1 => 42
    case 2 => 56
    case 5 => 999
    case _ => 50
  }

  println(aMappedList)
  
}
