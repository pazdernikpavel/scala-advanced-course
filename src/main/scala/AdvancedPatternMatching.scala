package udemy

object AdvancedPatternMatching extends App {

  val numbers = List(1)
  val description = numbers match {
    case head :: Nil => println(s"the only element is $head")
    case _ =>
  }

  /*
 
    - constants
    - wildcards
    - case classes
    - tuples
    - some special magic like above
    - own patterns

   */

  class Person(val name: String, val age: Int)

  object Person {
    def unapply(person: Person): Option[(String, Int)] = 
      if (person.age < 21) None
      else Some((person.name, person.age))
    
    def unapply(age: Int): Option[String] = 
      Some(if (age < 21) "minor" else "major")
  }

  val bob = new Person("Bob", 35)
  val greeting = bob match {
    case Person(name, age) => s"Hi, my name is $name and I am $age y.o."
  }

  println(greeting)

  val legalStatus = bob.age match {
    case Person(status) => s"My legal status is $status"
  }

  println(legalStatus)

  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }

  object singleDigit {
    def unapply(arg: Int): Boolean = arg > - 10 && arg < 10
  }

  val number: Int = 8
  val mathProperty = number match {
    case singleDigit() => "single digit"
    case even() => "an even number"
    case _ => "no property"
  }
  
  println(mathProperty)
  
}
