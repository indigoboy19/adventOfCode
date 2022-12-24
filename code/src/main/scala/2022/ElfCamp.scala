package `2022`

import  `2022`.domain.model.ElfFood
import  `2022`.domain.model.ElfMaxCalories

case class ElfCamp():
    def calculateElvesMaxCalories(elvesFood: List[ElfFood]): List[ElfMaxCalories] =
        elvesFood match
            case List() => List.empty[ElfMaxCalories]
            case head :: tail =>
                val sameElfFood = tail.filter(_.doesItBelongToElf(head))
                val differentElfFood = tail.filterNot(_.doesItBelongToElf(head))
                val totalCalories = sameElfFood.foldLeft(head)(_.sumCalories(_))
                ElfMaxCalories(head.elfId, totalCalories.food.calories) :: calculateElvesMaxCalories(differentElfFood)

    def elfWithMostCalories(totalElfFoodCalories: List[ElfMaxCalories]): ElfMaxCalories =
        totalElfFoodCalories.maxBy(_.calories)
