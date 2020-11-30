import util.control.Breaks._

object Main {

  def main(args: Array[String]): Unit = {

    var i = 1
    var firstname = ""
    var lastname = ""

    println("Welcome to homework tracker. Please enter your first name")
    firstname = scala.io.StdIn.readLine()

    println("Now your last name")
    lastname = scala.io.StdIn.readLine()

    while (i != 4) {

      println("welcome " + printGPA(firstname) (lastname))

      println("Select an option \n 1. Add assignments \n 2. update assignments \n 3. displays assignments \n 4. Exit")
      i = scala.io.StdIn.readInt()

      val display = i match {
        case 1 => {

          println("Enter Homework assigment name")
          var assignmentName = scala.io.StdIn.readLine()

          println("Enter Homework assigment due date")
          var assignmentDueDate = scala.io.StdIn.readLine()

          println("Enter Homework assigment class")
          var assignmentClass = scala.io.StdIn.readLine()

          add(assignmentName, assignmentDueDate, assignmentClass, false)
        }
        case 2 => update(incompleteHW())
        case 3 => DHW()
        case 4 =>
        case _ => println("enter a valid number")
      }
    }
  }

  val arr = Array.ofDim[String](20,4)

  var t = 0

  def printGPA[A,B](a: A)(b: A):IndexedSeq[Char] = "Name: "+(a.toString) + " " +(b.toString) //curried function

  def add(a: String, b: String, c:String, d:Boolean) ={
    arr(t)(0) = a
    arr(t)(1) = b
    arr(t)(2) = c
    arr(t)(3) = d.toString
    t = t + 1
  } //polymorphic function

  def update(a: Unit ):Unit ={
    var i = 1
    println("enter the number of the completed assignment")
    i = scala.io.StdIn.readInt()
    arr(i)(3) = "true"
  } //higher order function

  def DHW():Unit ={

    breakable {
      for (i <- 0 to arr.length - 1) {
        if (arr(i)(0) == null) break
        for (j <- 0 to arr.length - 1) {
          if (j == 0) {
            println("Assigment name: " + arr(i)(j))
          }
          if (j == 1) {
            println("Assigment due date: " + arr(i)(j))
          }
          if (j == 2) {
            println("Assigment class: " + arr(i)(j))
          }
          if (j == 3){
            println("Assignmet Status: " + arr(i)(j))
          }
        }
        println()
      }
    }
  } //pure function

  def incompleteHW():Unit ={
    println("Here are the incompete assignments")
    for (i <- 0 to arr.length - 1){
      if(arr(i)(3) == "false"){
        println(i + " " + arr(i)(0))
      }
    }
  }
}