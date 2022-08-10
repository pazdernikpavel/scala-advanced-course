package udemy

import scala.util.Try

object SyntaxSugars extends App {

  // Syntax sugar #1
  // Methods with single param

  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val result1 = singleArgMethod {
    // write some logic
    // return value passed to the function
    42
  }

  val aTry = Try {
    throw new RuntimeException 
  }

  List(1,2,3).map { x => 
    x + 1    
  }

  // Syntax sugar #2
  // Single abstract method

  trait Action {
    def Act(x: Int): Int
  }

  val aInstance: Action = (x: Int) => x + 1 // magic

  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello, scala")
  })

  val aSweeterThread = new Thread(() => println("sweet, Scala!"))

  abstract class AnAbstractType {
    def implemented: Int = 25
    def f(a: Int): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")

  // Syntax sugar #3
  // :: and #:: methods

  val prependedList = 2 :: List(3, 4)
  // List(3,4).::(2)
  1 :: 2 :: 3 :: List(4,5)
  // List(4,5).::(3).::(2).::(1)

  class MyStream[T] {
    def -->: (value: T): MyStream[T] = this
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // Syntax sugar #4
  // multiword method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl(name = "Lilly")
  lilly `and then said` "Scala is so sweet!"

  // Syntax sugar #5
  // infix types

  class Composite[A, B]
  val composite: Composite[Int, String] = ???  
  val compositeInfix: Int Composite String = ???  // equals

  class -->[A, B]
  val towards: Int --> String = ???

  // Syntax sugar #6
  // update() is very special, much like apply()

  val arrayA = Array(1,2,3)
  arrayA(2) = 7 // --> arrayA.update(2, 7)
  // usable in mutable collections

  // Syntax sugar #7
  // setters for mutable collections

  class Mutable {
    private var internalMember: Int = 0
    def member = internalMember
    def member_: (value: Int): Unit = 
      internalMember = value
  }

  // val mutableContainer = new Mutable
  // mutableContainer.member = 42
  // rewritten to mutableContainer.member_ = 42

}
