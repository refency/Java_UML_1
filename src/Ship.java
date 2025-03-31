public class Ship {
  private String name;
  private Integer index;

  // Constructor by default
  Ship () {

  }

  // Constructor with parameters
  Ship (String name, Integer index) {
    this.name = name;
    this.index = index;
  }

  // Override of method equals()
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Ship ship = (Ship) obj;
    return index == ship.index && (name != null ? name.equals(ship.name) : ship.name == null);
  }

  // Override of method hashCode()
  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + index;
    return result;
  }

  // Override of method toString()
  @Override
  public String toString() {
    return " {name=" + name + ", index=" + index + "}";
  }

  // Getters and setters
  public void name(String name) {
    this.name = name;
  }

  public void set_index(Integer index) {
    this.index = index;
  }

  public String get_name() {
    return name;
  }

  public Integer get_index() {
    return index;
  }
}