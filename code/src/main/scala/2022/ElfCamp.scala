package `2022`

import  `2022`.domain.model.ElfFood
import  `2022`.domain.model.ElfFoodWithTotalCalories

case class ElfCamp():
    def calculateElvesTotalCalories(elvesFood: List[ElfFood]): List[ElfFoodWithTotalCalories] =
        elvesFood match
            case List() => List.empty[ElfFoodWithTotalCalories]
            case head :: tail =>
                val sameElfFood = tail.filter(_.doesItBelongToElf(head))
                val differentElfFood = tail.filterNot(_.doesItBelongToElf(head))
                val totalCalories = sameElfFood.foldLeft(head)(_.sumCalories(_))
                ElfFoodWithTotalCalories(head.elfId, sameElfFood, totalCalories) :: calculateElvesTotalCalories(differentElfFood)