package 2022.food

case class Food(calories: Double = 0):
  def sumCalories(food: Food): Food = Food(calories = calories + food.calories)