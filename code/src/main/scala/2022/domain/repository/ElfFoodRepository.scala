package `2022`.domain

import  `2022`.domain.model.ElfFood

trait ElfFoodRepository:
    def elvesFood: List[ElfFood]