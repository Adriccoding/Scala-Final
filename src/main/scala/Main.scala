import util.control.Breaks._

object Main {
  def main(args: Array[String]): Unit = {

    var i = 1

    while (i != 4) {

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
        case 2 => update()
        case 3 => DHW()
        case 4 =>
        case _ => println("enter a valid number")
      }
    }
  }

  val arr = Array.ofDim[String](20,4)

  def add(a: String, b: String, c:String, d:Boolean) ={
    arr(0)(0) = a
    arr(0)(1) = b
    arr(0)(2) = c
    arr(0)(3) = d.toString
  } //polymorphic function

  def update():Unit ={
    println("Here are incompete assignments")
    for (i <- 0 to arr.length -1){
      if(arr(i)(3).toBoolean == false){
        println(arr(i)(0))
      }
    }
  }

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

}