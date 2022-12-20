package 2022.food

import scala.collection.immutable.List

case class ElfFoodWithTotalCalories protected(elfId:String, foodCalories: List[ElfFood], totalCalories: ElfFood)

case object ElfFoodWithTotalCalories:
  def apply(foodCalories: List[ElfFood]): List[ElfFoodWithTotalCalories]=
    foodCalories match
      case List() => List.empty[ElfFoodWithTotalCalories]
      case head :: tail =>
        val sameElfFood = tail.filter(_.doesItBelongToElf(head))
        val totalCalories = sameElfFood.foldLeft(head)(_.sumCalories(_))
        ElfFoodWithTotalCalories(head.elfId, sameElfFood, totalCalories) :: ElfFoodWithTotalCalories.apply(tail.filterNot(_.doesItBelongToElf(head)))
