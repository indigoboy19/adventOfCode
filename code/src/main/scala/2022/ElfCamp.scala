package `2022`

import  `2022`.domain.model.ElfFood
import  `2022`.domain.model.ElfTotalCalories

case class ElfCamp():
    def calculateElvesTotalCalories(elvesFood: List[ElfFood]): List[ElfTotalCalories] =
        elvesFood match
            case List() => List.empty[ElfTotalCalories]
            case head :: tail =>
                val sameElfFood = tail.filter(_.doesItBelongToElf(head))
                val differentElfFood = tail.filterNot(_.doesItBelongToElf(head))
                val totalCalories = sameElfFood.foldLeft(head)(_.sumCalories(_))
                ElfTotalCalories(head.elfId, sameElfFood, totalCalories) :: calculateElvesTotalCalories(differentElfFood)

    def elfWithMostCalories(totalElfFoodCalories: List[ElfTotalCalories]): ElfTotalCalories =
        totalElfFoodCalories.maxBy(_.totalCalories.food.calories)
