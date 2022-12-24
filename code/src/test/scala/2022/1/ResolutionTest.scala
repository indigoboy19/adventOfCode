import `2022`.ElfCamp

import org.scalatest.flatspec.AnyFlatSpec

import `2022`.domain.repository.elfFood.ElfFoodRepository
import `2022`.domain.repository.elfFood.ElfFoodRepositoryFromFile
import `2022`.domain.controller.elfFood.ElfFoodController

import org.scalatest.OptionValues.convertOptionToValuable

class ResolutionTest extends AnyFlatSpec {

    "Elf in camp, who is very lonely" should "has 6000 calories of food" in {
        assert(elfFoodRepository("src/test/scala/2022/1/resources/oneElfFood").value == 6000.0)
    }

    "Elf in camp, who found a partner" should "still not be the one with most food(7000 calories)" in {
        assert(elfFoodRepository("src/test/scala/2022/1/resources/twoElfFood").value == 7000.0)
    }

    def elfFoodRepository(path: String) =
        ElfFoodRepositoryFromFile(path)
            .map(elfFoodRepository =>
                ElfFoodController(ElfCamp(), elfFoodRepository).getElfMaxCalories.calories
            )

    
}
