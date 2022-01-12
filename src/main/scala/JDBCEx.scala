import java.sql.DriverManager
import java.sql.Connection
import java.util.Scanner
import java.io.PrintWriter
import java.io.File
import java.util.Calendar

/**
 * A Scala JDBC connection example by Alvin Alexander,
 * https://alvinalexander.com
 */
object JDBCEx {

  var sc = new Scanner(System.in);

// connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/juba" 
    val username = "Dody"
    val password = "Alook5@tata*" 
    val log = new PrintWriter(new File("query.log"))
  
    var connection:Connection = null

    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

    val statement = connection.createStatement()
    val statement2 = connection.createStatement()
    val statement3 = connection.createStatement()
    val statement4 = connection.createStatement()
    val statement5 = connection.createStatement()
    val statement6 = connection.createStatement()
    val statement7 = connection.createStatement()
    val statement8 = connection.createStatement()
    val statement9 = connection.createStatement()
    val statement0 = connection.createStatement()
    val statement11 = connection.createStatement()
    
  def main(args: Array[String]):Unit = {

     println("Enter 1 for Update, 2 for Delete, 3 for Read or 4 fro Insert")
      var choice = sc.nextLine().trim().toInt

      var endProgram = false

      while (!endProgram){
          choice match {
          case 1 => problem1() 
          
          case 2 => problem2()
          
          case 3 => problem3()
          
          case 4 => problem4()
          
          case 5 =>
            endProgram = true
          }    
      
         println("Enter 1 for Update, 2 for Delete, 3 for Read or 4 for Insert")
        choice = sc.nextLine().trim().toInt     
        }
    
////////////////////////////////////Update/////////////////////
  def problem1():Any={ 
    try {
     println("Enter Instractor Id: ")
     val instrId = sc.nextLine().trim().toInt

      println("Enter Student name: ")
     val stuName = sc.nextLine()

     println("Enter Semester term: ")
     val semester = sc.nextLine()

     println("Enter Year: ")
     val year = sc.nextLine().trim().toInt

     println("Enter Student final scores: ")
     val finSc = sc.nextLine() 
    
statement.executeUpdate( "INSERT INTO scores(instrId, stuName, semester, year, finSc)"+" VALUES("+instrId+",'"+stuName+"','"+semester+"',"+year+",'"+finSc+"')")
  val resultSet =statement.executeQuery("SELECT * FROM scores WHERE stuName = '"+stuName+"';")
  
        while ( resultSet.next()) { 
      print("--------------------------------------")
      print(resultSet.getString(1) +" "+  resultSet.getString(2) +" "+ resultSet.getString(3) +" "+ resultSet.getString(4) +" "+
      resultSet.getString(5)) 
      println("--------------------------------------")   
      println() 
         }      

    }catch {
      case e: Exception => {e.printStackTrace
        e.printStackTrace
          log.write("Error!"+ e.getMessage())
      }
   
    } 
} 
  
///////////////////////////DELETE////////////////////////////////////

def problem2():Any={ 
    try {
     println("Enter Student name: ")
     val stuName = sc.nextLine()

    val set2 ="DELETE FROM scores WHERE stuName='"+stuName+ "'"
     val resultSet =statement.executeUpdate(set2)

     if(resultSet >0){
       println("Deleted Successfully")
     } 
    }catch {
      case e: Exception => e.printStackTrace
    }
}
 
//////////////////////////READ///////////////////////////////////////
def problem3():Any={ 
    try {

  println("Enter Student Id: ")
     val stuId = sc.nextLine().trim().toInt
     val statement20 = connection.createStatement()
  val set3="SELECT stuName, semester, year, finSc FROM scores WHERE stuId ="+stuId+";" 
      val resultSet =statement20.executeQuery(set3)

      while ( resultSet.next()) { 
      println("--------------------------------------")
      println(resultSet.getString(1) +" final score for "+  resultSet. getString(2) +" "+ resultSet.getString(3) +" is "+  resultSet.getString(4)) 
      println("--------------------------------------")   
      println() 
    }  
    }catch {
      case e: Exception => e.printStackTrace
    }
    
  }

////////////////////////////////////Insert//////////////////////////////
def problem4():Any={
  try{
     println("Enter Instractor Id: ")
     val instrId = sc.nextLine().trim().toInt

     println("Enter Student name: ")
     val stuName = sc.nextLine()

     println("Enter Semester term: ")
     val semester = sc.nextLine()

     println("Enter Year: ")
     val year = sc.nextLine().trim().toInt

     println("Enter Student final scores: ")
     val finSc = sc.nextLine() 

       val set4 = "INSERT INTO scores(instrId, stuName, semester, year, finSc)"+" VALUES("+instrId+",'"+stuName+"','"+semester+"',"+year+",'"+finSc+"')"

  val resultSet =statement.executeUpdate(set4)
  
   if(resultSet >0){
       println("Inserted Successfully")
     } 
    }catch {
      case e: Exception => e.printStackTrace
    }
  }
 }
}
