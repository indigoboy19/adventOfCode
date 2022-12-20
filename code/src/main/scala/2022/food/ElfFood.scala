package 2022.food

import scala.collection.immutable.List

case class ElfFood(elfId:String, food: Food):
  def doesItBelongToElf(elfFood:ElfFood): Boolean = elfFood.elfId == elfId
  def sumCalories(elfFood: ElfFood): ElfFood = this.copy(food = elfFood.food.sumCalories(food))

case object ElfFood:
  def apply(lines: List[String]): Option[List[ElfFood]] =
    helperMethod(0, lines)

  private def helperMethod(id:Int, lines:List[String]): Option[List[ElfFood]] =
    lines match
      case List() => Some(List.empty[ElfFood])
      case head :: tail =>
        val optionInt = head.toIntOption
        optionInt match 
          case None =>
            head match
              case "" => helperMethod(id + 1, lines)
              case _ => None
          case Some(calories) =>
            val option = helperMethod(id, tail)
            option match
              case None => None
              case Some(list) => Some(ElfFood(id.toString, Food(calories)) :: list)