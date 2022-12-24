package `2022`.domain.model

import scala.collection.immutable.List

case class ElfTotalCalories(elfId:String, foodCalories: List[ElfFood], totalCalories: ElfFood)