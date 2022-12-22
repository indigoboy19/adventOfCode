package `2022`.domain.repository

import  `2022`.domain.model.ElfFood
import  `2022`.domain.value.Food

import scala.io.Source

case class ElfFoodRepositoryFromFile(elvesFood: List[ElfFood]) extends  ElfFoodRepository

case object ElfFoodRepositoryFromFile:
  def apply(pathToFile: String): Option[ElfFoodRepositoryFromFile] =
    val saved_file = Source.fromFile(pathToFile)
    val linesOfElfFood = saved_file.getLines.toList
    helperMethod(0, linesOfElfFood).map(ElfFoodRepositoryFromFile(_))

  private def helperMethod(id:Int, lines:List[String]): Option[List[ElfFood]] =
    lines match
      case List() => Some(List.empty[ElfFood])
      case head :: tail =>
        val optionInt = head.toIntOption
        optionInt match 
          case None =>
            head match
              case "" => helperMethod(id + 1, lines.tail)
              case _ => None
          case Some(calories) =>
            val option = helperMethod(id, tail)
            option match
              case None => None
              case Some(list) => Some(ElfFood(id.toString, Food(calories)) :: list)