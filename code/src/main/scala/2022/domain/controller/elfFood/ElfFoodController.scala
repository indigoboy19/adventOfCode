package `2022`.domain.controller.elfFood

import  `2022`.domain.model.ElfMaxCalories
import `2022`.domain.repository.elfFood.ElfFoodRepository
import `2022`.ElfCamp


case class ElfFoodController(elfCamp: ElfCamp, elfFoodRepository: ElfFoodRepository):
    def getElfMaxCalories: ElfMaxCalories =
        val elvesFood = elfFoodRepository.elvesFood
        val elvesTotalCalories = elfCamp.calculateElvesMaxCalories(elvesFood)
        elfCamp.elfWithMostCalories(elvesTotalCalories)