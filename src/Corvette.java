public class Corvette extends Ship {
    private String vendor;
    private Integer manufacturer_code;
  
    // Constructor by default
    Corvette () {
  
    }
  
    // Constructor with parameters
    Corvette (String name, Integer index, String vendor, Integer manufacturer_code) {
      super(name, index);
      this.vendor = vendor;
      this.manufacturer_code = manufacturer_code;
    }
  
    // Override of method equals()
    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!super.equals(obj)) return false;
      if (getClass() != obj.getClass()) return false;
      Corvette corvette = (Corvette) obj;
      return manufacturer_code == corvette.manufacturer_code && (vendor != null ? vendor.equals(corvette.vendor) : corvette.vendor == null);
    }
  
    // Override of method hashCode()
    @Override
    public int hashCode() {
      int result = super.hashCode();
      result = 31 * result + Integer.hashCode(manufacturer_code);
      result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
      return result;
    }
  
    // Override of method toString()
    @Override
    public String toString() {
      return "HouseholdEquipment {" +
      "name=" + get_name() + "\'" +
      ", age=" + get_index() +
      ", manufacturer_code=" + manufacturer_code +
      ", vendor=" + vendor + "\'" +
      "}";
    }
  
    // Getters and setters
    public void set_manufacturer_code(Integer manufacturer_code) {
      this.manufacturer_code = manufacturer_code;
    }
  
    public void set_vendor(String vendor) {
      this.vendor = vendor;
    }
  
    public Integer get_manufacturer_code() {
      return manufacturer_code;
    }
  
    public String get_vendor() {
      return vendor;
    }
  }