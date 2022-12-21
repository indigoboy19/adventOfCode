package `2022`

import `2022`.food.ElfFood
import `2022`.food.ElfFoodWithTotalCalories

import scala.io.Source

case object Main:

    @main def hello() =
        // val saved_file = Source.fromFile("src/main/scala/resources/doubleElf")
        val saved_file = Source.fromFile("src/main/scala/resources/singleElf")
        val linesOfEntities = saved_file.getLines.toList
        val elfFood = 
            ElfFood(linesOfEntities)
                .map(ElfFoodWithTotalCalories(_))
                .map(_.maxBy(_.totalCalories.food.calories))
                .map(_.totalCalories.food.calories)
        println(s"$elfFood")