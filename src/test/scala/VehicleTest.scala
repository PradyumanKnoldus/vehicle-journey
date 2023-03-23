import org.scalatest.flatspec.AnyFlatSpec

class VehicleTest extends AnyFlatSpec {

  val vehicle = new Vehicle()

  "A Vehicle" should "initialize with current fuel 50" in {
    assert(vehicle.getCurrentFuel == 50)
  }

  "A Vehicle" should "initialize with a non-negative fuel level" in {
    assertThrows[IllegalArgumentException] {
      new Vehicle(-10)
    }
  }

  it should "move the vehicle and consume fuel" in {
    val newVehicle = vehicle.moveVehicle()
    assert(newVehicle.getCurrentFuel == 30)
  }

  it should "refill the vehicle's fuel tank" in {
    val vehicle = new Vehicle(10)
    val newVehicle = vehicle.refuel()
    assert(newVehicle.getCurrentFuel == 50)
  }

  "A Vehicle" should "consume fuel when moving" in {
    // Moved 2 times
    vehicle.moveVehicle().moveVehicle().getCurrentFuel == 10
    // expecting 10 fuel remaining
  }

  "A Vehicle" should "consume fuel when moving and refill itself" in {
    // Moved 3 times
    vehicle.moveVehicle().moveVehicle().moveVehicle().getCurrentFuel == 30
    // expecting 30 fuel remaining
  }

}
