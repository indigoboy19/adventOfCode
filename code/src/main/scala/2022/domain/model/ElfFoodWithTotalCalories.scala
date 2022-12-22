package `2022`.domain.model

import scala.collection.immutable.List

case class ElfFoodWithTotalCalories(elfId:String, foodCalories: List[ElfFood], totalCalories: ElfFood)