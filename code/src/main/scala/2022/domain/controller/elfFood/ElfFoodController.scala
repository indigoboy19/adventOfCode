package `2022`.domain.controller.elfFood

import  `2022`.domain.model.ElfFood
import  `2022`.domain.model.ElfTotalCalories
import `2022`.domain.repository.elfFood.ElfFoodRepository
import `2022`.ElfCamp


case class ElfFoodController(elfCamp: ElfCamp, elfFoodRepository: ElfFoodRepository):
    def myFunction: ElfTotalCalories =
        val elvesFood = elfFoodRepository.elvesFood
        val elvesTotalCalories = elfCamp.calculateElvesTotalCalories(elvesFood)
        elfCamp.elfWithMostCalories(elvesTotalCalories)