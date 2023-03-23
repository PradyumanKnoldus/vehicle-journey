class Vehicle(val currentFuel: Int = 50) {
  require(currentFuel >= 0, "Invalid fuel level")

  private val fuelCapacity: Int = 50

  // Method to get current Fuel
  def getCurrentFuel: Int = currentFuel

  // Method to move the vehicle consuming fuel
  def moveVehicle(): Vehicle = {

    val fuelConsumed = 20

    if (currentFuel > fuelConsumed) {
      val fuelRemaining = currentFuel - fuelConsumed
      new Vehicle(fuelRemaining)
    } else {
      refuel().moveVehicle()
    }
  }

  // Method to refill the vehicle's fuel tank
  def refuel(): Vehicle = {
    new Vehicle(fuelCapacity)
  }

}

