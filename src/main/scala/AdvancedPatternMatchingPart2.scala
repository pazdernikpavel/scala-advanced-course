package udemy

object AdvancedPatternMatchingPart2 extends App {

  // Infix patterns
  case class Or[A, B](a: A, b: B)
  val either = Or(2, "two")

  val humanDescription = either match {
    case number Or string => s"$number is written as $string"
  }

  println(humanDescription)
   
  // Decomposing sequences
  val list = List(1,2,3,4,5)
  val vararg = list match {
    case List(1, 2, _*) => "starting with 1 and 2"
  }
}
